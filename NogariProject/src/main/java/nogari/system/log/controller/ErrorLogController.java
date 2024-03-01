package nogari.system.log.controller;

import io.swagger.annotations.*;
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
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.base-path}/errlogs")
@Slf4j
@Validated
@Api(tags = "errlogListFind", description = "에러로그")
public class ErrorLogController {
    private final ErrorLogService service;

    /**
     * 에러로그조회
     * @param errorLogReqDTO the error log req dto
     * @return the response entity
     */

    @GetMapping("")
    @ApiOperation(value = "에러로그 조회", notes = "저장된 에러로그를 조회한다.")
    @ApiImplicitParams(
        {
              @ApiImplicitParam(name="tranDtFrom",value="조회시작일자(YYYYMMDD)"          ,required=false)
            , @ApiImplicitParam(name="tranDtTo"  ,value="조회종료일자(YYYYMMDD)"          ,required=false)
            , @ApiImplicitParam(name="member"    ,value="사용자ID 또는 사용자명"           ,required=false)
            , @ApiImplicitParam(name="errType"   ,value="에러타입"                       ,required=false)
        }
    )
    public ResponseEntity<List<ErrorLogDTO>> errlogListFind(@Valid ErrorLogReqDTO errorLogReqDTO) {
        List<ErrorLogDTO> errorLogList = service.findErrorLogList(errorLogReqDTO);
        return new ResponseEntity<>(errorLogList, HttpStatus.OK);
    }
}

