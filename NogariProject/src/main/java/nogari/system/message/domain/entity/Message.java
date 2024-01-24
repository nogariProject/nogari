package nogari.system.message.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private String msgCd;
    private String type;
    private String description;
    private Date regDt;
    private String regId;
    private Date updDt;
    private String updId;

    public void setId(String msgCd){
        this.msgCd = msgCd;
    }
}
