package nogari.system.commcd.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommCdDTO {

    private ClsCdDTO clsCdDTO;                  // 대분류 코드 DTO
    private List<CodeCdDTO> codeCdDTOList;      // 소분류 코드 DTO 리스트

}
