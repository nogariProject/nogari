package nogari.system.log.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * ErrorLog DTO
 */
@Getter
@Builder
@ToString
@Alias("ErrorLogDTO")
public class ErrorLogDTO implements Serializable {
    private String tranDt;
    private String tranSeq;
    private String tranTm;
    private String menuCd;
    private String reqPath;
    private String serPath;
    private String errType;
    private String errCd;
    private String errMsg;
    private String memberId;
    private String memberNm;
}
