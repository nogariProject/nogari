package nogari.system.message.service;

import lombok.RequiredArgsConstructor;
import nogari.system.message.dao.mapper.MessageMapper;
import nogari.system.message.domain.dto.MessageDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImp implements MessageService{

    private final MessageMapper messageMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MessageDTO> findMessages() {
        return messageMapper.selectMessage();
    }

    @Override
    @Transactional(readOnly = true)
    public MessageDTO findMessageByMsgCd(String msgCd) {
        return messageMapper.selectMessageByMsgCd(msgCd);
    }

    @Override
    public int createMessage(MessageDTO deptDTO) {
        return messageMapper.insertMessage(deptDTO);
    }

    @Override
    public int editMessage(MessageDTO deptDTO) {
        return messageMapper.updateMessage(deptDTO);
    }
    @Override
    public int deleteMessage(List<MessageDTO> messageDTOs) {
        int originRows = messageDTOs.size();

        int deletedRows = 0;
        for (MessageDTO messageDTO : messageDTOs) {
            int deletedRow = messageMapper.deleteMessage(messageDTO.getMsgCd());
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
