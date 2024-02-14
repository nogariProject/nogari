package nogari.global.file.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.file.dao.mapper.FileMapper;
import nogari.global.file.domain.dto.FileDTO;
import nogari.global.file.domain.dto.FileDownReqDTO;
import nogari.global.file.domain.dto.FileDownRespDTO;
import nogari.global.file.domain.dto.FileUpReqDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileMapper mapper;

    // 파일 절대 경로
    @Value("${file.upload-dir}")
    private String uploadPathRoot;

    /**
     * <pre>
     *     파일 저장
     * </pre>
     *
     * @param fileList          업로드할 파일 리스트
     * @param fileUpReqDTO      업로드 관련 필요 정보 (유저정보)
     * @return
     * @throws IOException
     */
    public int uploadFile(List<MultipartFile> fileList, FileUpReqDTO fileUpReqDTO) throws IOException {

        // 업로드한 파일 수 리턴 예정
        int result = 0;

        String uploadPath = uploadPathRoot + "/" + makeTodayDate();
        String fileCd = UUID.randomUUID().toString().replace("-", "");

        // 실제 파일 저장 경로 생성
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // 디렉토리가 존재하지 않는다면 생성
        }

        for(int i=0; i<fileList.size(); i++) {
            String fileName = fileList.get(i).getOriginalFilename();
            FileDTO fileDTO = null;

            log.info(uploadPath);

            fileDTO = FileDTO.builder()
                    .fileCd(fileCd)
                    .fileNm(fileName)
                    .path(uploadPath + "/" + UUID.randomUUID().toString().replace("-", ""))
                    .fileSize(String.valueOf(fileList.get(i).getSize()))
                    .userId(fileUpReqDTO.getUserId())
                    .build();


            log.info(fileDTO.toString());
            log.info("Uploading to: {}", uploadPath + "/" + fileDTO.getFileNm());
            log.info("Uploading to: {}", fileDTO.getPath());

            // 업로드하는 파일 정보 DB 저장
            result += mapper.insertFile(fileDTO);

            // 파일 저장 로직 추가
            //File targetFile = new File(uploadDir, fileDTO.getFileNm());
            File targetFile = new File(fileDTO.getPath());
            log.info("Attempting to save file to: {}", targetFile.getAbsolutePath());
            fileList.get(i).transferTo(targetFile); // 파일 저장

        }

        return result;

    }

    /**
     * <pre>
     *     파일 다운로드
     * </pre>
     * @param fileDownReqDTOList    다운로드할 파일 정보
     * @return FileDownRespDTO     다운로드하는 파일과 다운로드하는 파일 수
     */
    @Override
    public FileDownRespDTO downloadFile(List<FileDownReqDTO> fileDownReqDTOList) {

        // 다운로드한 파일 수 리턴 예정
        int result = 0;
        // 컨트롤러에 다운로드할 파일(Resource)와 다운로드 파일 수(result) 전달용 DTO
        FileDownRespDTO fileDownRespDTO = new FileDownRespDTO();

        // 파일 압축용 임시 저장 경로
        File tempDir = new File("tempDownload/"+makeTodayDate());
        if(!tempDir.exists()){
            tempDir.mkdirs();
        }

        // 단건 파일 다운로드 로직
        if(fileDownReqDTOList.size() == 1 ){
            FileDTO fileDTO = FileDTO.builder().fileCd(fileDownReqDTOList.get(0).getFileCd()).seq(fileDownReqDTOList.get(0).getSeq()).fileNm(fileDownReqDTOList.get(0).getFileNm()).build();
            File file = new File(mapper.selectPath(fileDTO));
            FileSystemResource resource = new FileSystemResource(file);
            fileDownRespDTO.setResult(1);
            fileDownRespDTO.setFileResource(resource);

            return fileDownRespDTO;
        }

        // 다건 파일 다운로드 로직
        File zipFile = new File(tempDir, makeTodayTime());
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for(FileDownReqDTO fileDownReqDTO : fileDownReqDTOList){
                FileDTO fileDTO = FileDTO.builder()
                        .fileCd(fileDownReqDTO.getFileCd()).seq(fileDownReqDTO.getSeq())
                        .fileNm(fileDownReqDTO.getFileNm()).build();

                log.info("fileDownReqDTO : " + fileDownReqDTO.toString());
                log.info(fileDTO.toString());
                log.info(mapper.selectPath(fileDTO));
                File file = new File(mapper.selectPath(fileDTO));
                if(file.exists()){
                    result += 1;
                    ZipEntry zipEntry = new ZipEntry(fileDTO.getFileNm());
                    zos.putNextEntry(zipEntry);
                    Path path = file.toPath();
                    Files.copy(path, zos);
                    zos.closeEntry();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 리턴할 fileDownRespDTO 셋팅
        FileSystemResource resource = new FileSystemResource(zipFile);
        fileDownRespDTO.setResult(result);
        fileDownRespDTO.setFileResource(resource);

        return fileDownRespDTO;
    }

    // 저장될 파일 경로를 날짜별로 생성하기 위해 날짜 추가
    private String makeTodayDate(){

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatterToday = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedToday = today.format(formatterToday);
        System.out.println(formattedToday);
        return formattedToday;
    }

    // 파일 저장시 파일명 생성용 현재 시간 생성 메소드
    private String makeTodayTime(){

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatterToday = DateTimeFormatter.ofPattern("hhmmss");
        String formattedToday = now.format(formatterToday);
        System.out.println(formattedToday);
        return formattedToday;
    }





}
