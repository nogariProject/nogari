package nogari.system.commcd.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClsCdDTO {

	@NotNull(message = "필수값")
	String clsCd;
	String clsNm;
	String remark;
	String id;
	
}
