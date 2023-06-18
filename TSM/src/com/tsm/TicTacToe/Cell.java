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
				
				if(GameManager.isPlayer1 ==true ) {
					GameManager.isPlayer1=false;
					GameManager.isPlayer2=true;
				}
				else if(GameManager.isPlayer2) {
					GameManager.isPlayer2 = false;
					GameManager.isPlayer1 = true;
				}
				
			}
		}
		catch(CellAlreadyMarkedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
