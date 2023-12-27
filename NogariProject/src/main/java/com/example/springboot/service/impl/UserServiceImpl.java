package com.example.springboot.service.impl;

import com.example.springboot.data.entity.User;
import com.example.springboot.data.repository.UserRepository;
import com.example.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository mr;

    public List<User> getAllMembers() {
        return (List<User>) mr.findAll();
    }
    public User getMemberById(Long id){
        Optional<User> member = mr.findById(id);
        return member.orElse(null);
    }
    public User saveMember(User user){
        return mr.save(user);
    }
    public void deleteById(Long id){
        mr.deleteById(id);
    }

    public User replaceEditMember(Long id) {
        mr.deleteById(id);
        return null;
    }
}

