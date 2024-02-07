package nogari.system.message.service;

import lombok.RequiredArgsConstructor;
import nogari.system.message.dao.mapper.MessageMapper;
import nogari.system.message.domain.dto.MessageReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService{

    private final MessageMapper messageMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MessageReqDTO> findMessages() {
        return messageMapper.selectMessage();
    }

    @Override
    @Transactional(readOnly = true)
    public MessageReqDTO findMessageByMsgCd(String msgCd) {
        return messageMapper.selectMessageByMsgCd(msgCd);
    }

    @Override
    public int createMessage(MessageReqDTO deptDTO) {
        return messageMapper.insertMessage(deptDTO);
    }

    @Override
    public int editMessage(MessageReqDTO deptDTO) {
        return messageMapper.updateMessage(deptDTO);
    }
    @Override
    public int deleteMessage(String msgCd) {
        int deletedRow = messageMapper.deleteMessage(msgCd);
        return deletedRow;
    }
    @Override
    public int deleteMessages(List<String> msgCds) {
        int deletedRows = 0;
        for (String msgCd : msgCds) {
            int deletedRow = messageMapper.deleteMessage(msgCd);
            deletedRows += deletedRow;
        }
        return deletedRows;
    }
}
