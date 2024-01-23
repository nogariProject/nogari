package nogari.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {
    public void getSample() throws Exception;


    public void saveSample() throws Exception;
    public void transactionalSample() throws Exception;

    // mybatis 연습
    public List<Map<String,String>> selectTest() throws Exception;

}
