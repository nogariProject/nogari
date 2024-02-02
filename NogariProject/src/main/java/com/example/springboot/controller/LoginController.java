package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        log.info("login");
        return "login.html";
    }
}
