package nogari.system.log.dao.repository;

import nogari.system.log.domain.entity.ErrLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrLogRepository extends CrudRepository<ErrLog,String> {
}
