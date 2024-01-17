package nogari.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nogari.test.mapper.TestMapper;
import nogari.test.service.TestService;

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper mapper;
	
	public List<Map<String, Object>> selectTest() throws Exception {
		
		return mapper.selectTest();
	}
	
	public String insertTest(HashMap<String, String> map) throws Exception {
		
		mapper.insertTest(map);
		
		return "insert 완료";
	}
	
	public String deleteTest(HashMap<String, String> map) throws Exception {
		
		mapper.deleteTest(map);
		
		return "delete 완료";
	}
	
	public String updateTest(HashMap<String, String> map) throws Exception {
		
		mapper.updateTest(map);
		
		return "update 완료";
	}
}
