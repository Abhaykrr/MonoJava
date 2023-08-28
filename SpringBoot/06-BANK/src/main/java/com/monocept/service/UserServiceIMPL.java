package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.User;
import com.monocept.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void addUser(User user) {
		userRepo.save(user);
		System.out.println("New User Added with useeId :" +user.getUserid());
		
	}

	@Override
	public List<User> allUser() {
		return userRepo.findAll();
		}

}
