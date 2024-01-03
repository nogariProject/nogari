package com.example.springboot.account.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.account.service.AccountService;
import com.example.springboot.entity.MemberEntity;

@RestController
public class AccountController {
	
	@Autowired(required=true)
	private AccountService service;
	
	// 조회
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public List<MemberEntity> selectAccount() {
		List<MemberEntity> members = service.selectAccount();
		
		return members;
	}
	
	// 변경
	@RequestMapping(value = "/account", method = RequestMethod.PUT)
	public String updateAccount(@RequestBody HashMap<String, String> map) {
		String id = map.get("id");
		String password = map.get("password");
		String newName = map.get("newName");
		String newPassword = map.get("newPassword");
		
		return service.updateAccount(id, password, newName, newPassword);
	}
	
	// 탈퇴
	@RequestMapping(value = "/account", method = RequestMethod.DELETE)
	public String deleteAccount(@RequestBody HashMap<String, String> map) {
		String id = map.get("id");
		String password = map.get("password");
		
		return service.deleteAccount(id, password);
	}
}