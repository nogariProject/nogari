package nogari.system.dept.service;

import nogari.system.dept.domain.dto.DeptDTO;

import java.util.List;

public interface DeptService {

    public List<DeptDTO> findDepts();
    public DeptDTO findDeptByDeptCd(String deptCd);
    public void createDept(DeptDTO deptDTO);
    public void editDept(DeptDTO deptDTO);
    public void deleteDept(String deptCd);



}
