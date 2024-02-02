package nogari.system.log.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.domain.dto.ErrorLogReqDTO;
import nogari.system.log.service.ErrorLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/errlogs")
public class ErrorLogController {
    private final ErrorLogService service;

    @GetMapping("")
    public ResponseEntity<List<ErrorLogDTO>> errlogFind(@RequestParam ErrorLogReqDTO errorLogReqDTO) {
        List<ErrorLogDTO> errorLogList = service.findErrorLogList(errorLogReqDTO);
        return ResponseEntity.ok().body(errorLogList);
    }
}
