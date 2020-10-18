package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.service.UserService;

@CrossOrigin
@Controller
public class UserRestController {

//	@Autowired
//	private UserService service;
//	
//	@PostMapping(value = "/register", consumes="application/json")
//	public String saveUser(@RequestBody User user) {
//		service.saveUser(user);
//		return "User saved";
//	}
//	
//	@GetMapping(value = "/login", produces = "application/json")
//	public User login(@RequestParam("username") String username,
//			@RequestParam("password") String password,
//			@RequestParam("role") String role) {
//		Login login = new Login(username,password,role);
//		User user = service.validate(login);
//		System.out.println(user.getName()+"\t" + user.getPassword());
//		return user;
//	}
}
