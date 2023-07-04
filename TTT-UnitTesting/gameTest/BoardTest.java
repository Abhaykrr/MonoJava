package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
	
	Board board;
	
	@BeforeEach
	void init() {
		board = new Board();
	}


	@Test
	void testBoard() {
		for(int i=0;i<9;i++)
			assertEquals(MarkType.EMPTY, board.cell[i].getMark());
	}

	@Test
	void testIsBoardFull() {
		Cell c = new Cell();
		c.setMark(MarkType.O);
		Arrays.fill(board.cell, c);
		
		assertTrue(board.isBoardFull());
	}

	@Test
	void testSetCellMark() {
		
		board.setCellMark(9, MarkType.O);
		assertEquals(MarkType.O, board.cell[8].getMark());
		
	}

	@Test
	void testCheckWin() {
		
		
		  int[][] winningConditions = {
		            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
		            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
		            {0, 4, 8}, {2, 4, 6}             // Diagonals
		    };
		
		for(int [] conditions  :winningConditions) {
			int a = conditions[0]; int b = conditions[1]; int c = conditions[2];
			board.setCellMark(a+1, MarkType.O);
			board.setCellMark(b+1, MarkType.O);
			board.setCellMark(c+1, MarkType.O);
			
			assertEquals(MarkType.O, board.checkWin(board));
		}
	}

}
