package com.monocept.service;

import java.util.List;

import com.monocept.entity.Account;
import com.monocept.entity.Bank;

public interface BankService {
	
	void addNewBank(Bank bank);
	
	Account addBankAccounts(String abbrevation ,double balance);
	
	List<Bank> allBank();
	

}
