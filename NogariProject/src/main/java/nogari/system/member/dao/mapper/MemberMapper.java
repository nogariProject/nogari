package nogari.system.member.dao.mapper;

import nogari.system.member.domain.dto.MemberReqDTO;
import nogari.system.member.domain.dto.MemberRespDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberRespDTO> selectMembers();
    MemberRespDTO selectMemberById(String id);
    int insertMember(MemberReqDTO memberReqDTO);

}
