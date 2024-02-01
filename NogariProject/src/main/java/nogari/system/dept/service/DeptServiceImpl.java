package nogari.system.dept.service;

import lombok.RequiredArgsConstructor;
import nogari.system.dept.dao.mapper.DeptMapper;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptResDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

    private final DeptMapper mapper;

    @Override
    public void saveDept(DeptReqDTO reqDTO) {
        mapper.insertDept(reqDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public DeptResDTO findOne(String deptCd) {

        DeptResDTO vo = mapper.selectByDeptCd(deptCd);
        return mapper.selectByDeptCd(deptCd);
    }

}
