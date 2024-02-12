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
    public int createDept(DeptReqDTO deptReqDTO) {
        return deptMapper.insertDept(deptReqDTO);
    }

    @Override
    public int editDept(DeptReqDTO deptReqDTO) {
        return deptMapper.updateDept(deptReqDTO);
    }

    @Override
    public int deleteDept(String deptCd) {
        return deptMapper.deleteDept(deptCd);
    }


}