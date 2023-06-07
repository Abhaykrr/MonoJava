package com.techlabs.exceptionHandling;

public class InsufficientAccountBalance extends RuntimeException {
	
	Double balance;
	
	InsufficientAccountBalance(Double balance){
		this.balance = balance;
	}
	
	public String getMessage() {
		return "Net Balance should never be less than 5000";
	}

}
