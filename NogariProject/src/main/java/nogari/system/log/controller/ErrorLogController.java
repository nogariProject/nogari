package nogari.system.log.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.domain.dto.ErrorLogReqDTO;
import nogari.system.log.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/errlogs")
@Slf4j
@Validated
public class ErrorLogController {
    private final ErrorLogService service;

    @GetMapping("")
    public ResponseEntity<List<ErrorLogDTO>> errlogFind(@RequestParam @Pattern(regexp = "^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", message = "년도월일로 넣어주세요1") String tranDtFrom
            , @RequestParam @Pattern(regexp = "^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", message = "년도월일로 넣어주세요2") String tranDtTo
            , @RequestParam(required = false) String memberId) {
        ErrorLogReqDTO paramDTO = new ErrorLogReqDTO();
        paramDTO.setTranDtFrom(tranDtFrom);
        paramDTO.setTranDtFrom(tranDtTo);
        List<ErrorLogDTO> errorLogList = service.findErrorLogList(paramDTO);
        return new ResponseEntity<>(errorLogList, HttpStatus.OK);
    }
//    @GetMapping("")
//    public ResponseEntity<List<ErrorLogDTO>> errlogFind(@Valid ErrorLogReqDTO errorLogReqDTO) {
//        List<ErrorLogDTO> errorLogList = service.findErrorLogList(errorLogReqDTO);
//        return new ResponseEntity<>(errorLogList, HttpStatus.OK);
//    }
}
