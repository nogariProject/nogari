package com.example.springboot.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.MemberEntity;
import com.example.springboot.account.repository.AccountRepository;
import com.example.springboot.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public List<MemberEntity> selectAccount() {
		List<MemberEntity> members;
		members = repository.findAll();
		
		return members;
	}
	public String updateAccount(String id, String password, String newName, String newPassword) {
		if(repository.existsById(id)) {
			MemberEntity member = new MemberEntity();
			member = repository.getReferenceById(id);
			if(member.getPassword().equals(password)) {
				member.setName(newName);
				member.setPassword(newPassword);
				repository.save(member); 
				return "수정";
			} else {
				return "비밀번호 다름";
			}
		} else {
			return "없는 아이디";
		}
	}
	public String deleteAccount(String id, String password) {
		if(repository.existsById(id)) {
			MemberEntity member = new MemberEntity();
			member = repository.getReferenceById(id);
			if(member.getPassword().equals(password)) {
				repository.deleteById(id);
				return "삭제";
			} else {
				return "비밀번호 다름";
			}
		} else {
			return "없는 아이디";
		}
	}
	
}