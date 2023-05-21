package com.techlabs.arrays;

import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the length of array");
		
		int length = scanner.nextInt();
		
		int arr[]= new int[length];
		
		System.out.println("Enter elements");
		
		
		for(int i=0;i<length;i++) 
			arr[i]=scanner.nextInt();
		
		        for (int i = 0; i < length; i++)
	            for (int j = 0; j < length - i - 1; j++)
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
		 
		 
		for(Integer x :arr)
		{
			System.out.print(x +" ");
		}
		

	}

}
