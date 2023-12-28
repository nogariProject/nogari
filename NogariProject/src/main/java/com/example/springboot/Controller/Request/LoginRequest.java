package com.example.springboot.Controller.Request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class LoginRequest {

    @NotNull(message = "ID는 필수값입니다.")
    private String loginId;

    @NotNull(message = "비밀번호는 필수값입니다.")
    private String password;

}
