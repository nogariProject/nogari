package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexGet() {
		return "GET";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String indexPost() {
		return "POST";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public String indexPut() {
		return "PUT";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public String indexDelete() {
		return "DELETE";
	}
}
