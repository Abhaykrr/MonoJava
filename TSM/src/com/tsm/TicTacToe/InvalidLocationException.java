package com.tsm.TicTacToe;

public class InvalidLocationException extends RuntimeException{

	private int location;
	
	public InvalidLocationException(int location) {
		this.location = location;
	}
	
	public String getMessage() {
		return   "    +---------------------------------------+\n" 
		        +"    | Invalid Location ("+location+") Enter from (1-9)\n"
		        +"    +---------------------------------------+";
	    }
	
	
}
