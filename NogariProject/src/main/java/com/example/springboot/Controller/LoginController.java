package com.example.springboot.Controller;

import com.example.springboot.Controller.Request.UserSignupRequest;
import com.example.springboot.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class LoginController {

    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public void singUp(@RequestBody @Valid UserSignupRequest userSignupRequest){
        userService.userSignup(userSignupRequest);
    }


}