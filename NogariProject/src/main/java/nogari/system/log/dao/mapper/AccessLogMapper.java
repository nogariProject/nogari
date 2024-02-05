package nogari.system.log.dao.mapper;

import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.domain.dto.AccessLogReqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessLogMapper {
    int insertAccessLog(AccessLogDTO paramDTO);
    List<AccessLogDTO> selectAccessLogList(AccessLogReqDTO paramDTO);
}
