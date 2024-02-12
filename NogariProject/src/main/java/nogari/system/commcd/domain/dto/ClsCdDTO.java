package nogari.system.commcd.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClsCdDTO {

    @NotNull(message = "필수값")
    private String clsCd;                   // 대분류 코드
    private String clsNm;                   // 대분류 이름
    private String remark;                  // 기타
    private String useYn;                   // 사용 여부
    private String id;                      // 사용자 아이디
    
    private String status;                  // 로우 상태 (C, U)

}
