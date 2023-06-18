package com.techlabs.exceptionHandling;

import java.util.Scanner;

public class AccountManage {

	public static void main(String[] args) {
	
		
		Scanner scanner = new Scanner(System.in);
		
		Account account = null;
		try {
			System.out.println("Enter Account Details in Format");
			System.out.println("AccountNo Name AccountType Balance");
			int accNo = scanner.nextInt();
			String name =  scanner.next();
			String accType = scanner.next();
			Double balance = scanner.nextDouble();
			
			account = new Account(accNo, name, accType, balance);
		}catch(InsufficientAccountBalance e) {
			System.out.println(e.getMessage());
			System.out.println("Account Creation Failed Logging Out ...");
			System.exit(0);
		}
		
		System.out.println(account);
		
		while(true) {
			System.out.println();
			System.out.println("Press 1 for Deposit");
			System.out.println("Press 2 for Withdraw");
			System.out.println("Press 3 for See Balance");
			System.out.println("Press 4 for LogOut");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1:{
				System.out.println("\n"+"You are in Deposit Portal");
				System.out.println("Your current balance : " +account.getBalance());
				System.out.println("Enter amount to deposit");
				
				Double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				
				System.out.println("Deposit Successfull Current Balance : " +account.getBalance());
				break;
			}
			
			case 2:{
				try {
					System.out.println("\n"+"You are in Withdraw Portal");
					System.out.println("Your current balance : " +account.getBalance());
					System.out.println("Enter amount to withdraw");
					
					Double withdrawAmount = scanner.nextDouble();
					account.withdraw(withdrawAmount);
					System.out.println("Amount withdraw successfull Current Amount : "+account.getBalance());
				}catch(InsufficientAccountBalance e) {
					System.out.println(e.getMessage());
				}
				
				break;
			}
			
			case 3:{
				System.out.println("Current Balance : " +account.getBalance());
				break;
			}
			
			case 4:{
				System.exit(0);
				break;
			}
			
			default :{
				System.out.println("Enter Valid Choice");
			}
			
			
			}
		}
		
	}

	public static void hello() {
		// TODO Auto-generated method stub
		
	}

}
