package nogari.system.message.dao.mapper;

import nogari.system.message.domain.dto.MessageReqDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageMapper {

    List<MessageReqDTO> selectMessage();
    MessageReqDTO selectMessageByMsgCd(String msgCd);
    int insertMessage(MessageReqDTO messageReqDTO);
    int updateMessage(MessageReqDTO messageReqDTO);
    int deleteMessage(String msgCd);


}
