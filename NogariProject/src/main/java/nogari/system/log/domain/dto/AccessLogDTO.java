package nogari.system.log.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * ErrorLog DTO
 */
@Getter
@Builder
@ToString
@Alias("AccessLogDTO")
public class AccessLogDTO {
    private String accsDt;
    private String menuCd;
    private String menuNm;
    private String menuPath;
    private String memberId;
    private String memberNm;
}
