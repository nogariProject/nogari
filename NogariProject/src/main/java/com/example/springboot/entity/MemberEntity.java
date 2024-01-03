package com.example.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name="MEMBER")
public class MemberEntity {
	
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="NAME", nullable=false)
	private String name;
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	public String getId() {
		return id;
	}
	  
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	  
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getPassword() {
		return password;
	}
	  
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "id = " + id + ", name = " + name + ", password = " + password;
	}
}