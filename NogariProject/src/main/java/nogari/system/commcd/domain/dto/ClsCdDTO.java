package nogari.system.commcd.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClsCdDTO {

    @NotNull(message = "필수값")
    String clsCd;                   // 대분류 코드
    String clsNm;                   // 대분류 이름
    String remark;                  // 기타
    String useYn;                   // 사용 여부
    String id;                      // 사용자 아이디
    
    String status;                  // 로우 상태 (C, U)

}
