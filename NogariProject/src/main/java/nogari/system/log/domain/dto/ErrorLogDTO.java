package nogari.system.log.domain.dto;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ErrorLog DTO
 */
@Getter
@ToString
public class ErrorLogDTO implements Serializable {
    private String tranDt;
    private String tranSeq;
    private String tranTm;
    private String menuCd;
    private String reqPatH;
    private String serPath;
    private String errTypE;
    private String errCd;
    private String errMsg;
    private String memberId;
}
