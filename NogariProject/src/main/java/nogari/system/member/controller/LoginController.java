package nogari.system.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.member.domain.dto.MemberDTO;
import nogari.system.member.domain.dto.MemberReqDTO;
import nogari.system.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final String TOKEN_HEADER_PREFIX = "Bearer ";
    private final MemberService service;

    @PostMapping("/signup")
    public ResponseEntity<String> memberCreate(@RequestBody MemberDTO paramDTO) {
        service.createMember(paramDTO);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberReqDTO memberReqDTO) {
        String token = service.login(memberReqDTO);
        return ResponseEntity.ok().body(TOKEN_HEADER_PREFIX + token);
    }
}
