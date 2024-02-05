package nogari.system.ntbd.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class BoardDto {

    @NotNull(message = "필수값")
    String ntbdCd;
    String fileCd;
    String ntbdDiv;
    Long viewCnt;
    String topYn;
    String postNm;
    String postCont;
    String userId;
}