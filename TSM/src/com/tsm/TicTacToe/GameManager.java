package com.tsm.TicTacToe;

import java.util.Scanner;

// Sample I/O at Bottom

public class GameManager {
	
	static Scanner scanner = new Scanner(System.in);
	static boolean isPlayer1 = true;
	static boolean isPlayer2 = false;

	public static void main(String[] args) {
		
		Board board = new Board();
		startGame(board);
		
	}
	
	public static void startGame(Board board) {
		
		while(true) {
			display(board);
			MarkType mark = board.checkWin();
			
			status(mark,board);
		}
	}
	
	private static void status(MarkType mark,Board board) {
		
		if(mark == MarkType.O) {
			printBoard(board);
			System.out.println("\tPlayer 2 (O) Wins");
			System.exit(0);
		}else if( mark == MarkType.X) {
			printBoard(board);
			System.out.println("\tPlayer 1 (X) Wins");
			System.exit(0);
		}else if(board.isBoardFull()){
			printBoard(board);
			System.out.println("\tTie ");
			System.exit(0);
		}
	}

	public static void display(Board board) {
		
		printBoard(board);
		displayTurn();
		System.out.print("\nChoose Your Location From (1-9) : ");
		int location = scanner.nextInt();
		
		if(location >0 && location <10) {
			
			if( isPlayer1) 
				board.cell[location-1].setMark(MarkType.X);
			else if( isPlayer2) 
				board.cell[location-1].setMark(MarkType.O);
				
		}else {
			System.out.println("\tEnter Valid Loaction");
		}
		
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
	
	public static void displayTurn() {
		if(isPlayer1) System.out.println("\n      Turn : Player 1 (X)");
		if(isPlayer2) System.out.println("\n      Turn : Player 2 (O)");
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
