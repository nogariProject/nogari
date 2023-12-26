package com.example.springboot.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    private String userId;

    private String userName;

    private String userPwd;
}
