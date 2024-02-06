package nogari.system.log.service;

import nogari.system.log.domain.dto.ErrorLogDTO;

import java.util.List;

public interface ErrorLogService {
    List<ErrorLogDTO> findErrLog(ErrorLogDTO paramDto);

    ErrorLogDTO errLogSave(ErrorLogDTO paramDto) throws Exception;
}
