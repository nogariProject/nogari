package nogari.global.file.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.file.domain.dto.FileDownReqDTO;
import nogari.global.file.domain.dto.FileDownRespDTO;
import nogari.global.file.domain.dto.FileUpReqDTO;
import nogari.global.file.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileService fileService;

    /**
     * <pre>
     *     파일 업로드 API
     * </pre>
     * @param fileList      업로드할 파일 리스트 (form-data type:file)
     * @param fileUpReqDTO  파일 업로드 유저 정보
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseEntity<String> fileUpload(@RequestPart(value="fileList") List<MultipartFile> fileList, @RequestPart FileUpReqDTO fileUpReqDTO) throws IOException {

        int result = fileService.uploadFile(fileList, fileUpReqDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result + "건의 파일 업로드 성공");
    }

    /**
     * <pre>
     *     파일 다운로드 API
     * </pre>
     * @param fileDownReqDTOList    파일 다운로드 필요 정보 (fileCd, seq, fileNm)
     * @return  단건 : 파일 리턴, 다건 : 파일 압축 후 리턴
     */
    @PostMapping("/download")
    public ResponseEntity<Resource> fileDownload(@RequestBody List<FileDownReqDTO> fileDownReqDTOList){

        FileDownRespDTO fileDownRespDTO = fileService.downloadFile(fileDownReqDTOList);

        Resource resource = fileDownRespDTO.getFileResource();

        int result = fileDownRespDTO.getResult();

        return ResponseEntity.status(HttpStatus.OK)
                .header(result + "건의 파일 다운로드 성공")
                .body(resource);
    }
}
