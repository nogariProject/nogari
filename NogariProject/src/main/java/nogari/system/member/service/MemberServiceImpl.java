package nogari.system.member.service;

import lombok.RequiredArgsConstructor;
import nogari.system.member.dao.mapper.MemberMapper;
import nogari.system.member.domain.dto.MemberReqDTO;
import nogari.system.member.domain.dto.MemberRespDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public List<MemberRespDTO> findMembers(MemberReqDTO memberReqDTO) {
        return memberMapper.selectMembers();
    }

    @Override
    public MemberRespDTO findMemberById(String id) {
        return memberMapper.selectMemberById(id);
    }
    @Override
    public int createMember(MemberReqDTO memberReqDTO) {
        return memberMapper.insertMember(memberReqDTO);
    }

    @Override
    public int editMember(MemberReqDTO memberReqDTO) {
        return 0;
    }

    @Override
    public int deleteMember(String id) {
        return 0;
    }
}
