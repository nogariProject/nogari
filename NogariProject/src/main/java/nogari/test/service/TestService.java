package nogari.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TestService {
	public List<Map<String, Object>> selectTest();
	public String insertTest(HashMap<String, String> map);
	public String deleteTest(HashMap<String, String> map);
	public String updateTest(HashMap<String, String> map);
}
