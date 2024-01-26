package nogari.system.dept.dao.mapper;

import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptResDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {
    int insertDept(DeptReqDTO reqDTO);
    int deleteDept(String deptCd);
    DeptResDTO selectByDeptCd(String deptCd);

}
