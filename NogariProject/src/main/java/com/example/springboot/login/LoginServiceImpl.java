package com.example.springboot.login;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.springboot.login.domain.MemberVO;
import com.example.springboot.login.domain.ResultVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	private final LoginMapper mapper;

	@Override
	public ResultVO<String> doLogin(Map<String, String> param) {
		ResultVO<String> resultVO = new ResultVO<>();

		MemberVO member = mapper.selectMemberById(param);
		if (member == null) {
			resultVO.setError(true);
			resultVO.setMessage("Not Member!");
		} else {
			resultVO.setData("Welcome back " + member.getName());
		}

		return resultVO;
	}

	@Override
	public ResultVO<String> signup(Map<String, String> param) throws SQLException {
		ResultVO<String> resultVO = new ResultVO<>();
		MemberVO member = mapper.selectMemberById(param);
		String welcomeMessage = "";
		if (member == null) {
			mapper.insertMember(param);
			welcomeMessage = "Welcome " + param.get("NAME");
		} else {
			welcomeMessage = "You're already our member, " + member.getName();
		}
		resultVO.setData(welcomeMessage);
		return resultVO;
	}

	@Override
	public ResultVO<List<MemberVO>> getAllMembers() {
		ResultVO<List<MemberVO>> resultVO = new ResultVO<>();
		resultVO.setData(mapper.selectAllMembers());
		return resultVO;
	}

}
