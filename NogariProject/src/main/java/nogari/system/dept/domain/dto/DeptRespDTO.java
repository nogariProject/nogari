package nogari.system.dept.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Alias("DeptRespDTO")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptRespDTO {
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
