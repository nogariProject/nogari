package nogari.system.log.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.error.ErrorContext;
import nogari.system.log.dao.mapper.ErrorLogMapper;
import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.domain.dto.ErrorLogReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ErrorLogServiceImpl implements ErrorLogService {
    private final ErrorLogMapper mapper;

    @Override
    public void createErrorLog(Throwable throwable, WebRequest request) {
        String errCause = ErrorContext.getErrorContext();
        ErrorLogDTO errorLogDTO = ErrorLogDTO.builder()
                .serPath(errCause)
                .reqPath(request.getDescription(false).replace("uri=", ""))
                .errType(throwable.getClass().getSimpleName())
                .errMsg(throwable.getMessage())
                .memberId("handmade")
                .build();

        try {
            mapper.insertErrorLog(errorLogDTO);
        } finally {
            ErrorContext.clear();   // 반드시 사용이 끝나면 clear 해주어야 한다.
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ErrorLogDTO> findErrorLogList(ErrorLogReqDTO reqDTO) {
        return mapper.selectErrorLogList(reqDTO);
    }
}
