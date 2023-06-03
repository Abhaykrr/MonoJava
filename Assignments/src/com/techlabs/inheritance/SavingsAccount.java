package com.techlabs.inheritance;


class SavingsAccount extends Account{
	
	 private int interest;

	public SavingsAccount(int accountNo, String name, double balance, int interest) {
		super(accountNo, name, balance);
		this.interest = interest;
	}
	
	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String toString() {
		return "Account No : " +getAccountNo() +" Name : "+getName() +" Balance : " +getBalance() +" Interest : "+this.interest;
	}

}
