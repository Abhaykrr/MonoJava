package com.techlabs.iterativeStatements;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
	
		
		int number = scanner.nextInt();
		int ans=1;
		
		while(number>1) {
			ans=ans*number;
			number--;
		}
		
		System.out.println(ans);

	}

}
