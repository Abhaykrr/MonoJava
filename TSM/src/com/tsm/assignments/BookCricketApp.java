package com.tsm.assignments;

import java.util.Scanner;

public class BookCricketApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean turnA = true;
		boolean turnB = false;
		int factor = 7;
		int winScore = 100;
		
		while(true) {
			
			
			
			if(cricketGame.scoreA >=winScore && cricketGame.scoreB >=winScore) {
				System.out.println("Tie Happened");
				if(cricketGame.turnA>cricketGame.turnB) 
					System.out.println("A wins");
				else
					System.out.println("B Wins");
				
				System.exit(0);
			}else if(cricketGame.scoreA>=winScore) {
				System.out.println("Player A Wins");
				System.exit(0);
			}else if(cricketGame.scoreB>=winScore) {
				System.out.println("Player B Wins");
				System.exit(0);
			}
			
			if(turnA) System.out.println("\n"+"Turn A");
			    else  System.out.println("\n"+"Turn B");
			
			System.out.println("Enter Anything");
			String des = scanner.nextLine();
			
			int pageNo = generateRandom();
			int mod = pageNo % factor ;
			
			if(turnA) cricketGame.scoreA += mod;
			if(turnB) cricketGame.scoreB += mod;
			
			System.out.println("Page opened : " + pageNo);
			System.out.println("Points Earned = "+pageNo +" % 7" +" = " +mod);
			if(turnA) System.out.println("Score: " +(cricketGame.scoreA));
			if(turnB) System.out.println("Score: " +(cricketGame.scoreB));
			
			if(mod == 0 ) {
				if(turnA == true) {
					turnA = false;
					turnB = true;
					cricketGame.turnA++;
					
				}else if(turnB == true) {
					 turnB = false;
					 turnA = true;
					 cricketGame.turnB++;
				}
		
			}
		}
		
	}
	
	public static int generateRandom() {
		int upto = 300;
		return (int) (Math.random() *upto) + 1;
	}

}

class cricketGame{
	static int scoreA =0;
	static int scoreB =0;
	static int turnA  =0;
	static int turnB  =0;
}
 
