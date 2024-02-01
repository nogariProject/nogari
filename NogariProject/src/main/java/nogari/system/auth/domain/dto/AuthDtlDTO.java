package nogari.system.auth.domain.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Alias("AuthDtlDTO")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDtlDTO {
	
	private String authCd;
    private String menuCd;
    private String useYn;
    private String crtYn;
    private String redYn;
    private String savYn;
    private String delYn;
    private String prtYn;
    private String exlYn;
    private String etc1Yn;
    private String etc2Yn;
    private String etc3Yn;
    private String regDt;
    private String regId;
    private String updDt;
    private String updId;

}
