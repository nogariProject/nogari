package nogari.system.commcd.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeCdDTO {

	@NotNull(message = "필수값")
	String clsCd;
	@NotNull(message = "필수값")
	String codeCd;
	String codeNm;
	String opt1;
	String opt2;
	String opt3;
	String remark;
	String useYN;
	String id;
	
}
