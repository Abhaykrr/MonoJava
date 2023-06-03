package com.techlabs.Calisthenics;

import java.util.Scanner;

public class OneLevel_Indendation {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int matrix[][] = new int[2][3];
		
		
		readMatrix(scanner,matrix);
		displayMatrix(matrix);
	}

	public static void readMatrix(Scanner scanner, int[][] matrix) {
		System.out.println("Enter Matrix");
		for(int i=0;i<matrix.length;i++) 
			readRow(scanner,matrix,i);
	}

	public static void readRow(Scanner scanner, int[][] matrix, int i) {	
		for(int j=0;j<matrix[0].length;j++) 
			matrix[i][j]=scanner.nextInt();
	}

	public static void displayMatrix( int[][] matrix) {
		for(int i=0;i<matrix.length;i++)
			displayRow(matrix,i);
	}

	public static void displayRow( int[][] matrix, int i) {
		for(int j=0;j<matrix[0].length;j++) {
			System.out.print(matrix[i][j]+" ");
		}
		System.out.println();	
	}

}
