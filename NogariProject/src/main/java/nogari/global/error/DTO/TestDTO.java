package nogari.global.error.DTO;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class TestDTO {
	
	@NotNull(message = "NullPointException")
	String id;
	
	String pw;
	String user;
}
