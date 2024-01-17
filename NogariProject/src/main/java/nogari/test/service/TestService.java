package nogari.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TestService {
	public List<Map<String, Object>> selectTest() throws Exception;
	public String insertTest(HashMap<String, String> map) throws Exception;
	public String deleteTest(HashMap<String, String> map) throws Exception;
	public String updateTest(HashMap<String, String> map) throws Exception;
}
