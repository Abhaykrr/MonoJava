package game;


public class Board {

	Cell cell[] = new Cell[9];
	
	public Board() {
		for(int i=0;i<9;i++)
		cell[i]=new Cell();
	}
	
	public boolean isBoardFull() {
		
	    for(int i=0;i<9;i++)
		if(cell[i].getMark() == MarkType.EMPTY) return false;
		
		return true;
	}
	
	public void setCellMark(int location , MarkType mark) throws CellAlreadyMarkedException {
		cell[location-1].setMark(mark);
	}
	
	public MarkType checkWin(Board board) {
		
		  int[][] winningConditions = {
		            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
		            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
		            {0, 4, 8}, {2, 4, 6}             // Diagonals
		    };
		
		for(int [] conditions  :winningConditions) {
			int a = conditions[0]; int b = conditions[1]; int c = conditions[2];
			
			if(board.cell[a].getMark() == board.cell[b].getMark() && board.cell[a].getMark() == board.cell[c].getMark()) {
				return board.cell[a].getMark();
			}
		}
										
			return MarkType.EMPTY;
	}
	
	
	
}
