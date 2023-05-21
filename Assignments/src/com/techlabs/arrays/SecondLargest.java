package com.techlabs.arrays;

import java.util.Scanner;

public class SecondLargest {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the length of array");
		
		int length = scanner.nextInt();
		
		int arr[]= new int[length];
		int ans[] = new int[2];
		
		System.out.println("Enter elements");
		
		
		for(int i=0;i<length;i++) 
			arr[i]=scanner.nextInt();
		
		ans[1]=Integer.MIN_VALUE;
		
		for(int i=0;i<length;i++) {
			if(arr[i]>ans[1]) {
				ans[0]=ans[1];
				ans[1]=arr[i];
			}else if(arr[i]>ans[0]) {
				ans[0]=arr[i];
			}
		}
		
		System.out.println(ans[0]);

	}

}
