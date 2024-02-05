package nogari.system.log.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.domain.dto.AccessLogReqDTO;
import nogari.system.log.service.AccessLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accslogs")
public class AccessLogController {

    private final AccessLogService service;

    @GetMapping("")
    public ResponseEntity<List<AccessLogDTO>> accessLogFind(@RequestParam AccessLogReqDTO paramDTO) {
        List<AccessLogDTO> accessLogList = service.findAccessLogList(paramDTO);
        return new ResponseEntity<>(accessLogList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<AccessLogDTO>> accessLogCreate(@Valid @RequestBody AccessLogDTO paramDTO) {
        service.createAccessLog(paramDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
