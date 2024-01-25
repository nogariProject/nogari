package nogari.system.message.service;

import lombok.AllArgsConstructor;
import nogari.system.message.dao.repository.MessageRepository;
import nogari.system.message.domain.entity.Message;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImp implements MessageService{

    private final MessageRepository messageRepository;

    public Iterable<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public void createMessage(Message message){

        messageRepository.save(message);
    }
}
