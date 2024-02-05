package nogari.system.commcd.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeCdDTO {

	@NotNull(message = "필수값")
	String clsCd;
	String codeCd;
	String codeNm;
	String opt1;
	String opt2;
	String opt3;
	String remark;
	String id;
	
	@Override
	public String toString() {
	    return "CodeCdDTO{" +
	            "clsCd='" + clsCd + '\'' +
	            ", codeNm='" + codeNm + '\'' +
	            ", opt1=" + opt1 +
	            ", opt2=" + opt2 +
	            ", opt3=" + opt3 +
	            ", remark='" + remark + '\'' +
	            '}';
	}
}
