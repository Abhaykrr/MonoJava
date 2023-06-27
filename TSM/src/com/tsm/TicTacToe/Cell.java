package com.tsm.TicTacToe;

public class Cell {

	private MarkType mark;

	public Cell() {
		this.mark = MarkType.EMPTY;
	}
	
	public boolean isEmpty() {
		if(this.mark == MarkType.EMPTY) return true;
		return false;
	}
	
	public MarkType getMark() {
		return this.mark;
	}
	
	public void setMark(MarkType mark) throws CellAlreadyMarkedException{
		
		try {
			if(this.mark != MarkType.EMPTY) 
				throw new CellAlreadyMarkedException(this.mark);
			else {
				this.mark = mark;
				Player.switchPlayer();
			}
		}
		
		catch(CellAlreadyMarkedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
