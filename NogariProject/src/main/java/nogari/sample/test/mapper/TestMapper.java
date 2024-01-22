package nogari.sample.test.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	List<Map<String, Object>> selectTest();
	void insertTest(HashMap<String, String> map);
	void deleteTest(HashMap<String, String> map);
	void updateTest(HashMap<String, String> map);
}
