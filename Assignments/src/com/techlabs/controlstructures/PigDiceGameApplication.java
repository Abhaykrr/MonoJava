package com.techlabs.controlstructures;

import java.io.IOException;
import java.util.Scanner;

// Sample I/O at bottom

public class PigDiceGameApplication {

	public static void main(String[] args) throws IOException {
		
		
		int gameScore = 20 ;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Turn 1 ------");
		int currTurnScore = 0;
		
		while(true) {
			
			
			if(PigGame.score+currTurnScore>=gameScore) {
				System.out.println("Score for turn  : "+ currTurnScore);
				System.out.println("Total Score     : " +(PigGame.score + currTurnScore));
				System.out.println("You finished in : " +(PigGame.turn +1) +" Turns");
				System.exit(0);
			}
			
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

/*------Turn 1 ------
Roll (r) or Hold (h)
r
Die : 1
Turn over       : No Score
Total Score     : 0

------Turn 2------
Roll (r) or Hold (h)
r
Die :4 Current Turn Score : 4
Roll (r) or Hold (h)
r
Die :2 Current Turn Score : 6
Roll (r) or Hold (h)
r
Die :2 Current Turn Score : 8
Roll (r) or Hold (h)
r
Die : 1
Turn over       : No Score
Total Score     : 0

------Turn 3------
Roll (r) or Hold (h)
r
Die :4 Current Turn Score : 4
Roll (r) or Hold (h)
r
Die :4 Current Turn Score : 8
Roll (r) or Hold (h)
r
Die :4 Current Turn Score : 12
Roll (r) or Hold (h)
r
Die :4 Current Turn Score : 16
Roll (r) or Hold (h)
h
Score for turn  : 16
Total Score     : 16

------Turn 4------
Roll (r) or Hold (h)
r
Die : 1
Turn over       : No Score
Total Score     : 16

------Turn 5------
Roll (r) or Hold (h)
r
Die :2 Current Turn Score : 2
Roll (r) or Hold (h)
r
Die :4 Current Turn Score : 6
Score for turn  : 6
Total Score     : 22

You finished in : 5 Turns
*/
