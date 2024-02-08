package nogari.system.auth.service;

import java.util.List;

import nogari.system.auth.domain.dto.AuthDtlDTO;
import nogari.system.auth.domain.dto.AuthMstDTO;

public interface AuthService {
	// 조회
	List<AuthMstDTO> findAuth(String authCd, String authNm);
	List<AuthDtlDTO> findAuthMenu(String authCd);
	
	// 저장
	void createAuth(List<AuthMstDTO> authList);
	void createAuthMenu(List<AuthDtlDTO> authMenuList);
	
	// 수정
	void editAuth(List<AuthMstDTO> authList);
	void editAuthMenu(List<AuthDtlDTO> authMenuList);
	
	// 삭제
	void deleteAuth(List<AuthMstDTO> authList);
	void deleteAuthMenu(List<AuthDtlDTO> authMenuList);
}
