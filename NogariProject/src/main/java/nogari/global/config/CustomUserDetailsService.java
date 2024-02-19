package nogari.global.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.member.domain.dto.MemberRespDTO;
import nogari.system.member.service.MemberServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberServiceImpl memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberRespDTO memberRespDTO = memberService.findMemberById(username);

        if(memberRespDTO == null) throw new UsernameNotFoundException("username " + username + " not found");

        CustomUserDetails user = new CustomUserDetails(memberRespDTO.getId(),memberRespDTO.getPwd(),memberRespDTO.getUseYn());

        log.debug("**************Found user***************");
        log.debug("id : " + user.getUsername());
        return user;
    }
}