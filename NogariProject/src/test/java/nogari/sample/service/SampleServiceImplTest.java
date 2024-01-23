package nogari.sample.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class SampleServiceImplTest {
    @Autowired
    SampleService service = new SampleServiceImpl();
    @Test
    void getSampleTest() throws Exception {
        service.getSample();
    }

    @Test
    void saveSampleTest() throws Exception {
        service.saveSample();
    }

    @Test
    void selectTest() throws Exception {
        List<Map<String,String>> list = service.selectTest();
        log.info("@@@@@@size{}",list.size());
        log.info("@@@@@@list{}",list);
    }
}