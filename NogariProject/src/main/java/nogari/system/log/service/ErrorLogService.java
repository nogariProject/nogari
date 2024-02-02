package nogari.system.log.service;

import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.domain.dto.ErrorLogReqDTO;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public interface ErrorLogService {

    // DB에 기록할 에러 신규 저장
    void createErrorLog(Throwable throwable, WebRequest request);

    // 에러 로그 기록 리스트 조회
    List<ErrorLogDTO> findErrorLogList(ErrorLogReqDTO reqDTO);

}
