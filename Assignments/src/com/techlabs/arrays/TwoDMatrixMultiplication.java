package com.techlabs.arrays;

import java.util.Scanner;

public class TwoDMatrixMultiplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter column and row of matrixA");
		
		int column1 = scanner.nextInt();
		int row1    = scanner.nextInt();
		
		System.out.println("Enter column and row of matrixB");
		
		int column2 = scanner.nextInt();
		int row2    = scanner.nextInt();
		
		if(row1 != column2 ) {
			System.out.println(+column1 +"*" +row1 +" X " +column2 +"*" +row2 +" Multiplication Not Possible");
			System.exit(0);
		}
		
		int matrixA[][] = new int[column1][row1];
		int matrixB[][] = new int[column2][row2];
		int product[][] = new int[column1][row2];
		int temp = 0;
		
		System.out.println("Enter Matrix A");
		for(int i=0;i<column1;i++)
			for(int j=0;j<row1;j++)
				matrixA[i][j] = scanner.nextInt();
		
		System.out.println("Enter Matrix B");
		for(int i=0;i<column2;i++)
			for(int j=0;j<row2;j++)
				matrixB[i][j] = scanner.nextInt();
		
		System.out.println("Product of Matrix A & Matrix B");
		for(int i=0;i<column1;i++)
			for(int j=0;j<row2;j++) {
				temp = 0;
				
				for(int n = 0;n<row1;n++) 
					temp += matrixA[i][n] * matrixB[n][j]; 	 
				
				product[i][j]=temp;
			}
		
		
		for(int i=0;i<column1;i++) {
			for(int j=0;j<row2;j++)
				System.out.print(product[i][j] +" ");
		
			System.out.println();
		 }
				
		
		
		
	}

}
