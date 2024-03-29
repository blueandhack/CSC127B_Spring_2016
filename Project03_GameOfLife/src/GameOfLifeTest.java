
/*
 * CSc 127B Spring 2016, Project 03
 *
 * Project Name: GameOfLife
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * This is test class for test GameOfLife.java.
 * It checks every method, and get return value.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {

	// Test constructor and getters
	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	// test growCellAt and cellAt
	@Test
	public void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);

		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));

	}

	// test neighborsWrapping method
	@Test
	public void testNeighborsWrapping() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));
	}

	// check neighborsWrapping method
	@Test
	public void testNeighborsWrappingTwo() {
		GameOfLife society = new GameOfLife(6, 5);
		society.growCellAt(0, 0);
		society.growCellAt(0, 2);
		society.growCellAt(0, 4);
		society.growCellAt(5, 2);
		society.growCellAt(5, 3);
		society.growCellAt(5, 4);

		
		System.out.println(society.toString());
		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(2, society.neighborCount(0, 2));
		assertEquals(3, society.neighborCount(0, 4));
		assertEquals(2, society.neighborCount(5, 2));
		assertEquals(4, society.neighborCount(5, 3));
		assertEquals(3, society.neighborCount(5, 4));
	}

	// check toString method
	@Test
	public void testToString() {

		GameOfLife society = new GameOfLife(4, 14);
		society.growCellAt(1, 2);
		society.growCellAt(2, 3);
		society.growCellAt(3, 4);

		String sandSociety = "..............\n..O...........\n...O..........\n....O.........";

		assertEquals(sandSociety, society.toString());

	}

	// check update method
	@Test
	public void testUpdate() {
		GameOfLife society = new GameOfLife(4, 14);
		society.growCellAt(1, 2);
		society.growCellAt(2, 3);
		society.growCellAt(3, 4);

		society.update();

		assertFalse(society.cellAt(1, 2));
		assertTrue(society.cellAt(2, 3));
		assertFalse(society.cellAt(3, 4));

	}

	// check update method
	@Test
	public void testUpdateTwo() {
		GameOfLife society = new GameOfLife(5, 5);
		society.growCellAt(2, 2);
		society.growCellAt(2, 3);
		society.growCellAt(3, 1);
		society.growCellAt(3, 2);

		society.update();

		assertTrue(society.cellAt(2, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(2, 3));
		assertTrue(society.cellAt(3, 1));
		assertTrue(society.cellAt(3, 2));
		assertTrue(society.cellAt(3, 3));

	}

	// check update method when a cell has 0 neighbor, 1 neighbor, 2 neighbors,
	// 3 neighbors, 4 neighbors, 5 neighbors, 6neighbors, 7 neighbors, 8
	// neighbors
	@Test
	public void testUpdateThree() {
		GameOfLife society = new GameOfLife(100, 100);
		// 0
		society.growCellAt(1, 1);

		// 1
		society.growCellAt(5, 1);
		society.growCellAt(4, 1);

		// 4
		society.growCellAt(9, 1);
		society.growCellAt(9, 2);
		society.growCellAt(9, 0);
		society.growCellAt(8, 1);
		society.growCellAt(8, 2);

		// 6
		society.growCellAt(19, 1);
		society.growCellAt(19, 2);
		society.growCellAt(19, 0);
		society.growCellAt(18, 1);
		society.growCellAt(18, 2);
		society.growCellAt(18, 0);
		society.growCellAt(20, 1);

		// 7
		society.growCellAt(29, 1);
		society.growCellAt(29, 2);
		society.growCellAt(29, 0);
		society.growCellAt(30, 1);
		society.growCellAt(30, 2);
		society.growCellAt(30, 0);
		society.growCellAt(28, 1);
		society.growCellAt(28, 2);

		// 8
		society.growCellAt(39, 1);
		society.growCellAt(39, 2);
		society.growCellAt(39, 0);
		society.growCellAt(40, 1);
		society.growCellAt(40, 2);
		society.growCellAt(40, 0);
		society.growCellAt(38, 1);
		society.growCellAt(38, 2);
		society.growCellAt(38, 0);

		society.update();

		assertFalse(society.cellAt(1, 1));
		assertFalse(society.cellAt(5, 1));
		assertFalse(society.cellAt(9, 1));
		assertFalse(society.cellAt(19, 1));
		assertFalse(society.cellAt(29, 1));
		assertFalse(society.cellAt(39, 1));

	}

	// check rows and cols when set a cell out side society
	@Test
	public void testRowsAndCols() {
		GameOfLife society = new GameOfLife(5, 5);
		society.growCellAt(-1, -1);
		society.growCellAt(-1, 2);
		society.growCellAt(5, 5);
		society.growCellAt(5, 2);

		String sandSociety = ".....\n.....\n.....\n.....\n.....";

		assertEquals(sandSociety, society.toString());

		assertFalse(society.cellAt(-1, -1));
		assertFalse(society.cellAt(-1, 2));
		assertFalse(society.cellAt(5, 5));
		assertFalse(society.cellAt(5, 2));

	}

}
