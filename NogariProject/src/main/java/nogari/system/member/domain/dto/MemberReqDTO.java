package nogari.system.member.domain.dto;

import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Getter
@Builder
@Alias("MemberReqDTO")
public class MemberReqDTO {
    private String username;
    private String password;
    private String token;
}
