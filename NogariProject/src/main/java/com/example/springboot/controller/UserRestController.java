package com.example.springboot.controller;

import com.example.springboot.data.entity.User;
import com.example.springboot.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserServiceImpl msi;
    public UserRestController(UserServiceImpl msi) {
        this.msi = msi;
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "전체 회원 목록 조회")
    public Iterable<User> getAllUsers(){
        return msi.readAllUsers();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "지정된 id 회원 조회")
    public User getOneUser(@PathVariable long id){
        return msi.readUserById(id);
    }
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 등록 FORM")
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
    @Operation(summary = "회원 수정 FORM")
    public User getEditUser(@PathVariable long id){
        return msi.readUserById(id);
    }
    @PutMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 수정")
    public Integer postEditUser(@PathVariable long id, @RequestBody User user){
        return msi.putEditUser(id,user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "지정된 id로 회원 삭제")
    public void deleteUserById(@PathVariable long id) {
        msi.deleteUserById(id);
    }

    @DeleteMapping("/")                // 회원 삭제
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "전체 회원 삭제")
    public void deleteUsers() {
        msi.deleteUsers();
    }


};
