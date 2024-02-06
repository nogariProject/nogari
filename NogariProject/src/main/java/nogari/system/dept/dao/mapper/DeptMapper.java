package nogari.system.dept.dao.mapper;

import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DeptMapper {
    List<DeptReqDTO> selectDept();
    DeptRespDTO selectDeptByDeptCd(String deptCd);
    void insertDept(DeptReqDTO deptReqDTO);
    void updateDept(DeptReqDTO deptReqDTO);
    void deleteDept(String deptCd);


}
