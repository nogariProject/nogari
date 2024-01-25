package nogari.system.message.service;

import nogari.system.message.domain.entity.Message;

public interface MessageService {
    public Iterable<Message> getAllMessage();

    public void createMessage(Message message);
}
