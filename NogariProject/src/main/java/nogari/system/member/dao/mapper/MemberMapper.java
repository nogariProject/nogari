package nogari.system.member.dao.mapper;

import nogari.system.member.domain.dto.MemberDTO;
import nogari.system.member.domain.dto.MemberReqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberDTO selectMember(String memberId);

    List<String> selectAuthUrl(String memberId);

    int insertMember(MemberDTO paramDTO);

    void mergeToken(MemberReqDTO tokenDTO);
}
