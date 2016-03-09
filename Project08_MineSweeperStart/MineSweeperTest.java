/*
 * CSc 127B Spring 2016, Project 08
 *
 * Project Name: MineSweeper
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 */
/**
 * The beginning of a unit test for MineSweeper.  
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class MineSweeperTest {

	// Test getAdjacentMines
	@Test
	public void testGetAdjacentMinesWithAGivenTwodArrayOfBooleans() {

		boolean[][] b1 = { { false, false, false, false, false }, { false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);

		// Check adjacent mines around every possible GameSquare
		assertEquals(0, ms.getAdjacentMines(0, 0));
		assertEquals(1, ms.getAdjacentMines(0, 1));
		assertEquals(2, ms.getAdjacentMines(0, 2));
		assertEquals(2, ms.getAdjacentMines(0, 3));
		assertEquals(1, ms.getAdjacentMines(0, 4));

		assertEquals(0, ms.getAdjacentMines(1, 0));
		assertEquals(1, ms.getAdjacentMines(1, 1));
		assertEquals(2, ms.getAdjacentMines(1, 2)); // works even if it is a
													// mine
		assertEquals(2, ms.getAdjacentMines(1, 3));
		assertEquals(2, ms.getAdjacentMines(1, 4));

		assertEquals(0, ms.getAdjacentMines(2, 0));
		assertEquals(1, ms.getAdjacentMines(2, 1));
		assertEquals(3, ms.getAdjacentMines(2, 2));
		assertEquals(2, ms.getAdjacentMines(2, 3));
		assertEquals(2, ms.getAdjacentMines(2, 4));

		assertFalse(ms.won());

	}

	// Test getTotalMineCount and Set Flag and Visible
	@Test
	public void testGetMinesNumbersAndFlagAndVisible() {

		boolean[][] b1 = { { false, false, false, false, false }, { false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);

		// Check adjacent mines around every possible GameSquare
		assertEquals(3, ms.getTotalMineCount());
		ms.toggleFlagged(0, 1);
		assertTrue(ms.isFlagged(0, 1));
		ms.toggleFlagged(0, 1);
		assertFalse(ms.isFlagged(0, 1));
		ms.click(0, 0);
		assertTrue(ms.isVisible(0, 1));
		assertTrue(ms.isMine(1, 3));
		assertFalse(ms.isFlagged(0, 1));

	}

	// Test Create a New MineSweeper
	@Test
	public void testCreateMineSweeper() {

		MineSweeper ms = new MineSweeper(5, 5, 25);

		assertEquals(25, ms.getTotalMineCount());

	}

	// Test Lost
	@Test
	public void testLost() {

		boolean[][] b1 = { { false, false, false, false, false }, { false, false, true, true, false },
				{ false, false, false, true, false }, };

		MineSweeper ms = new MineSweeper(b1);

		ms.click(1, 3);

		assertTrue(ms.lost());
		assertFalse(ms.won());
	}

	// Test Won
	@Test
	public void testWon() {
		boolean[][] b = { { true, true, false }, { true, true, true }, { true, true, true } };
		MineSweeper ms = new MineSweeper(b);
		ms.click(0, 2);
		assertTrue(ms.won());
		assertFalse(ms.lost());
	}

	// Test Won
	@Test
	public void testWonTwo() {
		boolean[][] b = { { true, true, false }, { true, true, true }, { true, true, true } };
		MineSweeper ms = new MineSweeper(b);
		ms.click(0, 0);
		assertFalse(ms.won());
	}

	// Test click
	@Test
	public void testClick() {
		boolean[][] b = { { false, true, false, false }, { false, false, false, false }, { true, false, false, true },
				{ false, true, true, false }, { false, false, false, false } };
		MineSweeper ms = new MineSweeper(b);

		ms.click(1, 1);
		ms.click(1, 3);
		ms.toggleFlagged(1, 2);
		ms.click(0, 3);
		assertTrue(ms.isVisible(0, 3));
		assertTrue(ms.isVisible(1, 3));
		assertTrue(ms.isVisible(0, 2));
		ms.toggleFlagged(3, 0);
		ms.click(3, 0);
		assertFalse(ms.isVisible(3, 0));
		ms.click(4, 3);
		assertTrue(ms.isVisible(4, 3));
		ms.click(4, 3);
		assertTrue(ms.isVisible(4, 3));
		ms.click(0, 1);

	}

	// Test toggleFlagged
	@Test
	public void testToggleFlagged() {
		boolean[][] b = { { false, true, false, false }, { false, true, false, false } };
		MineSweeper ms = new MineSweeper(b);

		ms.click(1, 0);
		ms.toggleFlagged(1, 0);
		assertFalse(ms.isFlagged(1, 0));

		ms.toggleFlagged(1, 1);
		assertTrue(ms.isFlagged(1, 1));
		assertFalse(ms.isVisible(1, 1));

	}

	// Test toString
	@Test
	public void testToString() {

		boolean[][] b1 = { { false, false, false, false, false }, { false, false, true, true, false },
				{ false, false, false, true, false }, };
		MineSweeper ms = new MineSweeper(b1);

		assertEquals("o o o o o\no o * * o\no o o * o", ms.toString());

	}

}