package nogari.system.log.dao.mapper;

import nogari.system.log.domain.dto.AccessLogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessLogMapper {
    List<AccessLogDTO> selectAccessLogList(AccessLogDTO paramDTO);

    int insertAccessLog(AccessLogDTO paramDto);
}// end class
