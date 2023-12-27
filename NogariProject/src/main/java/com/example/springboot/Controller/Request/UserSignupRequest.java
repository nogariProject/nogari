package com.example.springboot.Controller.Request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignupRequest {

    @NotNull(message = "로그인 아이디를 입력하세요.")
    private String loginId;

    @NotNull(message = "이름을 입력하세요.")
    private String name;

    @NotNull(message = "비밀번호를 입력하세요.")
    private String password;
}
