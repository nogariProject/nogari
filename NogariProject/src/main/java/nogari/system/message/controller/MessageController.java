package nogari.system.message.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.message.domain.dto.MessageDto;
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
    public ResponseEntity<List<MessageDto>> getMessage(){
        List<MessageDto> messageDtoList = new ArrayList<>();

        Iterable<Message> allMessage = messageService.getAllMessage();
        allMessage.forEach(message -> messageDtoList.add(new MessageDto(message)));

        return new ResponseEntity<>(messageDtoList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity createMessage(@RequestBody @Valid MessageDto messageDto){
        Message message = convertToEntity(messageDto);
        messageService.createMessage(message);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    private MessageDto convertToDto(Message message) {
        return modelMapper.map(message, MessageDto.class);
    }
    private Message convertToEntity(MessageDto messageDto) {
        return Message.builder()
                .msgCd(messageDto.getMsgCd())
                .type(messageDto.getType())
                .description(messageDto.getDescription())
                .regId(messageDto.getRegId())
                .updId(messageDto.getUpdId())
                .build();
    }
}
