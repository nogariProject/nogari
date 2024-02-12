package nogari.system.log.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("AccessLogReqDTO")
public class AccessLogReqDTO {
    private String accsDtFrom;
    private String accsDtTo;
    private String menu;
    private String member;
}
