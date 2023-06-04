package com.tsm.accounts;

public class Account {
	
	    private int accountNo;
	    private String name;
	    private AccountType accountType;
	    private double balance;
	    
	   
	     Account(){
	    	 
	     }
	    
		 Account(int accountNo, String name, AccountType accountType, double balance) {
			this.accountNo = accountNo;
			this.name = name;
			this.accountType = accountType;
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


		public AccountType getAccountType() {
			return accountType;
		}


		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}


		public double getBalance() {
			return balance;
		}


		public void setBalance(double balance) {
			this.balance = balance;
		}
		
	    
		public void displayAccountInfo() {
			System.out.println("-------------------------------------");
			System.out.println("Account Number  : " + accountNo);
			System.out.println("Name            : " + name);
			System.out.println("Account Type    : " + accountType);
			System.out.println("Balance         : " + balance);
			System.out.println("-------------------------------------");
		}
		

	    

}

