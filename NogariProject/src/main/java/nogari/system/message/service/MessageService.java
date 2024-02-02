package nogari.system.message.service;

import nogari.system.message.domain.dto.MessageDTO;

import java.util.List;

public interface MessageService {

    List<MessageDTO> findMessages();
    MessageDTO findMessageByMsgCd(String msgCd);
    int createMessage(MessageDTO deptDTO);
    int editMessage(MessageDTO deptDTO);
    int deleteMessage(List<MessageDTO> messageDTO);
    int deleteMessage(String msgCd);
}
