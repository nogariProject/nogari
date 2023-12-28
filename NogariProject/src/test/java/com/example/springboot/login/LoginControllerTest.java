package com.example.springboot.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springboot.login.domain.MemberVO;
import com.example.springboot.login.domain.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private LoginMapper mapper;
    
    @BeforeEach
    public void init() {
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("USER_ID", "junit");
        mapper.deleteMember(requestParam);
    }

    @Test
    @DisplayName("올바른 정보로 로그인")
    public void DoLogin() throws Exception {

        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("USER_ID", "spring");
        requestParam.put("PASSWORD", "1234");
        String requestJson = objectMapper.writeValueAsString(requestParam);

        ResultVO<String> resultVO = new ResultVO<>();
        resultVO.setData("Welcome back boot");
        String responseJson = objectMapper.writeValueAsString(resultVO);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("data", Matchers.is("Welcome back boot")))
                .andExpect(MockMvcResultMatchers.content().string(responseJson)).andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("잘못된 정보로 로그인")
    public void DoNotLogin() throws Exception {
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("USER_ID", "boot");
        requestParam.put("PASSWORD", "1234");
        String requestJson = objectMapper.writeValueAsString(requestParam);

        ResultVO<String> resultVO = new ResultVO<>();
        resultVO.setError(true);
        resultVO.setMessage("Not Member!");
        ;
        String responseJson = objectMapper.writeValueAsString(resultVO);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().string(responseJson)).andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("모든 멤버 보기")
    public void getAllMembers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/members").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("data[0].userId", Matchers.is("cspi"))).andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("정상 회원가입")
    public void signup() throws Exception {
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("USER_ID", "junit");
        requestParam.put("PASSWORD", "1234");
        requestParam.put("NAME", "test");
        String requestJson = objectMapper.writeValueAsString(requestParam);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/signup").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

        MemberVO member = mapper.selectMemberById(requestParam);

        assertThat(member.getName()).isEqualTo("test");

    }

    @Test
    @DisplayName("비 정상 회원가입")
    public void signupDup() throws Exception {
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("USER_ID", "cspi");
        requestParam.put("PASSWORD", "1234");
        requestParam.put("NAME", "yangjae");
        String requestJson = objectMapper.writeValueAsString(requestParam);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/signup").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("error", Matchers.is(true)))
                .andExpect(jsonPath("message", Matchers.is("Dup Member!")))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
