package com.example.springboot.login;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.login.domain.ResultVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LoginService service;

	@PostMapping("/login")
	public ResponseEntity<ResultVO<?>> doLogin(@RequestBody Map<String, String> param) throws Exception {
		ResultVO<?> resultVO = service.doLogin(param);
		HttpStatus status = resultVO.isError() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK;
		return new ResponseEntity<ResultVO<?>>(resultVO, status);
	}

	@PostMapping("/signup")
	public ResponseEntity<ResultVO<?>> signup(@RequestBody Map<String, String> param) throws Exception {
		ResultVO<?> resultVO = service.signup(param);
		HttpStatus status = resultVO.isError() ? HttpStatus.CONFLICT : HttpStatus.CREATED;
		return new ResponseEntity<ResultVO<?>>(resultVO, status);
	}

	@GetMapping("/members")
	public ResponseEntity<ResultVO<?>> getAllMembers() {
		ResultVO<?> resultVO = service.getAllMembers();
		return new ResponseEntity<ResultVO<?>>(resultVO, HttpStatus.OK);
	}
}
