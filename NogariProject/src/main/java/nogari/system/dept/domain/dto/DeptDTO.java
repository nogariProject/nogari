package nogari.system.dept.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDTO {

	@NotNull(message = "필수값")
	String deptCd;
	String deptNm;
	String mgrId;
	String upperDeptCd;
	int sort;
	String useYN;
	String id;
	
}
