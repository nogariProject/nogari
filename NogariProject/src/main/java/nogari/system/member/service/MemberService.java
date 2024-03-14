package nogari.system.member.service;

import nogari.system.member.domain.dto.MemberDTO;
import nogari.system.member.domain.dto.MemberReqDTO;

public interface MemberService {

    String login(MemberReqDTO memberReqDTO);

    void createMember(MemberDTO memberDTO);

    void saveToken(String memberId, String token);
}
