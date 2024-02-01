package nogari.system.auth.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import nogari.system.auth.domain.dto.AuthDtlDTO;
import nogari.system.auth.domain.dto.AuthMstDTO;

@Mapper
public interface AuthMapper {
	
	// 조회
	List<AuthMstDTO> selectAuthList(@Param("authCd") String authCd, @Param("authNm") String authNm);
	List<AuthDtlDTO> selectAuthMenuList(@Param("authCd") String authCd);
	
	// 저장
	void insertAuth(AuthMstDTO authMstDTO);
	void insertAuthMenu(AuthDtlDTO authDtlDTO);
	
	// 수정
	void updateAuth(AuthMstDTO authMstDTO);
	void updateAuthMenu(AuthDtlDTO authDtlDTO);
	
	// 삭제
	void deleteAuth(AuthMstDTO authMstDTO);
	void deleteAuthMenu(AuthDtlDTO authDtlDTO);
}
