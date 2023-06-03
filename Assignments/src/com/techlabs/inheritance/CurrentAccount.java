package com.techlabs.inheritance;


class CurrentAccount extends Account{
	
	private int over_Draft_Limit;
	public CurrentAccount(int accountNo, String name, double balance,int over_Draft_Limit) {
		super(accountNo, name, balance);
		this.over_Draft_Limit = over_Draft_Limit;
		
	}
	public int getOver_Draft_Limit() {
		return over_Draft_Limit;
	}
	public void setOver_Draft_Limit(int over_Draft_Limit) {
		this.over_Draft_Limit = over_Draft_Limit;
	}
	
	
	public String toString() {
		return "Account No : " +getAccountNo() +" Name : "+getName() +" Balance : " +getBalance() +" Interest : "+this.over_Draft_Limit;
	}
	
	
}
