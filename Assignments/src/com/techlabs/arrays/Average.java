package com.techlabs.arrays;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of array");
		int length = scanner.nextInt();
		
		int arr[]= new int[length];
		
		double sum = 0 ;
		
		System.out.println("Enter elements");
		for(int i=0;i<length;i++) {
			arr[i]=scanner.nextInt();
			sum+=arr[0];
		}
		
		System.out.println("Sum of array is "+ sum);
		System.out.println("Average of array is "+ sum/length);
		
		
	}

}
