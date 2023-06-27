package com.tsm.TicTacToe;

public class Player {

	static boolean isPlayer1 = true;
	static boolean isPlayer2 = false;
	
	static MarkType choicePlayer1 = MarkType.X;
	static MarkType choicePlayer2 = MarkType.O;
	
	public static void switchPlayer() {
		Player.isPlayer1 = !Player.isPlayer1;
		Player.isPlayer2 = !Player.isPlayer2;
	}
	
	public static void displayTurn() {
		if(Player.isPlayer1) System.out.println("\n      Turn : Player 1 ("+choicePlayer1+")");
		if(Player.isPlayer2) System.out.println("\n      Turn : Player 2 ("+choicePlayer2+")");
	}
}
