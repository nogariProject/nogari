package com.example.springboot.controller;

import com.example.springboot.data.entity.Member;
import com.example.springboot.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public void login(@RequestBody Member member){
        log.info("login");
        log.info(member.toString());

    }

}
