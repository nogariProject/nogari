package nogari.system.file.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    private static final String UPLOAD_DIR = "uploadDir";

    public void saveFile(List<MultipartFile> fileList, List<FileDTO> dtoList) throws IOException {
        String fileCd = UUID.randomUUID().toString();
        
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        for(int i = 0;i<dtoList.size();i++) {
            Path path = Paths.get(UPLOAD_DIR, UUID.randomUUID().toString());
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
    
    public ResponseEntity<Resource> downloadFile(List<FileDTO> dtoList) throws FileNotFoundException, IOException {
        File tempDir = new File("tempDir");
        if (!tempDir.exists()) {
            tempDir.mkdir();
        }
        
        // 단건
        if(dtoList.size()==1) {
            Path path = Paths.get(dtoList.get(0).getPath());
            FileSystemResource resource = new FileSystemResource(path.toFile());
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dtoList.get(0).getFileNm() + "\"")
                    .body(resource);
        }
        
        // 다건
        Path zipPath = Paths.get("tempDir", "files.zip");
        try (FileOutputStream fos = new FileOutputStream(zipPath.toFile());
                ZipOutputStream zos = new ZipOutputStream(fos)) {
            
            for (FileDTO dto : dtoList) {
                Path path = Paths.get(dto.getPath());
                if (Files.exists(path)) {
                    zos.putNextEntry(new ZipEntry(dto.getFileNm()));
                    Files.copy(path, zos);
                    zos.closeEntry();
                }
            }
            
        }
        
        FileSystemResource resource = new FileSystemResource(zipPath.toFile());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"files.zip\"")
                .body(resource);
    }
    
}
