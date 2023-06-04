package com.tsm.inheritance;

import java.util.Scanner;
// Sample I/O at bottom
public class ManufactureCar {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter numbers of cars to be manufactured");
		int numOfCars = scanner.nextInt();
		
		
		Car cars[] = new Car[numOfCars];
		int i=0;
		
		while(numOfCars-->0) {
			System.out.println("\n" +"Enter Details Car "+(i+1));
			
			System.out.print("Enter Company Name :");
			String carName = scanner.next();
			
			System.out.print("Enter Mileage :");
			Double carMileage = scanner.nextDouble();
			
			System.out.print("Enter Price :");
			Double carPrice = scanner.nextDouble();
			
			cars[i] = new Car(carName,carMileage,carPrice);
			i++;
			
		}
		
		System.out.println();
		for(Car car :cars)
			System.out.println(car);
	}

}
/*
 * Enter numbers of cars to be manufactured 2
 * 
 * Enter Details Car 1 Enter Company Name :bmw Enter Mileage :23 Enter Price
 * :900000
 * 
 * Enter Details Car 2 Enter Company Name :audi Enter Mileage :10 Enter Price
 * :8000000
 * 
 CompanyName : bmw Mileage : 23.0 Price :900000.0 
 CompanyName : audi Mileage :10.0 Price :8000000.0
 */
