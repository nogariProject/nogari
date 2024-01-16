package nogari.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import nogari.test.mapper.TestMapper;
import nogari.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper mapper;
	
	public List<Map<String, Object>> selectTest() {
		
		return mapper.selectTest();
	}
	
}