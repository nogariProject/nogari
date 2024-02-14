package nogari.global.file.domain.dto;

import lombok.*;

/**
 *  파일 다운로드 요청시 사용되는 DTO
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDownReqDTO {
    String fileCd;
    Long seq;
    String fileNm;
}
