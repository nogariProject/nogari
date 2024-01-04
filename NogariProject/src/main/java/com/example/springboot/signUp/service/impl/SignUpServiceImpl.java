package com.example.springboot.signUp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.MemberEntity;
import com.example.springboot.signUp.repository.SignUpRepository;
import com.example.springboot.signUp.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private SignUpRepository repository;
	
	public String signUp(String id, String name, String password) {
		
		if(repository.existsById(id)) {
			return "중복 아이디";
		} else {
			MemberEntity member = new MemberEntity();
			member.setId(id);
			member.setName(name);
			member.setPassword(password);
			repository.save(member); 
			
			return "signUp!!";
		}
	}
	
}