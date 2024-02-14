package nogari.global.file.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 *  파일 업로드 및 다운로드시
 *  파일 관련 거의 모든 데이터를 저장하는 DTO
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("FileDTO")
public class FileDTO {
    String fileCd;
    Long seq;
    String useYn;
    String fileNm;
    String path;
    String fileSize;
    String userId;
}
