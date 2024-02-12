package nogari.system.file.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import nogari.system.file.domain.dto.FileDTO;
import nogari.system.file.service.FileService;

/**
 * 
 * @author CSPI
 */
@Controller
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService service;

    @PostMapping
    public ResponseEntity<String> fileSave(@RequestPart List<MultipartFile> fileList,
            @RequestPart List<FileDTO> dtoList) throws FileNotFoundException, IOException {
        if (fileList.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }
        service.saveFile(fileList, dtoList);
        return ResponseEntity.ok().body("File uploaded successfully");
    }

    @PostMapping("/download")
    public ResponseEntity<Resource> fileDownload(@RequestBody List<FileDTO> dtoList) throws IOException {
        
        return service.downloadFile(dtoList);
    }

}
