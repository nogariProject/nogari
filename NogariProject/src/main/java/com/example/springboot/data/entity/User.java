package com.example.springboot.data.entity;

import com.example.springboot.data.enumerate.Authority;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USERS")
public class User {

	@Id @GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	@Column(name="USER_NAME", unique = true, nullable = false)
	private String username;

	@Column(name= "PASSWORD", nullable = false)
	private String password;

	@Column(name = "AUTORITY", nullable = false)
	private Authority authority;

}
