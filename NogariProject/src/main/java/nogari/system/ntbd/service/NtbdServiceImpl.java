package nogari.system.ntbd.service;

import lombok.RequiredArgsConstructor;
import nogari.system.ntbd.dao.mapper.NtbdMapper;
import nogari.system.ntbd.domain.dto.BoardReqDTO;
import nogari.system.ntbd.domain.dto.BoardRespDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NtbdServiceImpl implements NtbdService {

    private final NtbdMapper mapper;

    //게시글 조회
    @Override
    public List<BoardRespDTO> findBoard(String ntbdCd){
        return mapper.selectBoard(ntbdCd);
    }

    //게시판 글목록 조회
    @Override
    public List<BoardRespDTO> findBoards() {
        return mapper.selectBoardList();
    }

    // 게시글 등록
    @Override
    public String createBoard(BoardReqDTO boardReqDTO) {
        int result = mapper.insertBoard(boardReqDTO);
        if(result==1){
            return "게시글 등록 성공";
        }else{
            return "게시글 등록 실패";
        }
    }

    // 게시글 수정
    @Override
    public String editBoard(BoardReqDTO boardReqDTO) {
        int result = mapper.updateBoard(boardReqDTO);
        if(result==1){
            return "게시글 수정 성공";
        }else{
            return "게시글 수정 실패";
        }
    }

    @Override
    public String deleteBoard(String ntbdCd) {
        int result = mapper.deleteBoard(ntbdCd);
        return result + "건의 게시글이 삭제되었습니다.";
    }


    @Override
    public String deleteBoards(List<String> ntbdCds) {
        int result = mapper.deleteBoards(ntbdCds);
        return result + "건의 게시글이 삭제되었습니다.";
    }
}
