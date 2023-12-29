package com.example.springboot.Service;

import com.example.springboot.Controller.Request.LoginRequest;
import com.example.springboot.Controller.Request.UserSignupRequest;
import com.example.springboot.Entity.User;
import com.example.springboot.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public String userSignup(UserSignupRequest userSignupRequest) {

            User user = User.create(userSignupRequest);
            System.out.println(userSignupRequest);
            System.out.println(user);

            userRepository.save(user);

            return "회원가입 완료"; // 성공 시 반환할 값

        //회원가입 실패할 경우, 구현 필요
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByLoginId(loginRequest.getLoginId());
        System.out.println(user);
        System.out.println(loginRequest);

        if (user.isPresent()) {
            if (user.get().getUserPwd().equals(loginRequest.getPassword())) {
                return "로그인되었습니다.";
            }else {
                return "ID 또는 PWD가 틀렸습니다.";
            }
        }else {
            return "ID 또는 PWD가 틀렸습니다.";
        }
    }
}
