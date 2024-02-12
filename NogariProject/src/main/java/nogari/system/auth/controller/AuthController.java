package nogari.system.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nogari.system.auth.domain.dto.AuthDtlDTO;
import nogari.system.auth.domain.dto.AuthMstDTO;
import nogari.system.auth.service.AuthService;

@RestController
@RequestMapping("/auths")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	/*
	 *  200:OK      - 성공
	 *  201:CREATED - 요청성공+새로운리소스생성
	 */
	
	// 권한조회
	@GetMapping
	public ResponseEntity<List<AuthMstDTO>> authList( @RequestParam(required = false) String groupCd
									  , @RequestParam(required = false) String groupNm) {
		
		List<AuthMstDTO> resultList = authService.findAuth(groupCd, groupNm);
		
		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}
	
	// 권한상세조회
	@GetMapping("/{authCd}")
	public ResponseEntity<List<AuthDtlDTO>> authMenuList(@PathVariable String authCd) {
		
		List<AuthDtlDTO> resultList = authService.findAuthMenu(authCd);
		
		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}
	
	// 권한등록
	@PostMapping
	public ResponseEntity<String> authSave(@RequestBody List<AuthMstDTO> authList) {
		authService.createAuth(authList);
		return new ResponseEntity<>("권한등록완료!", HttpStatus.CREATED);
	}
	
	// 권한상세등록
	@PostMapping("/{authCd}")
	public ResponseEntity<String> authMenuSave(@PathVariable String authCd, @RequestBody List<AuthDtlDTO> authMenuList) {
		authService.createAuthMenu(authMenuList);
		return new ResponseEntity<>("권한상세등록완료!", HttpStatus.CREATED);
	}
	
	// 권한수정
	@PutMapping
	public ResponseEntity<String> authModify(@RequestBody List<AuthMstDTO> authList) {
		authService.editAuth(authList);
		return new ResponseEntity<>("권한수정완료!", HttpStatus.OK);
	}
	
	// 권한상세수정
	@PutMapping("/{authCd}")
	public ResponseEntity<String> authMenuModify(@PathVariable String authCd, @RequestBody List<AuthDtlDTO> authMenuList) {
		authService.editAuthMenu(authMenuList);
		return new ResponseEntity<>("권한상세수정완료!", HttpStatus.OK);
	}
	
	// 권한삭제
	@DeleteMapping
	public ResponseEntity<String> authDelete(@RequestBody List<AuthMstDTO> menuCdList) {
		authService.deleteAuth(menuCdList);
		return new ResponseEntity<>("권한삭제완료!", HttpStatus.OK);
	}

	// 권한상세삭제
	@DeleteMapping("/{authCd}")
	public ResponseEntity<String> authMenuDelete(@PathVariable String authCd, @RequestBody List<AuthDtlDTO> authMenuList) {
		authService.deleteAuthMenu(authMenuList);
		return new ResponseEntity<>("권한상세삭제완료!", HttpStatus.OK);
	}
}
