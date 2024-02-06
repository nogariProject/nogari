package nogari.system.ntbd.service;

import java.util.List;

import nogari.system.ntbd.domain.dto.BoardReqDto;
import nogari.system.ntbd.domain.dto.BoardRespDto;

public interface NtbdService {

    List<BoardRespDto> findBoard(String ntbdCd);
    List<BoardRespDto> findBoards();
    String createBoard(BoardReqDto boardReqDto);
}
