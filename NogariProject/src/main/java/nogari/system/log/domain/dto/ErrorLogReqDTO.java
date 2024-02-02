package nogari.system.log.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Alias("ErrorLogReqDTO")
public class ErrorLogReqDTO implements Serializable {
    private String tranDtFrom;
    private String tranDtTo;
    private String member;
    private String menu;

}
