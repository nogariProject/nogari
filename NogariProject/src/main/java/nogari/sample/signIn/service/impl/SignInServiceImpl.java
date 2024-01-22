package nogari.sample.signIn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nogari.sample.domain.entity.MemberEntity;
import nogari.sample.signIn.repository.SignInRepository;
import nogari.sample.signIn.service.SignInService;

@Service
@Transactional
public class SignInServiceImpl implements SignInService {
	
	@Autowired
	private SignInRepository repository;
	
	public String signIn(String id, String password) {
		
		if(repository.existsById(id)) {
			MemberEntity member = new MemberEntity();
			member = repository.getReferenceById(id);
			if(member.getPassword().equals(password)) {
				return member.getName() + " 로그인";
			} else {
				return "비밀번호 다름";
			}
		} else {
			return "없는 아이디";
		}
	}
	
}