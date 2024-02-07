package nogari.system.ntbd.service;

import java.util.List;

import nogari.system.ntbd.domain.dto.BoardReqDto;
import nogari.system.ntbd.domain.dto.BoardRespDto;

public interface NtbdService {

    List<BoardRespDto> findBoard(String ntbdCd);
    List<BoardRespDto> findBoards();
    String createBoard(BoardReqDto boardReqDto);
    String editBoard(BoardReqDto boardReqDto);
    String deleteBoard(String ntbdCd);
    String deleteBoards(List<String> ntbdCds);
}
