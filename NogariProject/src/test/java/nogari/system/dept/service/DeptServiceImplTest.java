package nogari.system.dept.service;

import lombok.extern.slf4j.Slf4j;
import nogari.system.dept.dao.mapper.DeptMapper;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptResDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class DeptServiceImplTest {
    @Autowired
    private DeptMapper mapper;

    @Autowired
    private DeptService service;

    @Test
    public void testSaveDept() {
        DeptReqDTO newDept = new DeptReqDTO();
        newDept.setDeptCd("test");
        newDept.setDeptNm("테스트부서");
        newDept.setSort(1);
        newDept.setRegId("handmade");
        newDept.setUpdId("handmade");

        service.saveDept(newDept);

        DeptResDTO findOne = service.findOne(newDept.getDeptCd());
        assertEquals(newDept.getDeptNm(), findOne.getDeptNm());
    }

    @Test
    @DisplayName("Rollback 테스트!")
    public void testRollback() throws Exception {
        List<DeptReqDTO> list = new ArrayList<>();

        DeptReqDTO newDeptA = new DeptReqDTO();
        newDeptA.setDeptCd("testA");
        newDeptA.setDeptNm("테스트부서A");
        newDeptA.setSort(2);
        newDeptA.setRegId("handmade");
        newDeptA.setUpdId("handmade");

        DeptReqDTO newDeptB = new DeptReqDTO();
        newDeptB.setDeptCd("testB");
        newDeptB.setDeptNm("테스트부서B");
        newDeptB.setSort(1);
        newDeptB.setRegId("handmade");
        newDeptB.setUpdId("handmade");

        DeptReqDTO newDeptC = new DeptReqDTO();
        newDeptC.setDeptCd("testA");
        newDeptC.setDeptNm("테스트부서C");
        newDeptC.setSort(1);
        newDeptC.setRegId("handmade");
        newDeptC.setUpdId("handmade");

        list.add(newDeptA);
        list.add(newDeptB);
        list.add(newDeptC);

        service.saveDept(list.get(0));
        service.saveDept(list.get(1));
        assertThrows(Exception.class, ()-> service.saveDept(list.get(2)));

        // 롤백 테스트 실패...
        assertNull(service.findOne(newDeptA.getDeptCd()));
        assertNull(service.findOne(newDeptB.getDeptCd()));
        assertNull(service.findOne(newDeptC.getDeptCd()));
    }
}