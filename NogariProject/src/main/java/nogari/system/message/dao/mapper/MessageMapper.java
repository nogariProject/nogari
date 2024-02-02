package nogari.system.message.dao.mapper;

import nogari.system.message.domain.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageMapper {

    List<MessageDTO> selectMessage();
    MessageDTO selectMessageByMsgCd(String msgCd);
    int insertMessage(MessageDTO messageDTO);
    int updateMessage(MessageDTO messageDTO);
    int deleteMessage(String msgCd);


}
