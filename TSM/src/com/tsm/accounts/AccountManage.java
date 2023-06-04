package com.tsm.accounts;
import java.util.Scanner;

public class AccountManage {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total no of accounts :");
		int noOfAccounts = scanner.nextInt();
		Account accounts[] = new Account[noOfAccounts];
	
		
		
		getAccountData(scanner,accounts);
		displayAccounts(accounts);
		
//		displayMaxBalanceAccount(accounts);  // UsingComparator
		displayMaxBalanceByByBubbleSort(accounts).displayAccountInfo(); 
	
	}

	private static void displayMaxBalanceAccount(Account[] accounts) {
		
		Account accountWithMaxBalance = accounts[0];
        for (int i = 1; i < accounts.length; i++) {
            if (accounts[i].getBalance() > accountWithMaxBalance.getBalance()) {
                accountWithMaxBalance = accounts[i];
            }
        }

        System.out.println("Account with maximum balance:");
        accountWithMaxBalance.displayAccountInfo();
	}

	public static void getAccountData(Scanner scanner, Account[] accounts) {
		
		  int accountNo;
		  String name;
		  String accountTyp;
		  AccountType accountType = AccountType.savings;
		  double balance;
		
		for(int i=0;i<accounts.length;i++) {
			
			System.out.println("Enter Account details ");
			System.out.println("AccountNumber , AccountType , HoldersName & Balanace");
			
			accountNo = scanner.nextInt();
			accountTyp = scanner.next();
			name = scanner.next();
			balance = scanner.nextDouble();
			
			switch(accountTyp) {
				
			case "joint": 
				accountType = AccountType.joint;
				break;
				
			case "current": 
				accountType = AccountType.current;
				break;
				
			case "savings": 
				accountType = AccountType.savings;
				break;	
				
			}
			
			
			accounts[i] = new Account(accountNo,name,accountType,balance);
			
			
			
		}
		
	}
	
	public static void displayAccounts(Account[] accounts) {

		for (Account account : accounts) {
            account.displayAccountInfo();
        }
		
	}
	
	public static Account displayMaxBalanceByByBubbleSort(Account[] accounts) {
		
		 System.out.println("Max Balance");
		  
		  for(int i =0;i<accounts.length;i++) {
			  sortLayer(accounts,i);
		  }
		  
		  return accounts[accounts.length-1];
		  
	  }

	public static void sortLayer(Account[] accounts, int i) {
		
		for(int j=0;j<accounts.length-1;j++) {
			if(accounts[j].getBalance()>accounts[j+1].getBalance()) {
				Account temp = accounts[j];
				accounts[j]=accounts[j+1];
				accounts[j+1]=temp;
			}
		}
		
	}


}
/*

	Enter total no of accounts :
	5
	Enter Account details 
	AccountNumber , AccountType , HoldersName & Balanace
	101
	savings
	ak
	20000
	Enter Account details 
	AccountNumber , AccountType , HoldersName & Balanace
	201
	joint
	sk
	12000
	Enter Account details 
	AccountNumber , AccountType , HoldersName & Balanace
	301
	joint
	dk
	13000
	Enter Account details 
	AccountNumber , AccountType , HoldersName & Balanace
	401
	current
	kk
	14000
	Enter Account details 
	AccountNumber , AccountType , HoldersName & Balanace
	501
	joint
	pk
	1500
	-------------------------------------
	Account Number  : 101
	Name            : ak
	Account Type    : savings
	Balance         : 20000.0
	-------------------------------------
	-------------------------------------
	Account Number  : 201
	Name            : sk
	Account Type    : joint
	Balance         : 12000.0
	-------------------------------------
	-------------------------------------
	Account Number  : 301
	Name            : dk
	Account Type    : joint
	Balance         : 13000.0
	-------------------------------------
	-------------------------------------
	Account Number  : 401
	Name            : kk
	Account Type    : current
	Balance         : 14000.0
	-------------------------------------
	-------------------------------------
	Account Number  : 501
	Name            : pk
	Account Type    : joint
	Balance         : 1500.0
	-------------------------------------
	Max Balance
	-------------------------------------
	Account Number  : 101
	Name            : ak
	Account Type    : savings
	Balance         : 20000.0
	-------------------------------------

*/
