package nogari.system.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nogari.system.auth.dao.mapper.AuthMapper;
import nogari.system.auth.domain.dto.AuthDtlDTO;
import nogari.system.auth.domain.dto.AuthMstDTO;
import nogari.system.auth.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthMapper authMapper;

	// 권한조회
	@Override
	public List<AuthMstDTO> findAuth(String authCd, String authNm) {
		return authMapper.selectAuthList(authCd, authNm);
	}

	// 권한상세조회
	@Override
	public List<AuthDtlDTO> findAuthMenu(String authCd) {
		return authMapper.selectAuthMenuList(authCd);
	}

	// 권한등록
	@Override
	public void createAuth(List<AuthMstDTO> authList) {
		
		for(AuthMstDTO arr : authList) {
			authMapper.insertAuth(arr);
		}
		
	}

	// 권한상세등록
	@Override
	public void createAuthMenu(List<AuthDtlDTO> authMenuList) {
		
		for(AuthDtlDTO arr : authMenuList) {
			authMapper.insertAuthMenu(arr);
		}
		
	}

	// 권한수정
	@Override
	public void editAuth(List<AuthMstDTO> authList) {

		for(AuthMstDTO arr : authList) {
			authMapper.updateAuth(arr);
		}
		
	}

	// 권한상세수정
	@Override
	public void editAuthMenu(List<AuthDtlDTO> authMenuList) {
		
		for(AuthDtlDTO arr : authMenuList) {
			authMapper.updateAuthMenu(arr);
		}
		
	}

	// 권한삭제
	@Override
	public void deleteAuth(List<AuthMstDTO> authList) {
		
		for(AuthMstDTO authCd : authList) {			
			AuthDtlDTO dtl = AuthDtlDTO.builder().authCd(authCd.getAuthCd()).build();
			
			authMapper.deleteAuthMenu(dtl);
			authMapper.deleteAuth(authCd);
		}
		
	}
	
	// 권한상세수정
	@Override
	public void deleteAuthMenu(List<AuthDtlDTO> authMenuList) {
		
		for(AuthDtlDTO arr : authMenuList) {
			authMapper.deleteAuthMenu(arr);
		}
		
	}
}
