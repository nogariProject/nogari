package nogari.system.file.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDTO {

    private MultipartFile file;
    private String fileCd;
    private Long seq;
    private String useYn;
    private String fileNm;
    private String path;
    private Long size;
    private String id;
    private String fromDt;
    private String toDt;

    private String extension;
}
