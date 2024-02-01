package nogari.system.log.domain.dto;

import lombok.*;

import javax.validation.constraints.Pattern;
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccessLogDTO {

    //@NotNull(message = "검색시작일자를 넣어주세요.")
    @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])" , message = "년도월로 입력해주세요.")
    private String accsDtFrom;
    private String accsDtTo;
    private String accsDt;
    private String menuCd;
    private String menuPath;
    private String memberId;
    private String rsltMsg;

}
