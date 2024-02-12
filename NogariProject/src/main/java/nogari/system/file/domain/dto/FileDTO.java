package nogari.system.file.domain.dto;

import java.util.List;

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
    private String fileNm;
    private Long size;
    private String path;
    private String useYn;
    private String id;

}
