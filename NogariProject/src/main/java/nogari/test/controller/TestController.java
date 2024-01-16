package nogari.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nogari.test.service.TestService;

@RestController
public class TestController {
	
	@Autowired(required=true)
	private TestService service;
	
	@RequestMapping("/select-test")
	public List<Map<String, Object>> selectTest(){
		List<Map<String, Object>> list = service.selectTest();
		
		return list;
	}
	
	@RequestMapping("/insert-test")
	public String insertTest(@RequestBody HashMap<String, String> map){
		String str = service.insertTest(map);
		
		return str;
	}
	
	@RequestMapping("/delete-test")
	public String deleteTest(@RequestBody HashMap<String, String> map){
		String str = service.deleteTest(map);
		
		return str;
	}
	
	@RequestMapping("/update-test")
	public String updateTest(@RequestBody HashMap<String, String> map){
		String str = service.updateTest(map);
		
		return str;
	}
}