package nogari.system.log.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrLog {

    @Id
    private String tranDt;
    private Long TransSeq;
    private String TranTm;
    private String menuCd;
    private String reqPath;
    private String serPath;
    private String errType;
    private String errCd;
    @Column(length = 4000)
    private String errMsg;
    private String memberId;
    @PrePersist
    public void prePersist() {
        this.tranDt = String.valueOf(LocalDateTime.now());
    }

}
