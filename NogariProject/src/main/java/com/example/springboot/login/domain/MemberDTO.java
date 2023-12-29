package com.example.springboot.login.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO implements Serializable {
    private static final long serialVersionUID = 3978735145350955687L;

    private String userId;
    private String password;
    private String name;
}
