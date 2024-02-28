package nogari.global.batch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.batch.dao.mapper.SeqInitBatchMapper;
import nogari.global.batch.domain.dto.SeqInitDTO;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service("seqIntiBatchService")
public class SeqInitBatchServiceImpl implements  SeqIntiBatchService{


    private final SeqInitBatchMapper seqInitBatchmapper;


    @Override
    public SeqInitDTO seqInitBatExc() {

        SeqInitDTO result  = SeqInitDTO.builder().errCd("S0001").errMsg("정상처리되었습니다.").build();

        String curSeq = seqInitBatchmapper.selectCurrentSeq(); //마지막 증가된 시퀀스번호를 가져옴

        curSeq = "-" + curSeq;

        seqInitBatchmapper.updateIncrement(curSeq); //증가된 시퀀스번호를 뺀걸로 INCREMENT 업데이틒처리

        seqInitBatchmapper.selectCurrentSeq(); //다시 증가시킴

        String seq = "1";

        seqInitBatchmapper.updateIncrement(seq); //1로 초기화함

        return result;

    }
}// end class
