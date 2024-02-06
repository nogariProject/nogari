package nogari.system.commcd.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommCdDTO {
	private ClsCdDTO clsCdDTO;
    private List<CodeCdDTO> codeCdDTOList;
}
