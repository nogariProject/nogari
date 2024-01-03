package com.example.springboot.signIn.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.signIn.service.SignInService;

@RestController
public class SignInController {
	
	@Autowired(required=true)
	private SignInService service;
	
	@RequestMapping("/sign-in")
	public String signIn(@RequestBody HashMap<String, String> map){
		String id = map.get("id");
		String password = map.get("password");
		
		return service.signIn(id, password);
	}
}