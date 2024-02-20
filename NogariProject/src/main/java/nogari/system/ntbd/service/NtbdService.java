package nogari.system.ntbd.service;

import nogari.system.ntbd.domain.dto.BoardReqDTO;
import nogari.system.ntbd.domain.dto.BoardRespDTO;

import java.util.List;

public interface NtbdService {

    List<BoardRespDTO> findBoard(String ntbdCd);
    List<BoardRespDTO> findBoards();
    String createBoard(BoardReqDTO boardReqDto);
    String editBoard(BoardReqDTO boardReqDto);
    String deleteBoard(String ntbdCd);
    String deleteBoards(List<String> ntbdCds);
}
