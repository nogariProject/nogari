package com.example.springboot.login;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.login.domain.ResultVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService service;

	@GetMapping("/greeting")
	public String greetMember(@RequestParam String name) {
		return "Hello " + name;
	}
	
	@PostMapping("/login")
	public ResultVO<?> doLogin(@RequestBody Map<String, String>param) {
		return service.doLogin(param);
	}
	
	@PostMapping("/signup")
	public ResultVO<?> signup(@RequestBody Map<String, String>param) throws SQLException {
		return service.signup(param);
	}
	
	@GetMapping("/members")
	public ResultVO<?> getAllMembers(){
		return service.getAllMembers();
	}
}
