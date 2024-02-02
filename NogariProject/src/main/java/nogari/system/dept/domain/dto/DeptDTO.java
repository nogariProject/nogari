package nogari.system.dept.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
@Alias("DeptDTO")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
    String deptCd;
    String deptNm;
    String mgrId;
    String upperDeptCd;
    Long sort;
    Date regDt;
    String regId;
    Date updDt;
    String updId;
}
