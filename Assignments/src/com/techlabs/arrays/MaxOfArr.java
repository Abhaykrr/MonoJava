package com.techlabs.arrays;

import java.util.Scanner;

public class MaxOfArr {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the length of array");
		int length = scanner.nextInt();
		
		int arr[]= new int[length];
		int ans = Integer.MIN_VALUE;
		
		
		System.out.println("Enter elements");
		for(int i=0;i<length;i++) {
			arr[i]=scanner.nextInt();
			
			if(arr[i]>ans) ans=arr[i];
		}
		
		System.out.println("Max Element of the Array is "+ ans);

	}

}
