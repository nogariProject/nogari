package nogari.global.error.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorLogDTO {
	
	String TRAN_DT;
	int    TRAN_SEQ;
	String TRAN_TM;
	String MENU_CD;
	String REQ_PATH;
	String SER_PATH;
	String ERR_TYPE;
	String ERR_CD;
	String ERR_MSG;
	String MEMBER_ID;
	
	public ErrorLogDTO(String mENU_CD, String rEQ_PATH, String sER_PATH, String eRR_TYPE, String eRR_CD,
			String eRR_MSG, String mEMBER_ID) {
		MENU_CD = mENU_CD;
		REQ_PATH = rEQ_PATH;
		SER_PATH = sER_PATH;
		ERR_TYPE = eRR_TYPE;
		ERR_CD = eRR_CD;
		ERR_MSG = eRR_MSG;
		MEMBER_ID = mEMBER_ID;
	}
	
	
	
}
