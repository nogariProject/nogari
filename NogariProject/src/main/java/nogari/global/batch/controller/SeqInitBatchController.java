package nogari.global.batch.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import nogari.global.batch.domain.dto.SeqInitDTO;
import nogari.global.batch.service.SeqIntiBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@Api(tags = "SeqInitBatchController", description = "시퀀스 초기화 배치 매일 12시에 초기화 된다.")
public class SeqInitBatchController {

    @Autowired(required = false)
    protected SeqIntiBatchService seqIntiBatchService;

    //@Scheduled(cron = "0 38 17 * * *") //오후5시에 5분에 돌린다.
    @Scheduled(cron = "0 0 0 * * *") // 24시에 돌린다.
    public void seqInitBatExc() throws Exception{
        seqIntiBatchService.seqInitBatExc();
    }

    @RestController
    @RequestMapping("${api.base-path}/")
    @Api(tags = "ManualSeqBatEcec", description = "에러로그 시퀀스 초기화")
    public class ManualSeqBatEcec { //수동실행할때 사용하는부분

        @Autowired(required = false)
        protected SeqIntiBatchService seqIntiBatchService;

        @PutMapping("/sequence")
        @ApiOperation(value = "에러로그 시퀀스 초기화 배치 수동실행", notes = "에러로그 시퀀스 초기화 배치 수동실행를 수동 실행한다. ")
        public ResponseEntity<SeqInitDTO> seqInitManualBatExc(){
            SeqInitDTO dto = seqIntiBatchService.seqInitBatExc();
            return ResponseEntity.ok().body(dto);
        }
    }


}// end class
