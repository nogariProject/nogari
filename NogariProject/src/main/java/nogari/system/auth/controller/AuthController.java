package nogari.system.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nogari.system.auth.domain.AuthDtlDTO;
import nogari.system.auth.domain.AuthMstDTO;
import nogari.system.auth.service.AuthService;

@RestController
@RequestMapping("/auths")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@GetMapping
	public List<AuthMstDTO> authList( @RequestParam(required = false) String groupCd
									  , @RequestParam(required = false) String groupNm) {
		return authService.findAuth(groupCd, groupNm);
	}
	
	@GetMapping("/{authCd}")
	public List<AuthDtlDTO> authMenuList(@PathVariable String authCd) {
		return authService.findAuthMenu(authCd);
	}
	
	@PostMapping
	public String authSave(@RequestBody List<AuthMstDTO> authList) {
		authService.createAuth(authList);
		return "Auth saved!";
	}
	
	@PostMapping("/{authCd}")
	public String authMenuSave(@PathVariable String authCd, @RequestBody List<AuthDtlDTO> authMenuList) {
		authService.createAuthMenu(authMenuList);
		return "AuthMenu saved!";
	}
	
	
	
	@PutMapping
	public String authModify(@RequestBody List<AuthMstDTO> authList) {
		authService.editAuth(authList);
		return "Auth Modify!";
	}
	
	@PutMapping("/{authCd}")
	public String authMenuModify(@PathVariable String authCd, @RequestBody List<AuthDtlDTO> authMenuList) {
		authService.createAuthMenu(authMenuList);
		return "AuthMenu Modify!";
	}
	
	@DeleteMapping
	public String authDelete(List<String> menuCdList) {
		authService.deleteAuth(menuCdList);
		return "Auth Deleted!";
	}

	@DeleteMapping("/{authCd}")
	public String authMenuDelete(@PathVariable String authCd, @RequestBody List<AuthDtlDTO> authMenuList) {
		authService.createAuthMenu(authMenuList);
		return "AuthMenu Deleted!";
	}
	
	
}
