package nogari.global.file.service;

import nogari.global.file.domain.dto.FileDownReqDTO;
import nogari.global.file.domain.dto.FileDownRespDTO;
import nogari.global.file.domain.dto.FileUpReqDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    /**
     * <pre>
     *     파일 저장
     * </pre>
     * @param fileList          업로드할 파일 리스트
     * @param fileUpReqDTO      업로드 관련 필요 정보 (유저정보)
     * @return
     * @throws IOException
     */
    int uploadFile(List<MultipartFile> fileList, FileUpReqDTO fileUpReqDTO) throws IOException;

    /**
     * <pre>
     *     파일 다운로드
     * </pre>
     * @param fileDownReqDTOList    다운로드할 파일 정보
     * @return FileDownRespDTO     다운로드하는 파일과 다운로드하는 파일 수
     */
    FileDownRespDTO downloadFile(List<FileDownReqDTO> fileDownReqDTOList);
}
