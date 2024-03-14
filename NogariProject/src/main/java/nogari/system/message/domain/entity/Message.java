package nogari.system.message.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id @GeneratedValue
    private Long msgCd;
    private String type;
    private String description;
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date regDt;
    private String regId;
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date updDt;
    private String updId;

    public void setId(Long msgCd){
        this.msgCd = msgCd;
    }
}
