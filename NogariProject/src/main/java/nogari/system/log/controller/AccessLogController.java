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

//    @GetMapping("/accessLogs")
//    public List<AccessLogDTO> accessLogList( //조회
//                                             @RequestParam( required = true) @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])",message = "년도월일로 넣어주세요1")String accsDtFrom
//            , @RequestParam( required = true) @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])",message = "년도월일로 넣어주세요2")String accsDtTo
//            , @RequestParam( required = false) String memberId
//    ){
//        AccessLogDTO paramDTO = AccessLogDTO.builder().accsDtFrom(accsDtFrom).accsDtTo(accsDtTo).memberId(memberId).build();
//        return accessLogService.findAccessLog(paramDTO);
//    }
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