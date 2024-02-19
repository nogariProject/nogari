package nogari.system.member.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("MemberReqDTO")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberReqDTO {

    private String id;
    private String grpAuthCd;
    private String deptCd;
    private String pwd;
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
    private String regId;
    private String updDt;
    private String updId;

}
