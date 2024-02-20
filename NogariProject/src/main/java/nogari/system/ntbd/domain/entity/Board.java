package nogari.system.ntbd.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Board {

    @Id
    Long ntbdCd;
    String fileCd;
    String ntbdDiv;
    Long viewCnt;
    String topYn;
    String postNm;
    String postCont;
    String postInDate;
    String postOutDate;
    Date regDt;
    String regId;
    Date updDt;
    String updId;

}
