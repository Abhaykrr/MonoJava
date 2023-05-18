package com.techlabs.iterativeStatements;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter a Number to Check if prime");
		
		int number = scanner.nextInt();
		int ifprime = 1;
		
		for(int i=2 ;i*i<number;i++) {
			if(number%i==0) {
				ifprime = 0;
				break;
			}
			
		}
		
		if(ifprime==1) System.out.println("Its a Prime No");
		else System.out.println("Not a prime Number");
	}

}
