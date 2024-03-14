package nogari.system.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.security.JwtTokenProvider;
import nogari.system.member.dao.mapper.MemberMapper;
import nogari.system.member.domain.dto.MemberDTO;
import nogari.system.member.domain.dto.MemberReqDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mapper;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(MemberReqDTO memberReqDTO) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(memberReqDTO.getUsername(), memberReqDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);
        String token = tokenProvider.createToken(authentication);
        saveToken(memberReqDTO.getUsername(), token);
        return token;
    }

    @Override
    public void createMember(MemberDTO memberDTO) {
        String encodedPassword = passwordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword);
        mapper.insertMember(memberDTO);
    }

    @Override
    public void saveToken(String memberId, String token) {
        MemberReqDTO tokenDTO = MemberReqDTO.builder().username(memberId).token(token).build();
        mapper.mergeToken(tokenDTO);
    }
}
