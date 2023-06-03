package com.techlabs.assignment;
import java.util.Scanner;

public class PigDiceGame {
	
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

///*	
//	*/


