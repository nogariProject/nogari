package nogari.system.log.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.dao.mapper.AccessLogMapper;
import nogari.system.log.dao.mapper.ErrorLogMapper;
import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.domain.dto.ErrorLogDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccessLogServiceImpl implements AccessLogService{

    private final AccessLogMapper accessLogMapper;

    @Override
    public List<AccessLogDTO> findAccessLog(AccessLogDTO paramDTO) {
       return accessLogMapper.selectAccessLogList(paramDTO);
    }

    @Override
    public AccessLogDTO errAccessLogSave(AccessLogDTO paramDto) throws Exception {

        int insCnt = accessLogMapper.insertAccessLog(paramDto);

        AccessLogDTO resultDto = AccessLogDTO.builder().rsltMsg("정상처리되었습니다.").build();

        return resultDto;
    }
}// end class
