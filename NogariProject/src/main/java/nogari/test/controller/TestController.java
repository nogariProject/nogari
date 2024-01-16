package nogari.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nogari.test.service.TestService;

@RestController
public class TestController {
	
	@Autowired(required=true)
	private TestService service;
	
	@RequestMapping("/test")
	public List<Map<String, Object>> test(){
		List<Map<String, Object>> list = service.selectTest();
		
		System.out.println(list);
		
		return list;
	}
}
