package nogari.system.message.service;

import nogari.system.message.domain.dto.MessageReqDTO;

import java.util.List;

public interface MessageService {

    List<MessageReqDTO> findMessages();
    MessageReqDTO findMessageByMsgCd(String msgCd);
    int createMessage(MessageReqDTO deptDTO);
    int editMessage(MessageReqDTO deptDTO);
    int deleteMessage(List<MessageReqDTO> messageReqDTO);
    int deleteMessage(String msgCd);
}
