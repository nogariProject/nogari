package com.example.springboot.signUp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.signUp.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired(required=true)
	private SignUpService service;
	
	@RequestMapping("/sign-up")
	public String signUp(@RequestBody HashMap<String, String> map){
		String id = map.get("id");
		String name = map.get("name");
		String password = map.get("password");
		
		return service.signUp(id, name, password);
	}
}