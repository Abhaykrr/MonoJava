package com.techlabs.exceptionHandling;

public class Account {

	private int accountNo;
	private String name;
	private String accountType;
	private Double balance;
	
	public Account(int accountNo, String name, String accountType, Double balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.accountType = accountType;
		
		if(balance<5000) throw new InsufficientAccountBalance(balance);
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

//	public void setBalance(Double balance) {
//		this.balance = balance;
//	}
	
	public void deposit(Double amount) {
		
		this.balance +=amount;
		
	}
	
	public void withdraw(Double amount) {
		
		Double currAmount = balance -amount;
		if(currAmount<5000 || amount>balance) throw new InsufficientAccountBalance(currAmount);
		else balance -=amount;
		
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", accountType=" + accountType + ", balance="
				+ balance + "]";
	}
	
	
	
	
	
	
	
}
