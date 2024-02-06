package nogari.system.ntbd.dao.mapper;

import nogari.system.ntbd.domain.dto.BoardRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NtbdMapper {
    List<BoardRespDto> selectBoard(String ntbdCd);
    List<BoardRespDto> selectBoardList();

}
