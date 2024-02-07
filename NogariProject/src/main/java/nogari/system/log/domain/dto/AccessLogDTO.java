package nogari.system.log.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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