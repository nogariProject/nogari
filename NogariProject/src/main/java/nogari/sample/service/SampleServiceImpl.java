package nogari.sample.service;

import lombok.extern.slf4j.Slf4j;
import nogari.sample.dao.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    SampleMapper sampleMapper;

    public void getSample() throws Exception {
        log.info("@@@@@@@@@@@@@@@@@Service get만가능!");
    }

    @Override
    public void saveSample() throws Exception {
        log.info("@@@@@@@@@@@@@@@@@saveSaple!");

    }

    @Override
    @Transactional
    public void transactionalSample() throws Exception {
        log.info("@@@@@@@@@@@@@@@@@saveSaple!");
    }

    @Override
    public List<Map<String,String>> selectTest() throws Exception {
        return sampleMapper.selectTest();
    }
}
