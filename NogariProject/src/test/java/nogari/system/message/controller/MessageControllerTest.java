package nogari.system.message.controller;

import nogari.system.message.domain.dto.MessageReqDTO;
import nogari.system.message.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MessageController.class)
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;
    @Test
    void messageList() throws Exception {
        //Given
        List<MessageReqDTO> messageReqDTOS = new ArrayList<MessageReqDTO>();
        messageReqDTOS.add(
                MessageReqDTO.builder()
                        .msgCd("AAAAD")
                        .type("C")
                        .description("예시: 첫번째 MOCK")
                        .regId("admin")
                        .updId("user")
                        .build()
        );
        messageReqDTOS.add(
                MessageReqDTO.builder()
                        .msgCd("AAAAA")
                        .type("C")
                        .description("예시: 두번째 MOCK")
                        .regId("admin")
                        .updId("user")
                        .build()
        );
        when(messageService.findMessages()).thenReturn(messageReqDTOS);
        //When
        mockMvc.perform(get("/messages"))
        //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].msgCd").value("AAAAD"))
                .andExpect(jsonPath("$[0].type").value("C"))
                .andExpect(jsonPath("$[0].description").value("예시: 첫번째 MOCK"))
                .andExpect(jsonPath("$[0].regId").value("admin"))
                .andExpect(jsonPath("$[0].updId").value("user"))

                .andExpect(jsonPath("$[1].msgCd").value("AAAAA"))
                .andExpect(jsonPath("$[1].type").value("C"))
                .andExpect(jsonPath("$[1].description").value("예시: 두번째 MOCK"))
                .andExpect(jsonPath("$[1].regId").value("admin"))
                .andExpect(jsonPath("$[1].updId").value("user"));
    }

    @Test
    void messageDetails_OneMessage_ReturnMessage() throws Exception {
        //Given
        MessageReqDTO messageReqDTO = MessageReqDTO.builder()
                .msgCd("AAAAD")
                .type("C")
                .description("예시: 첫번째 MOCK")
                .regId("admin")
                .updId("user")
                .build();
        when(messageService.findMessageByMsgCd("AAAAD")).thenReturn(messageReqDTO);
        //When
        mockMvc.perform(get("/messages/AAAAD"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.msgCd").value("AAAAD"))
                .andExpect(jsonPath("$.type").value("C"))
                .andExpect(jsonPath("$.description").value("예시: 첫번째 MOCK"))
                .andExpect(jsonPath("$.regId").value("admin"))
                .andExpect(jsonPath("$.updId").value("user"));
    }

    @Test
    void messageAdd_OneMessage_ReturnOne() throws Exception {
        String jsonContent="{" +
                ",\"msgCd\": \"AAAAD\"" +
                ",\"type\": \"C\"" +
                ",\"description\": \"예시: 첫번째 MOCK\"" +
                ",\"regId\": \"admin\"" +
                ",\"updId\": \"user\"" +
                "}";
        MessageReqDTO messageReqDTO = MessageReqDTO.builder()
                .msgCd("AAAAD")
                .type("C")
                .description("예시: 첫번째 MOCK")
                .regId("admin")
                .updId("user")
                .build();
        when(messageService.createMessage(messageReqDTO)).thenReturn(1);
        mockMvc.perform(post("/messages")
                .contentType("application/json")
                .content(jsonContent))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.createdRow").value(1));
    }

    @Test
    void responseEntity() {
    }

    @Test
    void deptRemove() {
    }

    @Test
    void testDeptRemove() {
    }
}