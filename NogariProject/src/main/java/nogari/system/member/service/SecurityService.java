package nogari.system.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.error.ErrorCode;
import nogari.system.member.dao.mapper.MemberMapper;
import nogari.system.member.domain.dto.MemberDTO;
import nogari.system.member.domain.dto.MemberReqDTO;
import nogari.system.member.security.MemberDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SecurityService implements UserDetailsService {
    private final MemberMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO member = mapper.selectMember(username);
        if(member == null) new UsernameNotFoundException(ErrorCode.UNAUTHORIZED_MEMBER.getErrorCode());
        return new MemberDetails(member);
    }
}
