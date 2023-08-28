package com.monocept.service;

import com.monocept.entity.Transaction;

public interface TransactionService {
	
	public void credit(Transaction transaction);
	public void debit(Transaction transaction);
	public void transfer(Transaction transaction);
	

}
