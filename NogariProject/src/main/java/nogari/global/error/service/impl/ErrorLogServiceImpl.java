package nogari.global.error.service.impl;

import nogari.global.error.DTO.ErrorLogDTO;
import nogari.global.error.dao.mapper.ErrorLogMapper;
import nogari.global.error.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ErrorLogServiceImpl implements ErrorLogService{
	
	@Autowired
	ErrorLogMapper mapper;
	
	public List<Map<String, Object>> selectTest() {
		return mapper.selectTest();
	}
	
//	public String saveError(ErrorLogDTO edto) {
//
//		//mapper.saveError(edto);
//
//		return "에러로그저장됨";
//	}
	
	
}
