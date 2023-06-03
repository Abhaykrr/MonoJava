package com.tsm.assignments;

import java.util.Scanner;

/*
Enter a number
7
Factorial  : 5040
isPrime    : true
First N fibonacci numbers
0 1 1 2 3 5 8
 */

public class BasicCoding {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		int num1 = scanner.nextInt();
		
		System.out.println("Factorial  : "+factorial(num1) );
		System.out.println("isPrime    : "+isPrime(num1));
		System.out.println("First N fibonacci numbers" );
		printFibonacciNumbers(num1);
		 
		scanner.close();
		
	}
	
	 static int factorial(int n){    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 } 
	 
	 
	  static boolean isPrime(int n)
	    {
	      
	        if (n <= 1)
	            return false;
	        
	        for (int i = 2; i <= n / 2; i++)
	            if (n % i == 0)
	                return false;
	 
	        return true;
	    }
	  
	  
	   static void printFibonacciNumbers(int n)
	    {
	        int f1 = 0, f2 = 1, i;
	        System.out.print(f1 + " ");
	        if (n < 1)
	            return;
	          
	        for (i = 1; i < n; i++) {
	            System.out.print(f2 + " ");
	            int next = f1 + f2;
	            f1 = f2;
	            f2 = next;
	        }
	    }

}
