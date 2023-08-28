package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.CustomerRepository;
import com.monocept.service.CustomerService;

@RestController
@RequestMapping("/bank/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addcustomerbankaccount/{customerid}/{abbrevation}/{balance}")
	public void addCustomerBankAccount(@PathVariable(name = "customerid") int customerId,@PathVariable(name = "abbrevation") String abbrevation,@PathVariable(name = "balance") double balance) {
		customerService.addCustomerBankAccount(customerId,abbrevation,balance);
	}
	
	@GetMapping("/customers")
	public List<Customer> allCustomers(){
		return customerService.allCustomers();
	}
	

	
	
}
