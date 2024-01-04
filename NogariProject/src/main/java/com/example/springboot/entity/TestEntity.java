package com.example.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name="TEST_TABLE")
public class TestEntity {
	
	@Id
	@Column(name="TEST_ID")
	private String test_id;
	@Column(name="TEST_NAME")
	private String test_name;
	@Column(name="TEST_PASSWORD")
	private String test_password;
	
	public String getId() {
		return test_id;
	}
	  
	public void setId(String test_id) {
		this.test_id = test_id;
	}

	public String getName() {
		return test_name;
	}
	  
	public void setName(String test_name) {
		this.test_name = test_name;
	}	
	
	public String getPassword() {
		return test_password;
	}
	  
	public void setPassword(String test_password) {
		this.test_password = test_password;
	}
	
	public String toString() {
		return "id = " + test_id + ", name = " + test_name + ", password = " + test_password;
	}
	
	public String toJson() {
		return "{\"id\" : \"" + test_id + "\", \"name\" : \"" + test_name + "\", \"password\" : \"" + test_password + "\"}";
	}
}
