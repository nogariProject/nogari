package nogari.system.auth.domain.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Alias("AuthMstDTO")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthMstDTO {

	private String authCd;
    private String authNm;
    private String regDt;
    private String regId;
    private String updDt;
    private String updId;

}
