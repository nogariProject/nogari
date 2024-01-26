package nogari.system.log.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ErrorLogMapper {
    void insertErrorLog();
}
