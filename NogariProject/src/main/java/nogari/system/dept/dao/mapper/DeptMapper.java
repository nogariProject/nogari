package nogari.system.dept.dao.mapper;

import nogari.system.dept.domain.dto.DeptDTO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DeptMapper {
    List<DeptDTO> selectDept();
    DeptDTO selectDeptByDeptCd(String deptCd);
    void insertDept(DeptDTO deptDTO);
    void updateDept(DeptDTO deptDTO);
    void deleteDept(String deptCd);


}
