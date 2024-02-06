package nogari.system.log.dao.mapper;

import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.domain.dto.ErrorLogReqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ErrorLogMapper {
    int insertErrorLog(ErrorLogDTO paramDto);

    List<ErrorLogDTO> selectErrorLogList(ErrorLogReqDTO paramDto);
}
