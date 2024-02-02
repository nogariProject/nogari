package com.example.springboot.controller;

import com.example.springboot.data.dto.UserDto;
import com.example.springboot.data.entity.User;
import com.example.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "전체 회원 목록 조회")
    public List<UserDto> getAllUsers(){
        List<User> users = userService.readAllUsers();
        log.info(users.toString());
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "지정된 id 회원 조회")
    public UserDto getOneUser(@PathVariable long id){
        return convertToDto(userService.readUserById(id));
    }
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 등록 FORM")
    public void getNewUser(){
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "회원 등록")
    public UserDto postNewUser(@RequestBody User user){
        log.info("postNewUser");
        return convertToDto(userService.createUser(user));
    }
    @GetMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 수정 FORM")
    public UserDto getEditUser(@PathVariable long id){
        return convertToDto(userService.readUserById(id));
    }
    @PutMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 수정")
    public Integer postEditUser(@PathVariable long id, @RequestBody User user){
        return userService.putEditUser(id,user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "지정된 id로 회원 삭제")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }
    @DeleteMapping("/")                // 회원 삭제
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "전체 회원 삭제")
    public void deleteUsers() {
        userService.deleteUsers();
    }
    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

};
