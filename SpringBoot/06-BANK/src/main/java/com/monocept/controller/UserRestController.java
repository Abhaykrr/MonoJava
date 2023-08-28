package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.User;
import com.monocept.service.UserService;

@RestController
@RequestMapping("/bank")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@GetMapping("/allusers")
	public List<User> allUser(){
		return userService.allUser();
	}

}
