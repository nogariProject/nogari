package com.example.springboot.Service;

import com.example.springboot.Controller.Request.UserSignupRequest;
import com.example.springboot.Entity.User;
import com.example.springboot.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public void userSignup(UserSignupRequest userSignupRequest) {

        User user = User.create(userSignupRequest);
        System.out.println(user);
        userRepository.save(user);

    }
}
