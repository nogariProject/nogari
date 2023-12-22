package com.example.springboot.controller;

import com.example.springboot.data.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @PostMapping("add")
    public void addMember(@RequestBody Member member){
        log.info("REGISTER MEMBER");
        log.info(member.toString());
    }
    @PutMapping("edit/{id}")    //
    public void editMember (@PathVariable Long id, @RequestBody Member member){
        log.info("UPDATE MEMBER");
        log.info("ID: " + id);

    }
    @DeleteMapping("delete/{id}")
    public void deleteMember(@PathVariable Long id){
        log.info("DELETE MEMBER");
        log.info("ID: " + id);
    }
}
