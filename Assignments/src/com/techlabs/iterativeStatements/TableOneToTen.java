package com.techlabs.iterativeStatements;

import java.util.Scanner;

public class TableOneToTen {

	public static void main(String[] args) {
       
		
		
		
		int tableOf;
		
		System.out.println("Table from 1 to --");
		Scanner scanner =new Scanner(System.in);
		int upto = scanner.nextInt();
		
		
		
		for(int j=1;j<=upto;j++) {
			tableOf=j;
			
			System.out.println(" Table of " +j);
			for(int i=1;i<=10;i++) {
				System.out.println(+tableOf +" * " +i+" =  " +tableOf*i);
			}
			
			System.out.println();
			
		}
		
		
	}

}
