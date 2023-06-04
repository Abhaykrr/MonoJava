package com.tsm.assignments;
import java.util.Scanner;

// Sample I/O at bottom
public class RideBillCalculatorApp {

	public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter your Height");
			
			int height = scanner.nextInt();
			int costOfRide = 0;
			int photoCost =3;
			String wantPhotos;
			
			if(height>120) {
				
				System.out.println("Enter your age");
				int age = scanner.nextInt();
				
				if(age>0 && age<12) costOfRide=5;
				else if(age>=12 && age<18) costOfRide=7;
				else if(age>=18 && age<45) costOfRide=12;
				else if(age>=45 && age<=55) costOfRide=0;
				else {
					System.out.println("Dangerous for you just sit and enjoy");
					System.exit(0);
				}
				
				System.out.println("Want Photos Yes or No");
			    wantPhotos = scanner.next();
			    
			    if(wantPhotos.equalsIgnoreCase("yes")) 
			    	System.out.println("Total Bill with photos : " +(costOfRide+photoCost)+"$");
			    else
			    	System.out.println("Total Bill without photos: " +(costOfRide)+"$");
			    	
			}else {
				System.out.println("Cant Ride");
			}
			
			scanner.close();
			
		}

	}
/*
	Enter your Height
	130
	Enter your age
	22
	Want Photos Yes or No
	yes
	Total Bill with photos : 15$
	
	Enter your Height
	110
	Cant Ride

*/

