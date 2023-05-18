package com.techlabs.iterativeStatements;

import java.util.Scanner;

public class TableOfNo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number to Print table");
		
		int tableOf = scanner.nextInt();
		
		for(int i=1;i<=10;i++) {
			System.out.println(+tableOf +" * " +i+" =  " +tableOf*i);
		}
		
		

	}

}
