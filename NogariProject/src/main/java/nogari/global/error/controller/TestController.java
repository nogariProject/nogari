package nogari.global.error.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nogari.global.error.DTO.TestDTO;
import nogari.global.error.service.TestService;


@RestController
public class TestController {

	@Autowired
	TestService testService;
	
	@PostMapping("/test")
	public String test(@RequestBody @Valid TestDTO dto) throws Exception {
		testService.testServ();
		return "";
	}
	
}
