package nogari.system.message.controller;

import lombok.AllArgsConstructor;
import nogari.system.message.domain.dto.MessageDto;
import nogari.system.message.domain.entity.Message;
import nogari.system.message.service.MessageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private MessageService messageService;
    @Autowired
    private MessageController yourController;

    @Test
    void messageController_getMessage_Test() throws Exception {
        //Given
        Iterable<Message> mockMessagesIterable = Arrays.asList(
                Message.builder().msgCd("1").description("mock1").build(),
                Message.builder().msgCd("2").description("mock2").build()
        );

        when(messageService.getAllMessage()).thenReturn(mockMessagesIterable);

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.get("/message"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("Hello"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].content").value("World"));
    }
}