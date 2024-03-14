package nogari.system.ntbd.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.ntbd.domain.dto.BoardReqDTO;
import nogari.system.ntbd.domain.dto.BoardRespDTO;
import nogari.system.ntbd.service.NtbdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base-path}/board")
@RequiredArgsConstructor
public class NtbdController {

    private final NtbdService ntbdService;

    @GetMapping
    public ResponseEntity<List<BoardRespDTO>> boardList() throws Exception{
        List<BoardRespDTO> boardList = ntbdService.findBoards();
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    //게시글 내용 조회
    @GetMapping("/{ntbdCd}")
    public ResponseEntity<List<BoardRespDTO>> boardDetails(@PathVariable String ntbdCd){
        List<BoardRespDTO> board = ntbdService.findBoard(ntbdCd);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> boardAdd(@RequestBody BoardReqDTO boardReqDTO){
        String result = ntbdService.createBoard(boardReqDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{ntbdCd}")
    public ResponseEntity<String> boardModify(@RequestBody BoardReqDTO boardReqDTO) {
        String result = ntbdService.editBoard(boardReqDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{ntbdCd}")
    public ResponseEntity<String> boardRemove(@PathVariable String ntbdCd){
        String result = ntbdService.deleteBoard(ntbdCd);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/delete-multi")
    public ResponseEntity<String> boardsRemove(@RequestBody List<String> ntbdCds){
        String result = ntbdService.deleteBoards(ntbdCds);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
