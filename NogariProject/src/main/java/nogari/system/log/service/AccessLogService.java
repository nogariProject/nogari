package nogari.system.log.service;

import nogari.system.log.domain.dto.AccessLogDTO;

import java.util.List;

public interface AccessLogService {
    List<AccessLogDTO> findAccessLog(AccessLogDTO paramDTO);

    AccessLogDTO errAccessLogSave(AccessLogDTO paramDto) throws Exception;
}
