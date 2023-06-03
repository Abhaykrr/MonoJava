package com.tsm.assignments;
import java.util.Scanner;

//Sample I/O at bottom

	public class RefactorPigApp {
		
		public static Scanner scanner = new Scanner(System.in);
		public static int score = 0;

		public static void main(String[] args) {
			
			System.out.println("      Turn : "+ (PigGame.turn+1));
			
			while(true) {
				System.out.print("Roll or hold? (r/h): ");
				String move = scanner.next();
				
				if(move.equals("r")) roll();
				else hold();
			}
			
		}

		public static void roll() {
			
	        int randomNumber = PigGame.generateRandom();
	        if(randomNumber == 1) {
	        	score = 0;
	        	 System.out.println("Die : " +randomNumber);
	        	hold();
	        }else {
	        score += randomNumber;
	        
	        if(score+PigGame.score>=PigGame.gameScore) {
	        	System.out.println("Die : " +randomNumber +" Turn Score : " +score);
	        	hold();
	        	System.exit(0);
	        }
	        
	        System.out.println("Die : " +randomNumber +" Turn Score : " +score);
	        
	        } 
		}

		public static void hold() {
			PigGame.score += score;
			PigGame.turn++;
			System.out.println("- - - - - - - - - - - ");
			System.out.println("| Score for turn  : "+ score +"|");
			System.out.println("| Total Score     : " +(PigGame.score)+"|");
			System.out.println("- - - - - - - - - - -  \n");
			if(PigGame.score >= 20) {
				System.out.println("   You Won in " +PigGame.turn+ " turns");
				System.exit(0);
			}else {
				System.out.println("      Turn : "+ (PigGame.turn+1));
			}
			score = 0;
		}
	}

	class PigGame{

		static int gameScore =20;
		static int score = 0;
		static int turn = 0;
		
		static int generateRandom() {
			return (int) (Math.random() *6) + 1;
		}
	}

	/*	
				      Turn : 1
			Roll or hold? (r/h): r
			Die : 5 Turn Score : 5
			Roll or hold? (r/h): r
			Die : 4 Turn Score : 9
			Roll or hold? (r/h): r
			Die : 2 Turn Score : 11
			Roll or hold? (r/h): r
			Die : 2 Turn Score : 13
			Roll or hold? (r/h): r
			Die : 1
			- - - - - - - - - - - 
			| Score for turn  : 0|
			| Total Score     : 0|
			- - - - - - - - - - -  
			
			      Turn : 2
			Roll or hold? (r/h): r
			Die : 6 Turn Score : 6
			Roll or hold? (r/h): r
			Die : 3 Turn Score : 9
			Roll or hold? (r/h): r
			Die : 3 Turn Score : 12
			Roll or hold? (r/h): h
			- - - - - - - - - - - 
			| Score for turn  : 12|
			| Total Score     : 12|
			- - - - - - - - - - -  
			
			      Turn : 3
			Roll or hold? (r/h): r
			Die : 2 Turn Score : 2
			Roll or hold? (r/h): r
			Die : 6 Turn Score : 8
			- - - - - - - - - - - 
			| Score for turn  : 8|
			| Total Score     : 20|
			- - - - - - - - - - -  
			
			   You Won in 3 turns

	*/


