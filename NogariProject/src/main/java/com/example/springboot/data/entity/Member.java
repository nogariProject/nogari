package com.example.springboot.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class Member {

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name= "PASSWORD")
	private String password;

}
