package com.example.springboot.service.impl;

import com.example.springboot.data.entity.User;
import com.example.springboot.data.repository.UserRepository;
import com.example.springboot.exception.UserNotFoundException;
import com.example.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository mr;

    public List<User> readAllUsers() {
        return (List<User>) mr.findAll();
    }
    public User readUserById(Long id){
        return mr.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("No user with id %s is available", id)));
    }
    public User createUser(User user){
        return mr.save(user);
    }
    public void deleteUserById(Long id){
        mr.deleteById(id);
    }
    public void deleteUsers(){
        mr.deleteAll();
    }
    public Integer putEditUser(long id, User user) {
        return mr.updateUserById(id, user.getUsername(), user.getPassword());
    }
}

