package nogari.system.log.service;

import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.domain.dto.ErrorLogReqDTO;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public interface ErrorLogService {

    void createErrorLog(Throwable throwable, WebRequest request);

    List<ErrorLogDTO> findErrorLogList(ErrorLogReqDTO reqDTO);
}
