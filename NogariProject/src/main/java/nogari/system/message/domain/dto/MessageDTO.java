package nogari.system.message.domain.dto;

import lombok.*;
import nogari.system.message.domain.entity.Message;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Alias("MessageDTO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long msgCd;
    @NotNull(message = "type 값이 없습니다")
    private String type;
    @NotNull(message = "description 값이 없습니다")
    private String description;
    private String regId;
    private String updId;

    public MessageDTO(Message entity){
        this.msgCd = entity.getMsgCd();
        this.type = entity.getType();
        this.description = entity.getDescription();
        this.regId = entity.getRegId();
        this.updId = entity.getUpdId();
    }

}
