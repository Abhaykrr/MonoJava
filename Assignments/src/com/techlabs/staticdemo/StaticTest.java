package com.techlabs.staticdemo;

 public class StaticTest {

	public static void main(String[] args) {
		
		Account acc1 = new Account(201,"Abhay",50000);
		Account acc2 = new Account(301,"Ak",50000);
		Account acc3 = new Account(401,"bk",50000);
		
		System.out.println("Hello");
		Account.totalAccounts();

	}

}

class Account{
	
	static int count =0;
	
    private int accountNumber;
    private String name;
    private double balance;
    
	public Account(int accountNumber, String name, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		
		displayStatus();
	}
	
	void displayStatus() {
		count++;
		System.out.println("Account "+count +" created");
		
	}
	
	static void totalAccounts() {
		System.out.println("Total Accounts in system :" +count);
	}
    
    
}
