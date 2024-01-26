package nogari.system.dept.dao.mapper;

import lombok.extern.slf4j.Slf4j;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptResDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class DeptMapperTest {
    @Autowired
    DeptMapper mapper;

    @BeforeEach
    void initTest() {
        this.cleanTestData();
    }

    @AfterEach
    void closeTest() {
        this.cleanTestData();
    }

    private void cleanTestData() {
        int cnt = mapper.deleteDept("test");
        log.info("[{}] delete test data {}", this.getClass().getSimpleName(), cnt);
    }

    @Test
    @DisplayName("신규 부서 생성 테스트")
    void insertDept() {
        //given
        DeptReqDTO newDept = new DeptReqDTO();
        newDept.setDeptCd("test");
        newDept.setDeptNm("테스트부서");
        newDept.setSort(1);
        newDept.setRegId("handmade");
        newDept.setUpdId("handmade");

        //when
        mapper.insertDept(newDept);

        //then
        DeptResDTO dept = mapper.selectByDeptCd(newDept.getDeptCd());
        log.info("[{}.insertDept] deptNm = {}", this.getClass().getSimpleName(), dept.getDeptNm());
        assertEquals(newDept.getDeptNm(), dept.getDeptNm());
    }

}