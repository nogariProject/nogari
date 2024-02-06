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
    public int deleteMessage(List<MessageReqDTO> messageReqDTOS) {
        int originRows = messageReqDTOS.size();

        int deletedRows = 0;
        for (MessageReqDTO messageReqDTO : messageReqDTOS) {
            int deletedRow = messageMapper.deleteMessage(messageReqDTO.getMsgCd());
            deletedRows += deletedRow;
        }
        if(originRows>deletedRows) throw new RuntimeException("요청건수: "+originRows+" 중 "+deletedRows+"가 성공 하였습니다");

        return deletedRows;
    }
    @Override
    public int deleteMessage(String msgCd) {
        int deletedRow = messageMapper.deleteMessage(msgCd);
        return deletedRow;
    }
}
