package nogari.system.log.domain.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * ErrorLog DTO
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ErrorLogDTO implements Serializable {

    //@NotNull(message = "검색시작일자를 넣어주세요.")
    @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])" , message = "년도월로 입력해주세요.")
    private String tranDtFrom;
    private String tranDtTo;

    private String tranDt;
    private String tranSeq;
    private String tranTm;
    private String menuCd;
    private String reqPath;
    private String serPath;
    private String errType;
    private String errCd;
    private String errMsg;
    private String memberId;
    private String rsltMsg;



}
