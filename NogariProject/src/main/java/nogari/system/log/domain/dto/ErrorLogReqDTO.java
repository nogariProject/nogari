package nogari.system.log.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@Alias("ErrorLogReqDTO")
public class ErrorLogReqDTO {

    @Pattern(regexp = "^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", message = "년월일8자리로 입력해주세요.")
    private String tranDtFrom;
    @Pattern(regexp = "^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", message = "년월일8자리로 입력해주세요.")
    private String tranDtTo;
    private String member;
    private String errType;

}
