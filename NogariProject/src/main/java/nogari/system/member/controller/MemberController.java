package nogari.system.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.member.domain.dto.MemberReqDTO;
import nogari.system.member.domain.dto.MemberRespDTO;
import nogari.system.member.service.MemberServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;
    @GetMapping("")
    public ResponseEntity<List<MemberRespDTO>> memberList(@RequestBody MemberReqDTO memberReqDTO){
        List<MemberRespDTO> members = memberService.findMembers(memberReqDTO);
        return new ResponseEntity<>(members, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberRespDTO> memberDetail(@PathVariable String id) {
        MemberRespDTO member = memberService.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity memberModify(MemberReqDTO memberReqDTO, UriComponentsBuilder uriBuilder){
        int id = memberService.createMember(memberReqDTO);
        URI location = uriBuilder.path("/member/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Integer> deptModify(@PathVariable String id, @RequestBody MemberReqDTO memberReqDto) {
        int updatedRows = memberService.editMember(memberReqDto);
        return new ResponseEntity<>(updatedRows, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deptRemove(@PathVariable String deptCd) {
        int deletedRows = memberService.deleteMember(deptCd);
        return new ResponseEntity<>(deletedRows, HttpStatus.OK);
    }
}
