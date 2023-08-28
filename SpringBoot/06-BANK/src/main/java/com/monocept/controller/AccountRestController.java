package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Account;
import com.monocept.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/allaccounts")
	public List<Account> allAccounts(){
		return accountService.allAccounts();
	}

}
