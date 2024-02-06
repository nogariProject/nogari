package nogari.system.log.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.service.ErrorLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    @GetMapping("/errlogs")
    public List<ErrorLogDTO> errLogList( //조회
             @RequestParam( required = true) @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])",message = "년도월일로 넣어주세요1")String tranDtFrom
            ,@RequestParam( required = true) @Pattern(regexp = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])",message = "년도월일로 넣어주세요2")String tranDtTo
            ,@RequestParam( required = false) String memberId
    ){
        ErrorLogDTO paramDTO = ErrorLogDTO.builder().tranDtFrom(tranDtFrom).tranDtTo(tranDtTo).memberId(memberId).build();
        return errorLogService.findErrLog(paramDTO);
    }

 /**/
    @PostMapping("/errlogs")
    public ErrorLogDTO errLogSave(@Valid @RequestBody ErrorLogDTO paramDto ) throws Exception{ //저장
        ErrorLogDTO rsltDto = errorLogService.errLogSave(paramDto);
        return rsltDto;
    }


}// end class
