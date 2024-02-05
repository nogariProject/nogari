package nogari.system.log.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * ErrorLog DTO
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Alias("ErrorLogDTO")
public class ErrorLogDTO {
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
