package nogari.system.message.dao.mapper;

import nogari.system.message.domain.dto.MessageReqDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@Transactional
class MessageMapperTest {

    @Autowired
    private MessageMapper messageMapper;
    @BeforeEach
    public void setUp_3_Messages(){
        //Given
        MessageReqDTO messageReqDTO1 = MessageReqDTO.builder()
                .msgCd("AAAAA")
                .type("C")
                .description("예시: 파일 다운로드에 실패하였습니다")
                .regId("admin")
                .updId("user")
                .build();
        MessageReqDTO messageReqDTO2 = MessageReqDTO.builder()
                .msgCd("AAAAB")
                .type("C")
                .description("예시: 파일 업로드에 실패하였습니다")
                .regId("admin")
                .updId("user")
                .build();
        MessageReqDTO messageReqDTO3 = MessageReqDTO.builder()
                .msgCd("AAAAC")
                .type("C")
                .description("예시: 성공")
                .regId("admin")
                .updId("user")
                .build();
        messageMapper.insertMessage(messageReqDTO1);
        messageMapper.insertMessage(messageReqDTO2);
        messageMapper.insertMessage(messageReqDTO3);
    }
    @Test
    void selectMessage_ThreeMessages_ReturnsThree() {
        //When
        List<MessageReqDTO> messageReqDTOS = messageMapper.selectMessage();
        //Then
        assertThat(3, is(equalTo(messageReqDTOS.size())));
    }

    @Test
    void selectMessageByMsgCd_OneMessage_ReturnThatMessage() {
        //Given
        MessageReqDTO messageReqDTO = MessageReqDTO.builder()
                .msgCd("AAAAD")
                .type("C")
                .description("예시: 공지사항이 성공적으로 입력 되었습니다.")
                .regId("admin")
                .updId("user")
                .build();
        messageMapper.insertMessage(messageReqDTO);
        //When
        MessageReqDTO messageReqDTONew = messageMapper.selectMessageByMsgCd("AAAAD");
        //Then
        assertThat(messageReqDTO, is(equalTo(messageReqDTONew)));
    }

    @Test
    void updateMessage_editOneMessage_ReturnEditedValue() {
        //Given
        MessageReqDTO messageReqDTO = MessageReqDTO.builder()
                .msgCd("AAAAC")
                .type("C")
                .description("예시: 변경된 메시지")
                .regId("admin")
                .updId("user")
                .build();
        //When
        messageMapper.updateMessage(messageReqDTO);
        //Then
        MessageReqDTO messageReqDTONew = messageMapper.selectMessageByMsgCd("AAAAC");
        assertThat(messageReqDTO.getDescription(), is(equalTo(messageReqDTONew.getDescription())));
    }

    @Test
    void deleteMessage_ThreeMessages_ReturnTwo() {
        //Given
        //When
        messageMapper.deleteMessage("AAAAB");
        //Then
        List<MessageReqDTO> messageReqDTOS = messageMapper.selectMessage();
        assertThat(2, is(equalTo(messageReqDTOS.size())));
    }
}