package com.example.springboot.controller;

import com.example.springboot.data.entity.User;
import com.example.springboot.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserRestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserServiceImpl msi;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "전체 회원 목록 조회")
    public Iterable<User> getAllUsers(){
        return msi.readAllUsers();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "지정된 id 회원 조회")
    public User getOneUser(@PathVariable Long id){
        return msi.readUserById(id);
    }
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 등록 폼")
    public void getNewUser(){
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "회원 등록")
    public User postNewUser(@RequestBody User user){
        return msi.createUser(user);
    }

    @GetMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 수정 폼")
    public User getEditUser(@PathVariable Long id){
        return msi.readUserById(id);
    }
    @PutMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 수정")
    public ResponseEntity<User> postEditUser(@PathVariable Long id, @RequestBody User user){
        //User newMember = msi.replaceEditMember();
        return null;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "지정된 id로 회원 삭제")
    public void deleteUserById(@PathVariable Long id) {
        msi.deleteUserById(id);
    }
    @DeleteMapping("/")                // 회원 삭제
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "전체 회원 삭제")
    public void deleteUsers() {
        msi.deleteUsers();
    }


};
