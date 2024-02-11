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
    public int createAccessLog(AccessLogDTO paramDTO) {
        return mapper.insertAccessLog(paramDTO);
    }

    @Override
    public List<AccessLogDTO> findAccessLogList(AccessLogReqDTO paramDTO) {
        return mapper.selectAccessLogList(paramDTO);
    }
}
