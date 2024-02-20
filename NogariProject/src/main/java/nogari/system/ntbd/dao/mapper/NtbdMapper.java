package nogari.system.ntbd.dao.mapper;

import nogari.system.ntbd.domain.dto.BoardReqDTO;
import nogari.system.ntbd.domain.dto.BoardRespDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NtbdMapper {
    List<BoardRespDTO> selectBoard(String ntbdCd);
    List<BoardRespDTO> selectBoardList();
    int insertBoard(BoardReqDTO boardReqDto);
    int updateBoard(BoardReqDTO boardReqDto);
    int deleteBoard(String ntbdCd);
    int deleteBoards(List<String> ntbdCds);
}
