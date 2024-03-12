package nogari.system.file.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import nogari.system.file.dao.mapper.FileMapper;
import nogari.system.file.domain.dto.FileDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileMapper mapper;

    @Value("${file.path}")
    private String PROFILE;
    private final String UPLOAD_DIR = "uploadDir";
    private final String ZIP_DIR = "tempDir";
    private final String ZIP_NAME = "files.zip";

    private String setPath() {
        String pattern = "/yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        return PROFILE + UPLOAD_DIR + date;
    }

    private void mkDir(String dir) {
        File directory = new File(dir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private void mkZip(Path path, List<FileDTO> dtoList) throws FileNotFoundException, IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path.toFile()))) {
            for (FileDTO dto : dtoList) {
                Path aPath = Paths.get(dto.getPath());
                if (Files.exists(aPath)) {
                    zos.putNextEntry(new ZipEntry(dto.getFileNm()));
                    Files.copy(aPath, zos);
                    zos.closeEntry();
                }
            }
        }
    }

    @Override
    public List<FileDTO> findFile(FileDTO dto) {
        return mapper.selectFile(dto);
    }

    @Override
    public void saveFile(List<MultipartFile> fileList, List<FileDTO> dtoList) throws IOException {
        String uploadDir = setPath();
        mkDir(uploadDir);

        String fileCd = UUID.randomUUID().toString();
        for (int i = 0; i < dtoList.size(); i++) {
            Path path = Paths.get(uploadDir, UUID.randomUUID().toString());
            dtoList.set(i, FileDTO.builder()
                   .file(fileList.get(i))
                   .fileCd(fileCd)
                   .fileNm(fileList.get(i).getOriginalFilename())
                   .size(fileList.get(i).getSize())
                   .path(path.toString())
                   .id(dtoList.get(i).getId())
                   .build());

            fileList.get(i).transferTo(path);
            mapper.insertFile(dtoList.get(i));
        }
    }

    @Override
    public ResponseEntity<Resource> downloadFile(List<FileDTO> dtoList) throws FileNotFoundException, IOException {
        Path path;
        String name;
        
        String zipDir = PROFILE + ZIP_DIR;
        mkDir(zipDir);

        for (FileDTO dto : dtoList) {
            dto.setPath(mapper.selectFilePath(dto).get("PATH"));
        }

        if (dtoList.size() == 1) { // 단건
            path = Paths.get(dtoList.get(0).getPath());
            name = dtoList.get(0).getFileNm();
        } else { // 다건
            path = Paths.get(zipDir, ZIP_NAME);
            name = ZIP_NAME;
            mkZip(path, dtoList);
        }
        
        FileSystemResource resource = new FileSystemResource(path.toFile());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + name + "\"").body(resource);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void editFile(List<FileDTO> dtoList) {
        for (FileDTO dto : dtoList) {
            mapper.updateFile(dto);
        }
    }

}
