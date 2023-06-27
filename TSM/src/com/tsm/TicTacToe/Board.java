package com.tsm.TicTacToe;

public class Board {

	Cell cell[] = new Cell[9];
	
	public Board() {
		for(int i=0;i<9;i++)
		cell[i]=new Cell();
	}
	
	public boolean isBoardFull() {
		
		int count = 0;
		
	    for(int i=0;i<9;i++)
		if(cell[i].getMark() != MarkType.EMPTY) count++;
		
		if(count == 9 ) return true;
		return false;
	}
	
	public void setCellMark(int location , MarkType mark) throws CellAlreadyMarkedException {
		cell[location-1].setMark(mark);
	}
	
	public MarkType checkWin() {
		
		  int[][] winningConditions = {
		            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
		            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
		            {0, 4, 8}, {2, 4, 6}             // Diagonals
		    };
		
		for(int [] conditions  :winningConditions) {
			int a = conditions[0]; int b = conditions[1]; int c = conditions[2];
			
			if(cell[a].getMark() == cell[b].getMark() && cell[a].getMark() == cell[c].getMark()) {
				return cell[a].getMark();
			}
		}
										
			return MarkType.EMPTY;
	}
	
	
	
}
