package com.example.springboot.Service;

import com.example.springboot.Controller.Request.LoginRequest;
import com.example.springboot.Controller.Request.UserSignupRequest;

public interface UserService {

    //회원생성
    String userSignup(UserSignupRequest userSignupRequest);

    String login(LoginRequest loginRequest);
}
