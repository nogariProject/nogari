package nogari.system.dept.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import nogari.system.dept.dao.mapper.DeptMapper;
import nogari.system.dept.domain.dto.DeptReqDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 실제 서블릿 컨테이너를 실행하지 않고 목 서블릿 컨테이너를 사용하여 테스트 할 수 있다.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Slf4j
class DeptControllerTest {
    @Autowired
    DeptMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void initTest() {
        this.cleanTestData();
    }

    @AfterEach
    void closeTest() {
        this.cleanTestData();
    }

    private void cleanTestData() {
//        int cnt = mapper.deleteDept("test");
//        log.info("[{}] delete test data {}", this.getClass().getSimpleName(), cnt);
    }

    @Test
    @Rollback
    public void testSaveDept() throws Exception {
        DeptReqDTO newDept = new DeptReqDTO();
        newDept.setDeptCd("testA");
        newDept.setDeptNm("테스트부서");
        newDept.setSort(1);
        newDept.setRegId("handmade");
        newDept.setUpdId("handmade");

        String jsonNewDept = this.objectMapper.writeValueAsString(newDept);

        mockMvc.perform(post("/dept")
                        .content(jsonNewDept)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print(System.out));
    }

    @Test
    void testFindById() throws Exception {
        DeptReqDTO newDept = new DeptReqDTO();
        newDept.setDeptCd("testA");
        newDept.setDeptNm("테스트부서");
        newDept.setSort(1);
        newDept.setRegId("handmade");
        newDept.setUpdId("handmade");

        mapper.insertDept(newDept);


        mockMvc.perform(get("/depts/{deptCd}", newDept.getDeptCd()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deptNm", Matchers.is(newDept.getDeptNm())))
                .andDo(MockMvcResultHandlers.print(System.out));
    }
    @Test
    void testFailSaveDeptCausedValid() throws Exception {
        DeptReqDTO newDept = new DeptReqDTO();
        newDept.setDeptCd("testA");
//        newDept.setDeptNm("테스트부서");
        newDept.setSort(1);
        newDept.setRegId("handmade");
        newDept.setUpdId("handmade");

        String jsonNewDept = this.objectMapper.writeValueAsString(newDept);

        mockMvc.perform(post("/dept")
                        .content(jsonNewDept)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", Matchers.is(404)))
                .andExpect(jsonPath("$.errors[0].field", Matchers.is("deptNm")))
                .andExpect(jsonPath("$.errors[0].message", Matchers.is("부서이름은 필수 입력값입니다.")))
                .andDo(MockMvcResultHandlers.print(System.out));
    }

}


