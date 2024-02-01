package nogari.system.log.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.domain.dto.AccessLogDTO;
import nogari.system.log.service.AccessLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
public class AccessLogController {


    private final AccessLogService accessLogService;

    @GetMapping("/accessLogs")
    public List<AccessLogDTO> accessLogList( //조회
                                             @RequestParam( required = true) @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])",message = "년도월일로 넣어주세요1")String accsDtFrom
            , @RequestParam( required = true) @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])",message = "년도월일로 넣어주세요2")String accsDtTo
                                             ,String memberId
    ){
        AccessLogDTO paramDTO = AccessLogDTO.builder().accsDtFrom(accsDtFrom).accsDtTo(accsDtTo).memberId(memberId).build();
        return accessLogService.findAccessLog(paramDTO);
    }

    @PostMapping("/accessLogs")
    public AccessLogDTO errAccessLogSave(@Valid @RequestBody AccessLogDTO paramDto ) throws Exception{ //저장
        AccessLogDTO rsltDto = accessLogService.errAccessLogSave(paramDto);
        return rsltDto;
    }

}//end class
