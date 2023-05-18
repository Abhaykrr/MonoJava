package com.techlabs.iterativeStatements;

import java.util.Scanner;

public class TableHorizontal {

	public static void main(String[] args) {
		
       int tableOf;
		
		System.out.println("Table from 1 to --");
		Scanner scanner =new Scanner(System.in);
		int upto = scanner.nextInt();
		
	
		
		for(int j=1;j<=10;j++) {
			tableOf=j;
			
			for(int i=1;i<=upto;i++) {
			
				System.out.print(i*j+"    ");
				
			}
			
			System.out.println();
			
		}

	}

}
