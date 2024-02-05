package nogari.global.error.service;

import java.util.List;
import java.util.Map;

import nogari.global.error.DTO.ErrorLogDTO;

public interface ErrorLogService {
	public List<Map<String, Object>> selectTest();
	//public String saveError(ErrorLogDTO edto);
}
