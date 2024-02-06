package nogari.system.dept.service;

import lombok.RequiredArgsConstructor;
import nogari.system.dept.dao.mapper.DeptMapper;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;
    @Override
    public List<DeptReqDTO> findDepts() {
        return deptMapper.selectDept();
    }
    @Override
    public DeptRespDTO findDeptByDeptCd(String deptCd) {
        return deptMapper.selectDeptByDeptCd(deptCd);
    }
    @Override
    public void createDept(DeptReqDTO deptReqDTO) {
        deptMapper.insertDept(deptReqDTO);
    }
    @Override
    public void editDept(DeptReqDTO deptReqDTO) {
        deptMapper.updateDept(deptReqDTO);
    }
    @Override
    public void deleteDept(String deptCd) {
        deptMapper.deleteDept(deptCd);
    }


}
