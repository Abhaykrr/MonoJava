package com.techlabs.inheritance;

public class Bank {

	public static void main(String[] args) {
		
		
		CurrentAccount acc1 = new CurrentAccount(201,"Abhay" ,20,10);
		SavingsAccount acc2 = new SavingsAccount(301,"Ak" ,20,10);
		
         System.out.println(acc1);	
         System.out.println(acc2);
		
	}

}




