package nogari.global.batch.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeqInitBatchMapper {

    String selectCurrentSeq();

    void updateIncrement(String curSeq);
}// end class
