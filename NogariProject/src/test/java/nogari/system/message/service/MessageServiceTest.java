package nogari.system.message.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(MessageServiceImpl.class)
@AllArgsConstructor
class MessageServiceTest {
    private final MessageServiceImpl messageService;

}