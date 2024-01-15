//package nogari.test.controller;
//
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import nogari.entity.TestEntity;
//import nogari.test.repository.TestRepository;
//import nogari.test.service.TestService;
//
//@RestController
//public class TestController {
//	
//	@Autowired(required=true)
//	private TestService service;
//	
//	@Autowired
//	private TestRepository testRepository;
//	
//	@RequestMapping("/test")
//	public String test(){
//		//service.test();
//		
//		TestEntity test = new TestEntity();
//		test.setId("test01");
//		test.setName("user");
//		test.setPassword("qwer1234");
//		testRepository.save(test);
//		
//		return test.toJson();
//	}
//}