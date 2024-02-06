package nogari.system.dept.service;

import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptResDTO;
import org.springframework.transaction.annotation.Transactional;



public interface DeptService {

    void saveDept(DeptReqDTO reqDTO);

    DeptResDTO findOne(String deptCd);
}
