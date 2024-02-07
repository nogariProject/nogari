package nogari.global.batch.controller;

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
public class SeqInitBatchController {

    @Autowired(required = false)
    protected SeqIntiBatchService seqIntiBatchService;

    //@Scheduled(cron = "0 38 17 * * *") //오후5시에 5분에 돌린다.
    @Scheduled(cron = "0 0 0 * * *") // 24시에 돌린다.
    public void seqInitBatExc() throws Exception{
        seqIntiBatchService.seqInitBatExc();
    }

    @RestController
    public class MyController { //수동실행할때 사용하는부분

        @Autowired(required = false)
        protected SeqIntiBatchService seqIntiBatchService;

        @PutMapping("/sequence")
        public ResponseEntity<SeqInitDTO> seqInitManualBatExc() throws Exception{
            SeqInitDTO dto = seqIntiBatchService.seqInitBatExc();
            return ResponseEntity.ok().body(dto);
        }
    }


}// end class
