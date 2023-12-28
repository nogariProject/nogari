package com.example.springboot.login.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVO <T> {
	private boolean error = false;
	private String message;
	private T data;
}
