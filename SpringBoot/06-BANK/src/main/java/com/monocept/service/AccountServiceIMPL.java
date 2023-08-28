package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.repository.AccountRepository;

@Service
public class AccountServiceIMPL implements AccountService{
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<Account> allAccounts() {
		return accountRepo.findAll();
	}

}
