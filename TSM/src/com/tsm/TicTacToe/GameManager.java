package com.tsm.TicTacToe;

import java.util.Scanner;

// Sample I/O at Bottom

public class GameManager {
	
	static Scanner scanner = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		Board board = new Board();
		startGame(board);
		
	}
	
	public static void startGame(Board board) {
		printBoard(board); // Empty Board
		
		while(true) {
			
			getPlayerInput(board);
			
			printBoard(board);
			
			ResultAnalyser.status(board.checkWin(),board);
		}
	}


	public static void getPlayerInput(Board board) {
		Player.displayTurn();
		System.out.print("\nChoose Your Location From (1-9) : ");
		int location = scanner.nextInt();
		
		try {
			if(location<1 || location >9) throw new InvalidLocationException(location);
		}catch(InvalidLocationException e) {
			System.out.println(e.getMessage());
			return;
		}
		
			if( Player.isPlayer1) 
				board.cell[location-1].setMark(Player.choicePlayer1);
			else if( Player.isPlayer2) 
				board.cell[location-1].setMark(Player.choicePlayer2);
			
		
		System.out.println("---------------------------------");
		
		
	}
	
	
	public static void printBoard(Board board) {
	    System.out.println("\n\t-------------");
	    for (int i = 0; i < 9; i += 3) {
	    	if(i%3==0)
	    		System.out.print("\t");
	        System.out.print("| ");
	        for (int j = i; j < i + 3; j++) {
	        	MarkType mark = board.cell[j].getMark();
	           if(mark!=MarkType.EMPTY)
	        	   System.out.print(mark + " | ");
	           else
	        	   System.out.print(j+1 + " | ");
	        }
	        System.out.println("\n\t-------------");
	    }
	}
	
	

}


/*
 
	-------------
	| 1 | 2 | 3 | 
	-------------
	| 4 | 5 | 6 | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 1 (X)

Choose Your Location in (1-9) : 1
---------------------------------

	-------------
	| X | 2 | 3 | 
	-------------
	| 4 | 5 | 6 | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 2 (O)

Choose Your Location in (1-9) : 2
---------------------------------

	-------------
	| X | O | 3 | 
	-------------
	| 4 | 5 | 6 | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 1 (X)

Choose Your Location in (1-9) : 3
---------------------------------

	-------------
	| X | O | X | 
	-------------
	| 4 | 5 | 6 | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 2 (O)

Choose Your Location in (1-9) : 4
---------------------------------

	-------------
	| X | O | X | 
	-------------
	| O | 5 | 6 | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 1 (X)

Choose Your Location in (1-9) : 5
---------------------------------

	-------------
	| X | O | X | 
	-------------
	| O | X | 6 | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 2 (O)

Choose Your Location in (1-9) : 6
---------------------------------

	-------------
	| X | O | X | 
	-------------
	| O | X | O | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 1 (X)

Choose Your Location in (1-9) : 2
    +---------------------------------------+
    | Cell is Already Marked O              |
    | Try In A Different Empty Cell         |
    +---------------------------------------+
---------------------------------

	-------------
	| X | O | X | 
	-------------
	| O | X | O | 
	-------------
	| 7 | 8 | 9 | 
	-------------

      Turn : Player 1 (X)

Choose Your Location in (1-9) : 7
---------------------------------

	-------------
	| X | O | X | 
	-------------
	| O | X | O | 
	-------------
	| X | 8 | 9 | 
	-------------
	Player 1 (X) Wins

*/
