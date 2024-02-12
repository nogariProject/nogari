package nogari.system.file.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import nogari.system.file.domain.dto.FileDTO;

public interface FileService {

    void saveFile(List<MultipartFile> fileList, List<FileDTO> dtoList) throws IOException;
    
    ResponseEntity<Resource> downloadFile(List<FileDTO> dtoList) throws FileNotFoundException, IOException;
}
