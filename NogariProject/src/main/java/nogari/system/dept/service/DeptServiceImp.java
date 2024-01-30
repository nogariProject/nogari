package nogari.system.dept.service;

import lombok.RequiredArgsConstructor;
import nogari.system.dept.dao.mapper.DeptMapper;
import nogari.system.dept.domain.dto.DeptDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeptServiceImp implements DeptService {

    private final DeptMapper deptMapper;
    @Override
    public List<DeptDTO> findDepts() {
        return deptMapper.selectDept();
    }
    @Override
    public DeptDTO findDeptByDeptCd(String deptCd) {
        return deptMapper.selectDeptByDeptCd(deptCd);
    }
    @Override
    public void createDept(DeptDTO deptDTO) {
        deptMapper.insertDept(deptDTO);
    }
    @Override
    public void editDept(DeptDTO deptDTO) {
        deptMapper.updateDept(deptDTO);
    }
    @Override
    public void deleteDept(String deptCd) {
        deptMapper.deleteDept(deptCd);
    }


}
