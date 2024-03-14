package nogari.system.log.service;

import lombok.AllArgsConstructor;
import nogari.system.log.dao.repository.ErrLogRepository;
import nogari.system.log.domain.entity.ErrLog;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ErrLogServiceImp implements ErrLogService {
    private final ErrLogRepository errLogRepository;

    @Override
    public void getAllErrors() {

    }
    @Override
    public void createError(ErrLog errLog) {
        errLogRepository.save(errLog);
    }
}
