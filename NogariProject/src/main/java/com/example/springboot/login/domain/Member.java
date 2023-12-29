package com.example.springboot.login.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
@Table(name = "members") 
public class Member {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@Column(unique = true)
    private String userId;
    
    private String name;
    
    private String password;
	
	
}
