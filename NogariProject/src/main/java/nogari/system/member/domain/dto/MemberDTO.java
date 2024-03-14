package nogari.system.member.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@Alias("MemberDTO")
public class MemberDTO {
    private String id;
    private String authCd;
    private String deptCd;
    private String password;
    private String memberNm;
    private String memberNmEng;
    private String positionCd;
    private String email;
    private String telNo;
    private String failCnt;
    private String firstLoginYn;
    private String lastLoginDt;
    private String remark;
    private String useYn;
    private String regDt;
    private String regId;
    private String updDt;
    private String updId;
}

