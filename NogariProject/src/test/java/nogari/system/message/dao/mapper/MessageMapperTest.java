package nogari.system.message.dao.mapper;

import nogari.system.message.domain.dto.MessageDTO;
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
        MessageDTO messageDTO1 = MessageDTO.builder()
                .msgCd("AAAAA")
                .type("C")
                .description("예시: 파일 다운로드에 실패하였습니다")
                .regId("admin")
                .updId("user")
                .build();
        MessageDTO messageDTO2 = MessageDTO.builder()
                .msgCd("AAAAB")
                .type("C")
                .description("예시: 파일 업로드에 실패하였습니다")
                .regId("admin")
                .updId("user")
                .build();
        MessageDTO messageDTO3 = MessageDTO.builder()
                .msgCd("AAAAC")
                .type("C")
                .description("예시: 성공")
                .regId("admin")
                .updId("user")
                .build();
        messageMapper.insertMessage(messageDTO1);
        messageMapper.insertMessage(messageDTO2);
        messageMapper.insertMessage(messageDTO3);
    }
    @Test
    void selectMessage_ThreeMessages_ReturnsThree() {
        //When
        List<MessageDTO> messageDTOs = messageMapper.selectMessage();
        //Then
        assertThat(3, is(equalTo(messageDTOs.size())));
    }

    @Test
    void selectMessageByMsgCd_OneMessage_ReturnThatMessage() {
        //Given
        MessageDTO messageDTO = MessageDTO.builder()
                .msgCd("AAAAD")
                .type("C")
                .description("예시: 공지사항이 성공적으로 입력 되었습니다.")
                .regId("admin")
                .updId("user")
                .build();
        messageMapper.insertMessage(messageDTO);
        //When
        MessageDTO messageDTONew = messageMapper.selectMessageByMsgCd("AAAAD");
        //Then
        assertThat(messageDTO, is(equalTo(messageDTONew)));
    }

    @Test
    void updateMessage_editOneMessage_ReturnEditedValue() {
        //Given
        MessageDTO messageDTO = MessageDTO.builder()
                .msgCd("AAAAC")
                .type("C")
                .description("예시: 변경된 메시지")
                .regId("admin")
                .updId("user")
                .build();
        //When
        messageMapper.updateMessage(messageDTO);
        //Then
        MessageDTO messageDTONew = messageMapper.selectMessageByMsgCd("AAAAC");
        assertThat(messageDTO.getDescription(), is(equalTo(messageDTONew.getDescription())));
    }

    @Test
    void deleteMessage_ThreeMessages_ReturnTwo() {
        //Given
        //When
        messageMapper.deleteMessage("AAAAB");
        //Then
        List<MessageDTO> messageDTOs = messageMapper.selectMessage();
        assertThat(2, is(equalTo(messageDTOs.size())));
    }
}