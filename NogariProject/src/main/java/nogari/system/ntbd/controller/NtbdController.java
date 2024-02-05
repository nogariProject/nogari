package nogari.system.ntbd.controller;

import nogari.system.ntbd.domain.dto.BoardRespDto;
import nogari.system.ntbd.service.NtbdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class NtbdController {

    private final NtbdService ntbdService;

    //게시글 내용 조회
    @GetMapping("/{ntbdCd}")
    public ResponseEntity<List<BoardRespDto>> selectBoard(@RequestParam String ntbdCd) throws Exception{
        List<BoardRespDto> board = service.selectBoard(ntbdCd);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

}
