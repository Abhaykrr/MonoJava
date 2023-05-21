package com.techlabs.controlstructures;

import java.io.IOException;
import java.util.Scanner;

public class PigDiceGameApplication {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Turn 1 ------");
		int currTurnScore = 0;
		
		while(true) {
			
			System.out.println("Roll (r) or Hold (h)");	
			
			String decision = scanner.next();
			
			if(decision.equalsIgnoreCase("r")) {
				
				int random  = generateRandom();
				
				if(random == 1 ) {
					System.out.println("Die : " +random);
					System.out.println("Turn over       : No Score");
					System.out.println("Total Score     : " +PigGame.score);
					PigGame.turn++;
					currTurnScore = 0;
					
					
					System.out.println('\n' +"------Turn " +(PigGame.turn+1)+"------");
					
					continue;
				}
				
				currTurnScore += random;
				System.out.println("Die :" +random +" Current Turn Score : " +currTurnScore);
				
				
			}else {
				PigGame.score += currTurnScore;
				PigGame.turn +=1;
				
				System.out.println("Score for turn  : " +currTurnScore);
				System.out.println("Total Score     : " +PigGame.score);
				
				if(PigGame.score>=20) {
					System.out.println("You finished in : " +PigGame.turn +" Turns");
					System.exit(0);
				}
				
				currTurnScore = 0;
				System.out.println('\n'  +"------Turn " +(PigGame.turn+1)+"------");
				
			}
			
			
		}
		
		
		
	}
	
	public static int generateRandom() {
		return (int) (Math.random() *6) + 1;
	}

}

class PigGame{
	static int score = 0;
	static int turn = 0;
}
