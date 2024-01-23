package nogari.sample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService {
    public void getSample() throws Exception {
        log.info("@@@@@@@@@@@@@@@@@Service!");
    }
}
