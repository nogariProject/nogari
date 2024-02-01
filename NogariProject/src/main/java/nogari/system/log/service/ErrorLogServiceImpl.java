package nogari.system.log.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.dao.mapper.ErrorLogMapper;
import nogari.system.log.domain.dto.ErrorLogDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ErrorLogServiceImpl implements ErrorLogService {

    private final ErrorLogMapper errlogMapper;

    @Override
    public List<ErrorLogDTO> findErrLog(ErrorLogDTO paramDto) {

       return errlogMapper.selectLogList(paramDto);
    }


    @Override
    public ErrorLogDTO errLogSave(ErrorLogDTO paramDto) throws Exception {

        int insCnt = errlogMapper.insertErrorLog(paramDto);

        ErrorLogDTO paramDTO = ErrorLogDTO.builder().rsltMsg("정상처리되었습니다.").build();

        return paramDTO;
    }
}
