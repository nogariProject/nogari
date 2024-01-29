package nogari.global.error.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import nogari.global.error.DTO.ErrorLogDTO;

@Mapper
public interface ErrorLogMapper {
	
	List<Map<String,Object>> selectTest();
	void saveError(ErrorLogDTO edto);
}
