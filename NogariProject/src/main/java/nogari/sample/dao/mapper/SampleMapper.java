package nogari.sample.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface SampleMapper {
    List<Map<String,String>> selectTest();
}
