package com.tsm.emailValidation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Sample I/O at the bottom

public class CustomerManage {

  public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total no of customers :");
		int noOfCustomer = scanner.nextInt();
		
		Customer customers[]= new Customer[noOfCustomer];
		
		getCustomerDetails(scanner,customers);
		displayCustomer(customers);
	}
	
  public static void getCustomerDetails(Scanner scanner, Customer[] customers) {
	   
		   int customerId ;
	       scanner.nextLine(); 
	       String name ;
	       String email ;
	       String password ;
	       
	       for(int i=0;i<customers.length;i++) {
	    	   
	    	   System.out.println("Enter Customer details in format ");
	   		   System.out.println("CustomerID , CustomerName , Mail & Password");
	    	   
	    	    customerId = scanner.nextInt();
		        scanner.nextLine(); 
		        name = scanner.nextLine();
		        email = scanner.nextLine();
		        password = scanner.nextLine();
		        
		        if(!validateEmail(email)) email = "Format incorrect";
		        
		        customers[i] = new Customer(customerId,name,email,password);
				
	       }
	}

  public static void displayCustomer(Customer[] customers) {
	  
	  System.out.println("---------------------------------");
	  System.out.println("Customer Information");
		
	  for(Customer customer :customers )
		  System.out.println(customer);
	  
	}
  
  public static boolean validateEmail(String email) {
      String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z]+.com+$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(email);
      return matcher.matches();
   }

}
/*
Enter total no of customers :
3
Enter Customer details in format 
CustomerID , CustomerName , Mail & Password
101
ak
ak@gmail.com
123
Enter Customer details in format 
CustomerID , CustomerName , Mail & Password
201
dk
dkgmail.com
123
Enter Customer details in format 
CustomerID , CustomerName , Mail & Password
301
bk
bk@yahoo.com
123
---------------------------------
Customer Information
---------------------------------
Customer ID     : 101
Name            : ak
Email           : ak@gmail.com
Password        : 123
---------------------------------

---------------------------------
Customer ID     : 201
Name            : dk
Email           : Format incorrect
Password        : 123
---------------------------------

---------------------------------
Customer ID     : 301
Name            : bk
Email           : bk@yahoo.com
Password        : 123
---------------------------------

*/
