package nogari.system.log.service;

import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.domain.dto.AccessLogReqDTO;

import java.util.List;

public interface AccessLogService {

    // 화면 접근 로그
    void createAccessLog(AccessLogDTO paramDTO);

    // 화면 접근 기록 리스트 조회
    List<AccessLogDTO> findAccessLogList(AccessLogReqDTO paramDTO);

}
