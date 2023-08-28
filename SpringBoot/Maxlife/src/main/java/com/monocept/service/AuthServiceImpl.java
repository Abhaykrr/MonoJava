	package com.monocept.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;

import com.monocept.entity.Role;
import com.monocept.entity.User;
import com.monocept.exception.UserAPIException;
import com.monocept.payload.LoginDto;
import com.monocept.payload.RegisterDto;
import com.monocept.repository.RoleRepository;
import com.monocept.repository.UserRepository;
import com.monocept.security.JwtTokenProvider;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;





@Service
public class AuthServiceImpl implements AuthService {
	
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private JwtTokenProvider jwtTokenProvider;
	private PasswordEncoder passwordEncoder;
	
	

	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.jwtTokenProvider = jwtTokenProvider;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String login(LoginDto loginDto) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token=jwtTokenProvider.generateToken(authentication);

		return token;
	}

	@Override
	public String register(RegisterDto registerDto) {
		if(userRepository.existsByUsername(registerDto.getUsername()))
			throw new UserAPIException(HttpStatus.BAD_REQUEST,"User already exists");

			User user= new User();

			user.setUsername(registerDto.getUsername());

			user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
			
			
			String requestRole = registerDto.getRole();
		

			Role userRole=roleRepository.findByRolename(requestRole);
			
			if(userRole!=null) {
				
				if(userRole.getRoleid()==1) { // Customer
					user.setCustomer(registerDto.getCustomer());
				}
				

				if(userRole.getRoleid()==2) { // Admin
					user.setAdmin(registerDto.getAdmin());
				}
				

				if(userRole.getRoleid()==3) {  // Employee
					user.setEmployee(registerDto.getEmployee());
				}
				

				if(userRole.getRoleid()==4) {  // Agent
					user.setAgent(registerDto.getAgent());
				}
				
			}else {
				return "Role Not Found";
			}
		

			user.setRole(userRole);

			userRepository.save(user);

			System.out.println(user);

			return "User registered successfully";
	}

}
