package com.monocept.payload;

import com.monocept.entity.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RegisterDto {
	
	private String username;
	
	private String password;
	
	private String role;
	
	private Customer customer;
	
	private Admin Admin;
	
	private Employee Employee;
	
	private Agent Agent;

}
