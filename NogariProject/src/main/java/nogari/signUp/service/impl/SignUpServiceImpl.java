package nogari.signUp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nogari.entity.MemberEntity;
import nogari.signUp.repository.SignUpRepository;
import nogari.signUp.service.SignUpService;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private SignUpRepository repository;
	
	public String signUp(String id, String name, String password) throws Exception {
		
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