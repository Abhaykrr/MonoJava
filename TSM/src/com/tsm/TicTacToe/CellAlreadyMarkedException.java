package com.tsm.TicTacToe;

public class CellAlreadyMarkedException extends RuntimeException{
	
	private MarkType mark;
	
	public CellAlreadyMarkedException(MarkType mark) {
		this.mark = mark;
	}
	
	public String getMessage() {
	return   "    +---------------------------------------+\n" 
	        +"    | Cell is Already Marked " +mark+"              |\n" 
	        +"    | Try In A Different Empty Cell         |\n"
	        +"    +---------------------------------------+";
    }

}
