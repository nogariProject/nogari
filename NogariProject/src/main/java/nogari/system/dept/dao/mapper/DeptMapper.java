package nogari.system.dept.dao.mapper;

import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<DeptReqDTO> selectDept();
    DeptRespDTO selectDeptByDeptCd(String deptCd);
    int insertDept(DeptReqDTO deptReqDTO);
    int updateDept(DeptReqDTO deptReqDTO);
    int deleteDept(String deptCd);

}
