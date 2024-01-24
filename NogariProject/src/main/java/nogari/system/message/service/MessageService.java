package nogari.system.message.service;

import lombok.AllArgsConstructor;
import nogari.system.message.dao.repository.MessageRepository;
import nogari.system.message.domain.dto.MessageDto;
import nogari.system.message.domain.entity.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Iterable<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public void createMessage(Message message){

        messageRepository.save(message);
    }
}
