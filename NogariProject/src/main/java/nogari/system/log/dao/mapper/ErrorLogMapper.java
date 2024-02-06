package nogari.system.log.dao.mapper;

import nogari.system.log.domain.dto.ErrorLogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ErrorLogMapper {

    int insertErrorLog(ErrorLogDTO paramDto);

    //에러 리스트조회
    List<ErrorLogDTO> selectErrorLogList(ErrorLogDTO paramDto);
}
