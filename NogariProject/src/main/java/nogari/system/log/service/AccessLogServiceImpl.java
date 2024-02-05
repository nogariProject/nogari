package nogari.system.log.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.dao.mapper.AccessLogMapper;
import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.domain.dto.AccessLogReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AccessLogServiceImpl implements AccessLogService {
    private final AccessLogMapper mapper;

    @Override
    public void createAccessLog(AccessLogDTO paramDTO) {
        int cnt = mapper.insertAccessLog(paramDTO); // update 3 2건 1001 10011 0
//        if(cnt < 1) {
//            throw new DatabaseException(ErrorCode.INTERNAL_SERVER_ERROR, "요청 건수 1건 중  " + cnt + "건이 처리 되었습니다." );
//        }
    }

    @Override
    public List<AccessLogDTO> findAccessLogList(AccessLogReqDTO paramDTO) {
        return mapper.selectAccessLogList(paramDTO);
    }
}
