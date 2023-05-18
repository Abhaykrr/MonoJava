package com.techlabs.controlstructures;

import java.util.Scanner;

public class CurrencyDenomination {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Amount");
		
		int amount = scanner.nextInt();
		
		int arr[]=new int[4];
		int leftAmount=0;
		
		if(amount<50000 && amount%100 == 0) {
			
			arr[0]=amount/2000;
			leftAmount = amount%2000;
			
			arr[1]=leftAmount/500;
			leftAmount = leftAmount%500;
			
			arr[2]=leftAmount/200;
			leftAmount = leftAmount%200;
			
			arr[3]=leftAmount/100;
			leftAmount = leftAmount%100;
			
			
		}else {
			System.out.println("Please Enter amount les than 50K and Multiles of 100 Only");
		}
		
		
		System.out.println("Two Thousand Notes  :"  +arr[0]);
		System.out.println("Five Hundered Notes :" +arr[1]);
		System.out.println("Two Hundred Notes   :" +arr[2]);
		System.out.println("One Hundred Notes   :" +arr[3]);

	}

}
