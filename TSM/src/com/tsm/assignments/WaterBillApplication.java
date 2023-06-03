package com.tsm.assignments;

import java.util.Scanner;

/*
 
  
Enter units consumed
40
Total water bill : 275

Enter units consumed
120
Total water bill : 1275

Enter units consumed
270
Total water bill : 5475


*/
public class WaterBillApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter units consumed");
		
		int unitsConsumed = scanner.nextInt();
		int metercharge=75;
		int cost=20;
		int waterbill;
		
		if(unitsConsumed<=100) cost = 5;
		else if(unitsConsumed<=250) cost = 10;
		
		waterbill = unitsConsumed*cost + metercharge;
		
		System.out.println("Total water bill : " +waterbill);
		
		scanner.close();
		

	}

}
