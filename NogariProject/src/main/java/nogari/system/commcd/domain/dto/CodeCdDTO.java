package nogari.system.commcd.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeCdDTO {

    @NotNull(message = "필수값")
    String clsCd;                   // 대분류 코드
    @NotNull(message = "필수값")
    String codeCd;                  // 소분류 코드
    String codeNm;                  // 소분류 이름
    String opt1;                    // 옵션 1
    String opt2;                    // 옵션 2
    String opt3;                    // 옵션 3
    String remark;                  // 기타
    String useYn;                   // 사용 여부
    String id;                      // 사용자 아이디
    
    String status;                  // 로우 상태 (C, U)

}
