package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Bank;
import com.monocept.repository.BankRepository;

@Service
public class BankServiceIMPL implements BankService{
	
	@Autowired
	private BankRepository bankRepo;

	@Override
	public void addNewBank(Bank bank) {
		bankRepo.save(bank);
	}

	@Override
	public Account addBankAccounts(String abbrevation, double balance) {
		
		Account newAccount = new Account();
		newAccount.setBalance(balance);
		
		
		Bank dbBank = bankRepo.findByAbbrevation(abbrevation);
		
		if(dbBank!=null) {
			List<Account> dbaccounts = dbBank.getAccounts();
			dbaccounts.add(newAccount);
			dbBank.setAccounts(dbaccounts);
			bankRepo.save(dbBank);
			
			int size = dbBank.getAccounts().size();
			
			System.out.println("New Account Added in Bank With AccountNo :" +dbBank.getAccounts().get(size-1).getAccountno());
		
			return dbBank.getAccounts().get(size-1);
		}
		
		return null;
	}

	@Override
	public List<Bank> allBank() {
		return bankRepo.findAll();
	}

	
}
