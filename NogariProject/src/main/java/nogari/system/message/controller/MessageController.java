package nogari.system.message.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nogari.system.message.domain.dto.MessageDto;
import nogari.system.message.domain.entity.Message;
import nogari.system.message.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<MessageDto> getMessage(){

        Iterable<Message> allMessage = messageService.getAllMessage();

        List<MessageDto> messageDtoList = new ArrayList<>();
        for(Message msg: allMessage) messageDtoList.add(convertToDto(msg));

        return messageDtoList;
    }
    @PostMapping("/{msgCd}")
    @ResponseStatus(HttpStatus.OK)
    public void createMessage(@RequestBody MessageDto messageDto, @PathVariable String msgCd){
        messageDto.setMsgCd(msgCd);
        Message message = convertToEntity(messageDto);
        messageService.createMessage(message);
    }



    private MessageDto convertToDto(Message message) {
        return modelMapper.map(message, MessageDto.class);
    }
    private Message convertToEntity(MessageDto messageDto) {
        return modelMapper.map(messageDto, Message.class);
    }
}
