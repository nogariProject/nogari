package com.example.springboot.controller;

import com.example.springboot.service.MemberService;
import com.example.springboot.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberRestController.class)
@EntityScan()
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberServiceImpl msi;
    @Test
    @DisplayName("[API][GET] 회원 목록 전체 조회")
    public void getAllMembers_Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/members/"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("[API][GET] 회원 등록 폼")
    public void getNewMember_Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/members/"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("[API][POST] 회원 등록")
    public void postNewMember_Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/members/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(
                                "{ \"userName\" : \"user1\", \"password\" : \"test2\"}"
                        )
                ).andExpect(status().isOk());
    }
}