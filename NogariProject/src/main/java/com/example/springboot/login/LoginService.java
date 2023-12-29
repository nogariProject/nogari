package com.example.springboot.login;

import java.util.List;
import java.util.Map;

import com.example.springboot.login.domain.MemberDTO;
import com.example.springboot.login.domain.Member;
import com.example.springboot.login.domain.ResultVO;

public interface LoginService {

	/*
	 * 로그인
	 */
	ResultVO<MemberDTO> doLogin(Map<String, String> param) throws Exception;

	/*
	 * 회원가입
	 */
	ResultVO<String> signup(Map<String, String> param) throws Exception;

	/*
	 * 모든 멤버 보기
	 */
	ResultVO<List<MemberDTO>> getAllMembers();

}