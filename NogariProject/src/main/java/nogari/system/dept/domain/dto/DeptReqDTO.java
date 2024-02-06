package nogari.system.dept.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class DeptReqDTO implements Serializable {
    @NotNull(message = "부서코드는 필수 입력값입니다.")
    private String deptCd;
    @NotNull(message = "부서이름은 필수 입력값입니다.")
    @Length(max = 50, message = "부서이름은 최대 50자를 넘겨 입력할 수 없습니다.")
    private String deptNm;
    private String mgrId;
    private String upperDeptCd;
    private int sort;
    private String expDt;
    private String regId;
    private String updId;
}
