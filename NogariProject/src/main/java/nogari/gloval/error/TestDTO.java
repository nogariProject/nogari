package nogari.gloval.error;

import javax.validation.constraints.NotNull;

public class TestDTO {
	@NotNull(message = "NullPointException")
	String id;
	
	String pw;
	String user;
}
