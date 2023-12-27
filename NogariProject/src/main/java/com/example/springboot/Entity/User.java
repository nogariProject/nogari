package com.example.springboot.Entity;

import com.example.springboot.Controller.Request.UserSignupRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPwd;

    public static User create(UserSignupRequest userSignupRequest){
        return User.builder()
                .loginId(userSignupRequest.getLoginId())
                .userName(userSignupRequest.getName())
                .userPwd(userSignupRequest.getPassword())
                .build();
    }
}
