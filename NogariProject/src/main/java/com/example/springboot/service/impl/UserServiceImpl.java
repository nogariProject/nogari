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

    @Override
    public List<User> readAllUsers() {
        return (List<User>) mr.findAll();
    }
    @Override
    public User readUserById(Long id){
        return mr.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("No user with id %s is available", id)));
    }
    @Override
    public User createUser(User user){
        return mr.save(user);
    }
    @Override
    public void deleteUserById(Long id){
        mr.deleteById(id);
    }
    @Override
    public void deleteUsers(){
        mr.deleteAll();
    }
    @Override
    public Integer putEditUser(long id, User user) {
        return mr.updateUserById(id, user.getUsername(), user.getPassword(), String.valueOf(user.getAuthority()));
    }
}

