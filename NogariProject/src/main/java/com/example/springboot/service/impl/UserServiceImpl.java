package com.example.springboot.service.impl;

import com.example.springboot.data.entity.User;
import com.example.springboot.data.repository.UserRepository;
import com.example.springboot.exception.UserNotFoundException;
import com.example.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly=true)
    public List<User> readAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public User readUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("No user with id %s is available", id)));
    }
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }
    @Override
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public void deleteUsers(){
        userRepository.deleteAll();
    }
    @Override
    public Integer putEditUser(long id, User user) {
        return userRepository.updateUserById(id, user.getUsername(), user.getPassword(), String.valueOf(user.getAuthority()));
    }
}

