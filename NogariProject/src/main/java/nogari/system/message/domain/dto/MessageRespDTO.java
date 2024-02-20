package nogari.system.message.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("MessageRespDTO")
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MessageRespDTO {

    private String msgCd;
    private String type;
    private String description;
    private String regId;
    private String updId;

}
