package nogari.system.message.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Builder
@Getter
@Setter
public class MessageDto {

    private String msgCd;
    private String type;
    private String description;
    private Date regDt;
    private String regId;
    private Date updDt;
    private String updId;

}
