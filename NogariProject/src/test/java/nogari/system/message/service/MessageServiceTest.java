package nogari.system.message.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(MessageServiceImp.class)
@AllArgsConstructor
class MessageServiceTest {
    private final MessageServiceImp messageService;

    @Test
    void MessageService_getAllMessage_Test(){
        messageService.getAllMessage();
    }
}