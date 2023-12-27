package com.example.springboot.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class User {

	@Id @GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	@Column(name="USER_NAME", unique = true, nullable = false)
	private String userName;

	@Column(name= "PASSWORD", nullable = false)
	private String password;

}
