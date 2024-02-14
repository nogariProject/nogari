package nogari.global.file.domain.dto;

import lombok.*;

/**
 * 파일 업로드시
 * 유저정보를 저장해오는 DTO
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileUpReqDTO {
    String userId;
}
