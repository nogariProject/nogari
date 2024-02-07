package nogari.system.ntbd.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.ntbd.domain.dto.BoardReqDto;
import nogari.system.ntbd.domain.dto.BoardRespDto;
import nogari.system.ntbd.service.NtbdService;
import nogari.system.ntbd.service.NtbdServiceImpl;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.ibatis.type.ByteObjectArrayTypeHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class NtbdController {

    private final NtbdService ntbdService;

    @GetMapping
    public ResponseEntity<List<BoardRespDto>> boardList() throws Exception{
        List<BoardRespDto> boardList = ntbdService.findBoards();
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    //게시글 내용 조회
    @GetMapping("/{ntbdCd}")
    public ResponseEntity<List<BoardRespDto>> boardDetails(@PathVariable String ntbdCd){
        List<BoardRespDto> board = ntbdService.findBoard(ntbdCd);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> boardAdd(@RequestBody BoardReqDto boardReqDto){
        String result = ntbdService.createBoard(boardReqDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{ntbdCd}")
    public ResponseEntity<String> boardModify(@RequestBody BoardReqDto boardReqDto) {
        String result = ntbdService.editBoard(boardReqDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{ntbdCd}")
    public String boardRemove(@PathVariable String ntbdCd){
        String result = ntbdService.deleteBoard(ntbdCd);

        return result;
    }

}
