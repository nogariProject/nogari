package com.example.springboot.controller;

import com.example.springboot.data.entity.User;
import com.example.springboot.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserRestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserServiceImpl msi;
    @GetMapping("/")                // 회원 목록
    public ResponseEntity<List<User>> getAllMembers(){
        List<User> users = (List<User>) msi.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/new")              // 회원 등록 폼
    public void getNewMember(){
    }
    @PostMapping("/new")             // 회원 등록
    public ResponseEntity<User> postNewMember(@RequestBody User user){
        User savedUser = msi.saveMember(user);
        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }
    @GetMapping("/{id}")             // 회원 조회
    public ResponseEntity<User> getOneMember(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(msi.getMemberById(id));
    }
    @GetMapping("/{id}/edit")        // 회원 수정 폼
    public ResponseEntity<User> getEditMember(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(msi.getMemberById(id));
    }
//    @PostMapping("/{id}/edit")       // 회원 수정
//    public ResponseEntity<Member> postEditMember(@PathVariable Long id, @RequestBody Member member){
//        Member newMember = msi.replaceEditMember();
//        return ResponseEntity.status(HttpStatus.OK).body(newMember);
//    }
    @DeleteMapping("/{id}/delete")   // 회원 삭제
    public void deleteMember(@PathVariable Long id) {
        msi.deleteById(id);
    }
};
