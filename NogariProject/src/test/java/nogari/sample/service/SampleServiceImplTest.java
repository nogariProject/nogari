package nogari.sample.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SampleServiceImplTest {
    @Autowired
    SampleService service = new SampleServiceImpl();
    @Test
    void getSampleTest() throws Exception {
        service.getSample();
    }
}