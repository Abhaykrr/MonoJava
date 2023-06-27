package com.tsm.TicTacToe;

public class ResultAnalyser {
	
	
	public static void status(MarkType mark,Board board) {
		
		
		if(Player.choicePlayer1 == mark)
			System.out.println("\t Player 1("+mark+") "+ResultType.Win);
		else if(Player.choicePlayer2 == mark)
			System.out.println("\t Player 2("+mark+") " +ResultType.Win);
		else if(board.isBoardFull()){
			System.out.println("\t "+ResultType.Draw);
		}
		if(mark!=MarkType.EMPTY || board.isBoardFull()) System.exit(0);
	}

}
