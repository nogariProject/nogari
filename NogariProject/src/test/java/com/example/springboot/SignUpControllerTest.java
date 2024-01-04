package com.example.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springboot.entity.MemberEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class SignUpControllerTest {

	@Autowired
	MockMvc mvc;
	
	@Test
    @DisplayName("가입 테스트")
    void get_test() throws Exception {
        //given
		MemberEntity member = new MemberEntity();
        member.setId("testId");
        member.setName("testName");
        member.setPassword("testPassword");
        
        //when
        String json = member.toJson();
        //then
        mvc.perform(post("/sign-up")
            .content(json) //HTTP Body에 데이터를 담는다
            .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
        )
        .andExpect(status().isOk())
        .andDo(print());
    }
}
