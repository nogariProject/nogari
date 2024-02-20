package nogari.system.log.service;

import nogari.system.log.domain.entity.ErrLog;

public interface ErrLogService {

    public void getAllErrors();

    public void createError(ErrLog errLog);
}
