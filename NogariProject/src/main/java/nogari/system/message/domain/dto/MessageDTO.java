package nogari.system.message.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Alias("MessageDTO")
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private String msgCd;
    @Pattern(regexp = "^(A|C)$", message = "TYPE 필드는 'A' 또는 'C' 만 입력할 수 있습니다.")
    private String type;
    private String description;
    @NotNull(message = "등록자ID가 누락되었습니다.")
    private String regId;
    @NotNull(message = "수정자ID가 누락되었습니다.")
    private String updId;


}
