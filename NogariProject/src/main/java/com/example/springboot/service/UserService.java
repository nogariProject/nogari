package com.example.springboot.service;


import com.example.springboot.data.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> readAllUsers();
    public User readUserById(Long id);
    public User createUser(User user);
    public void deleteUserById(Long id);
    public void deleteUsers();
    public Integer putEditUser(long id, User user);
}
