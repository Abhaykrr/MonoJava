package game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class CellTest {
	
	Board board;
	@InjectMocks
	Cell cell;
	
	@BeforeEach
	void init() {
		board = new Board();
		cell = new Cell();
	}

	@Test
	void testCell() {

		assertEquals(MarkType.EMPTY, cell.getMark());
		
	}

	@Test
	void testIsEmpty() {
		assertEquals(MarkType.EMPTY, cell.getMark());
	}

	@Test
	void testGetMark() {
		
		cell.setMark(MarkType.O);
		
		assertEquals(MarkType.O, cell.getMark());
		
		}
	

	@Test
	void testSetMark() {
		
		cell.setMark(MarkType.O);
//		Mockito.doThrow(CellAlreadyMarkedException.class).when(cell).setMark(MarkType.O);
		
		 CellAlreadyMarkedException mockException = mock(CellAlreadyMarkedException.class);

		    // Set up the behavior of the mockException
		    doThrow(mockException).when(cell).setMark(MarkType.X);
//		assertThrows(CellAlreadyMarkedException.class, ()->cell.setMark(MarkType.O));
		
	}
	


}
