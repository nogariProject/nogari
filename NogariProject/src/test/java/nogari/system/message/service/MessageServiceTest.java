package nogari.system.message.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MessageService.class)
@AllArgsConstructor
class MessageServiceTest {
    private final MessageService messageService;

    @Test
    void MessageService_getAllMessage_Test(){
        messageService.getAllMessage();
    }
}