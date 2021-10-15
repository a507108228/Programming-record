package com.lzw.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class UserService {

	@Autowired
	private HelloWorld helloWorld;
	
	public UserService() {
		System.out.println("UserService Constructor...");
	}
	
}
