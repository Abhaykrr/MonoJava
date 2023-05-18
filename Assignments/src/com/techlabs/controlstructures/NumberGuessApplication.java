package com.techlabs.controlstructures;

import java.util.Scanner;

public class NumberGuessApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println("Generating Number");
			int randomNumber = (int)(100*Math.random());
			
			System.out.println("Number Generated : "+randomNumber+" Visible For Testing purpose");
			
			System.out.println("Random Number Generated Between 1 And 100");
			System.out.println("Start Guessing you have 10 chances");
			
			int chanceLeft = 10;
			for(int i=1;i<=10;i++) {
				System.out.println("Guess The Number " +chanceLeft-- +" chances Left");
				int guess = scanner.nextInt();
				
				if(guess == randomNumber) {
					System.out.println("Congrats you won the game ");
					break;
				}
				else if(guess < randomNumber)
					System.out.println("Your guess is less than the Random Number");
				else
					System.out.println("Your guess is greater than the Random Number");
				
				if(chanceLeft==0) 
					System.out.println("You Loose");
				
			}
			System.out.println("Want to play again Yes or No");
			
			String playAgain =  scanner.next();
			
			if(playAgain.equalsIgnoreCase("no"))
				System.exit(0);
			
		
			
			
		}
		
	}

}
