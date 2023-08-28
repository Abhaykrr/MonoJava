package com.monocept.service;

import java.util.List;

import com.monocept.entity.Customer;

public interface CustomerService {
	
	void addCustomerBankAccount(int customerId, String abbrevation ,double balance);
	List<Customer> allCustomers();

}
