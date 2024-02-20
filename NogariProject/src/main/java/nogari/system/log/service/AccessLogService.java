package nogari.system.log.service;

import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.domain.dto.AccessLogReqDTO;

import java.util.List;

public interface AccessLogService {
    void createAccessLog(AccessLogDTO paramDTO);
    List<AccessLogDTO> findAccessLogList(AccessLogReqDTO paramDTO);
}
