package com.techlabs.arrays;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter M and N ");
		
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		int matrixA[][] = new int[m][n];
		int matrixB[][] = new int[m][n];
		
		int ans[][] = new int[m][n];
		
		System.out.println("Enter matrixA of size " +m+"*"+n);
		
		   for(int i=0;i<m;i++) 
			for(int j=0;j<n;j++) 
				matrixA[i][j]=scanner.nextInt();
		   
		   
		   System.out.println("Enter matrixB of size " +m+"*"+n);
		   
		   for(int i=0;i<m;i++) 
				for(int j=0;j<n;j++) 
					matrixB[i][j]=scanner.nextInt();
		
		
				
		  System.out.println("Sum of the matrixA and matrixB");
		  
		       for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(matrixA[i][j]+matrixB[i][j]+" ");
				}
				System.out.println();
		      }
		
		
		
		

	}

}
