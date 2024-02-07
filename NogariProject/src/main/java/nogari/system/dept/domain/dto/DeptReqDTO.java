package nogari.system.dept.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
@Alias("DeptReqDTO")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptReqDTO {
    @NotBlank
    String deptCd;
    @NotBlank
    String deptNm;
    String mgrId;
    String upperDeptCd;
    Long sort;
    Date regDt;
    String regId;
    Date updDt;
    String updId;
}
