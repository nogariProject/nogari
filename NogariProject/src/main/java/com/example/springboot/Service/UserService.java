package com.example.springboot.Service;

import com.example.springboot.Controller.Request.UserSignupRequest;

public interface UserService {

    //회원생성
    void userSignup(UserSignupRequest userSignupRequest);
}
