package nogari.system.member.service;

import nogari.system.member.domain.dto.MemberReqDTO;
import nogari.system.member.domain.dto.MemberRespDTO;

import java.util.List;

public interface MemberService {
    List<MemberRespDTO> findMembers(MemberReqDTO memberReqDTO);
    MemberRespDTO findMemberById(String id);
    int createMember(MemberReqDTO memberReqDTO);
    int editMember(MemberReqDTO memberReqDTO);
    int deleteMember(String id);


}
