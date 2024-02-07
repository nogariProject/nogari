package nogari.system.message.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.message.domain.dto.MessageReqDTO;
import nogari.system.message.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    /**
     * 메시지 전체 리스트 조회
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<MessageReqDTO>> messageList(){
        List<MessageReqDTO> messages = messageService.findMessages();
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }
    /**
     * 메시지 단건 조회
     * @param msgCd
     * @return
     */
    @GetMapping("/{msgCd}")
    public ResponseEntity<MessageReqDTO> messageDetails(@PathVariable String msgCd){
        MessageReqDTO message = messageService.findMessageByMsgCd(msgCd);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    /**
     * 메시지 단건 생성
     * @param messageReqDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Integer> messageAdd(@RequestBody MessageReqDTO messageReqDto){
        Integer createdRow = messageService.createMessage(messageReqDto);
        return new ResponseEntity<>(createdRow, HttpStatus.CREATED);
    }
    /**
     * 메시지 단건 수정
     * @param msgCd
     * @param messageReqDTO
     * @return
     */
    @PutMapping("/{msgCd}")
    public ResponseEntity<Integer> messageModify(@PathVariable String msgCd, @RequestBody @Valid MessageReqDTO messageReqDTO){
        int updatedRows = messageService.editMessage(messageReqDTO);
        return new ResponseEntity<>(updatedRows, HttpStatus.OK);
    }
    /**
     * 메시지 단건 삭제
     * @param msgCd
     * @return
     */
    @DeleteMapping("/{msgCd}")
    public ResponseEntity<Integer> messageRemove(@PathVariable String msgCd){
        int deletedRows = messageService.deleteMessage(msgCd);
        return new ResponseEntity<>(deletedRows, HttpStatus.OK);
    }
    /**
     * 메시지 다건 삭제
     * @param msgCds
     * @return
     */
    @PostMapping("/delete-multi")
    public ResponseEntity<Integer> messagesRemove(@RequestBody Map<String, List<String>> msgCds){
        int deletedRow = messageService.deleteMessages(msgCds.get("msgCds"));
        return new ResponseEntity<>(deletedRow,HttpStatus.OK);
    }
}
