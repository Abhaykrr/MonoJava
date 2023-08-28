package com.monocept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Transaction;
import com.monocept.service.TransactionService;

@RestController
@RequestMapping("/bank/transaction")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/credit")
	public void credit(@RequestBody Transaction transaction) {
		transactionService.credit(transaction);
	}
	
	@PostMapping("/debit")
	public void debit(@RequestBody Transaction transaction) {
		transactionService.debit(transaction);
	}
	
	@PostMapping("/transfer")
	public void transfer(@RequestBody Transaction transaction) {
		transactionService.transfer(transaction);
	}
	
}
