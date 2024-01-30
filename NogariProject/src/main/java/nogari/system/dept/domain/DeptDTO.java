package nogari.system.dept.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
    String deptCd;
    String deptNm;
    String mgrId;
    String upperDeptCd;
    Long sort;
    String expDt;
    Date regDt;
    String regId;
    Date updDt;
    String updId;
}
