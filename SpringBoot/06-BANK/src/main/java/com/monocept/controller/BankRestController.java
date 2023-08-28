package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Bank;
import com.monocept.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankRestController {
	
	@Autowired
	private BankService bankService;

	
	@PostMapping("/addnewbank")
	public void addNewBank(@RequestBody Bank bank) {
		bankService.addNewBank(bank);
	}
	
	@GetMapping("/allbanks")
	public List<Bank> allBanks(){
		return bankService.allBank();
	}
}
