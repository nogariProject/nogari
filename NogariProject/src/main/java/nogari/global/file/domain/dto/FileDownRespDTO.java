package nogari.global.file.domain.dto;

import lombok.*;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 *  파일 다운로드시
 *  서비스에서 컨트롤러로 데이터 이동시 사용
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDownRespDTO {

    Resource fileResource;
    int result;

}
