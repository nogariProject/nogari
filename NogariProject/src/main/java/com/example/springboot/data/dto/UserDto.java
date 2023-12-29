package com.example.springboot.data.dto;

import com.example.springboot.data.enumerate.Authority;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private Authority authority;


}
