//package nogari.test.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import nogari.entity.TestEntity;
//import nogari.test.repository.TestRepository;
//import nogari.test.service.TestService;
//
//@Service("testService")
//public class TestServiceImpl implements TestService {
//	
//	@Autowired
//	private TestRepository testRepository;
//	
//	public void test() {
//		TestEntity test = new TestEntity();
//		test.setId("test01");
//		test.setName("user");
//		test.setPassword("qwer1234");
//		testRepository.save(test); 
//	}
//	
//}
