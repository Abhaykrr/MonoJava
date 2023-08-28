package com.monocept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Customer;
import com.monocept.service.CustomerService;

@RestController
@RequestMapping("/maxlife")
@CrossOrigin(origins="*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getcustomer/{customerid}")
	public Customer getCustomer(@PathVariable(name = "customerid") int customerId) {
		return customerService.getCustomer(customerId);
	}

}
