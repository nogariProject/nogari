package nogari.system.dept.service;

import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;

import java.util.List;

public interface DeptService {

    List<DeptReqDTO> findDepts();
    DeptRespDTO findDeptByDeptCd(String deptCd);
    int createDept(DeptReqDTO deptReqDTO);
    int editDept(DeptReqDTO deptReqDTO);
    int deleteDept(String deptCd);



}
