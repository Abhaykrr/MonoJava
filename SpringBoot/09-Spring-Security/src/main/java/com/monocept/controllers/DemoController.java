package com.monocept.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class DemoController {
	
	@GetMapping("/users")
	public String users() {
		return "All Users";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "I am Admin";
	}

}
