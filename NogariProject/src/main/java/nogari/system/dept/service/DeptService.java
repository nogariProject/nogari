package nogari.system.dept.service;

import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;

import java.util.List;

public interface DeptService {

    List<DeptReqDTO> findDepts();
    DeptRespDTO findDeptByDeptCd(String deptCd);
    void createDept(DeptReqDTO deptReqDTO);
    void editDept(DeptReqDTO deptReqDTO);
    void deleteDept(String deptCd);



}
