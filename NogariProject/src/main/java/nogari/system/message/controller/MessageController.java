package nogari.system.message.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.message.domain.dto.MessageDTO;
import nogari.system.message.domain.entity.Message;
import nogari.system.message.service.MessageServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageServiceImp messageService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<MessageDTO>> messageList(){
        return null;
    }
    @GetMapping("/{msgCd}")
    public MessageDTO messageDetails(){
        return null;
    }

    @PostMapping("")
    public ResponseEntity messageAdd(@RequestBody @Valid MessageDTO messageDto){

        return new ResponseEntity(HttpStatus.CREATED);
    }

//    @PutMapping("/{msgCd}")
//    public void ResponseEntity(@PathVariable String msgCd, @RequestBody @Valid MessageDTO messageDTO){
//
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
    @DeleteMapping("")
    public void deptRemove(@PathVariable String deptCd){


    }

}
