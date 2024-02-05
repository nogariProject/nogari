package nogari.system.ntbd.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.ntbd.domain.dto.BoardRespDto;
import nogari.system.ntbd.service.NtbdService;
import nogari.system.ntbd.service.NtbdServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class NtbdController {

    private final NtbdService ntbdService;

    //게시글 내용 조회
    @GetMapping
    public ResponseEntity<List<BoardRespDto>> selectBoard(@RequestParam("ntbdCd") String ntbdCd) throws Exception{
        List<BoardRespDto> board = ntbdService.selectBoard(ntbdCd);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

}
