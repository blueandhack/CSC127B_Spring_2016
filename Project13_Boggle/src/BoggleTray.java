
/**
 * CSc 127B Spring 2016, Project 13
 *
 * Project Name: Boggle
 * 
 * Model the tray of dice in the game Boggle. A DiceTray can be constructed with
 * a 4x4 array of characters for testing. A 2nd constructor with no arguments
 * simulates the shaking of 16 dice and selection of one of the 6 sides.
 * 
 * @author Yujia Lin and Jiaxuan Chen
 */

import java.util.Random;

public class BoggleTray {

	// private class Dice
	private class Dice {
		private char[] data;

		public Dice(char[] array) {
			data = new char[6];
			for (int i = 0; i < 6; i++)
				data[i] = array[i];
		}

		// get random letter
		public char get() {
			Random generator = new Random();
			int index = generator.nextInt(6);
			return data[index];
		}
	}

	/**
	 * TODO: Construct a tray of dice by simulating the actual Boggle "roll" of
	 * the 16 Boggle dice. This means you will also have to model the 16 dice:
	 * 
	 * @param newBoard
	 *            The 2D array of characters used in testing
	 */
	public BoggleTray() {
		dices = new Dice[16];
		dices[0] = new Dice(new char[] { 'L', 'R', 'Y', 'T', 'T', 'E' });
		dices[1] = new Dice(new char[] { 'A', 'N', 'A', 'E', 'E', 'G' });
		dices[2] = new Dice(new char[] { 'A', 'F', 'P', 'K', 'F', 'S' });
		dices[3] = new Dice(new char[] { 'Y', 'L', 'D', 'E', 'V', 'R' });
		dices[4] = new Dice(new char[] { 'V', 'T', 'H', 'R', 'W', 'E' });
		dices[5] = new Dice(new char[] { 'I', 'D', 'S', 'Y', 'T', 'T' });
		dices[6] = new Dice(new char[] { 'X', 'L', 'D', 'E', 'R', 'I' });
		dices[7] = new Dice(new char[] { 'Z', 'N', 'R', 'N', 'H', 'L' });
		dices[8] = new Dice(new char[] { 'E', 'G', 'H', 'W', 'N', 'E' });
		dices[9] = new Dice(new char[] { 'O', 'A', 'T', 'T', 'O', 'W' });
		dices[10] = new Dice(new char[] { 'H', 'C', 'P', 'O', 'A', 'S' });
		dices[11] = new Dice(new char[] { 'N', 'M', 'I', 'H', 'U', 'Q' });
		dices[12] = new Dice(new char[] { 'S', 'E', 'O', 'T', 'I', 'S' });
		dices[13] = new Dice(new char[] { 'M', 'T', 'O', 'I', 'C', 'U' });
		dices[14] = new Dice(new char[] { 'E', 'N', 'S', 'I', 'E', 'U' });
		dices[15] = new Dice(new char[] { 'O', 'B', 'B', 'A', 'O', 'J' });

		board = new char[4][4];

		int k = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = dices[k].get();
				k++;
			}
		}

	}

	private char[][] path;
	private char[][] board;
	public static final char TRIED = '@';
	public static final char PART_OF_WORD = '!';
	// private String attempt;
	public static final int SIZE = 4;
	public static final int NUMBER_SIDES = 6;

	private Dice[] dices;
	private String word;

	/**
	 * Construct a tray of dice using a hard coded 2D array of chars. Use this
	 * for testing
	 * 
	 * @param newBoard
	 *            The 2D array of characters used in testing
	 */
	public BoggleTray(char[][] newBoard) {
		board = newBoard;
	}

	/**
	 * Provide a textual version of this BoggleTray
	 */
	@Override
	public String toString() {
		String result = "\n";
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (board[r][c] == 'Q')
					result += " Qu";
				else
					result += "  " + board[r][c];
			}
			result += " \n\n";
		}
		return result;
	}

	/**
	 * Return true if search is word that can found on the board following the
	 * rules of Boggle
	 * 
	 * @param str
	 *            A word that may be in the board by connecting consecutive
	 *            letters
	 * 
	 * @return True if str is found in the tray according to the rules of Boggle
	 */
	public boolean foundInBoggleTray(String str) {
		if (str.length() < 3)
			return false;
		String attempt = str.toUpperCase().trim();
		word = attempt;
		boolean found = false;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++)
				if (board[r][c] == attempt.charAt(0)) {
					// Set up another 2d array to mark tried spots
					initializeTriedLocations();
					// Use recursive backtracking to find word in the tray
					found = recursiveSearch(r, c);
					// Make sure you don't return false because the word may
					// begin in a later spot
					// In other words, do not return false if a first search
					// fails
					if (found) {
						return true;
					}
				}
		}
		return false;
	}

	// Keep a 2nd 2D array to remember the characters that have been tried
	private void initializeTriedLocations() {
		path = new char[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++)
			for (int c = 0; c < SIZE; c++)
				path[r][c] = '.';
	}

	// This is like the Obstacle course escape algorithm. Now you need to
	// checking eight possible directions instead of only four.
	//
	// WrapAround is not required.
	//
	// Hint: Treat 'Qu' as the char 'Q' somehow.
	//
	private boolean recursiveSearch(int row, int column) {

		return recursiveSearch(row, column, 0);
	}

	private boolean recursiveSearch(int row, int colum, int index) {
		boolean found = false;
		if (valid(row, colum)) {
			path[row][colum] = TRIED;

			if (word.charAt(word.length() - 1) == board[row][colum] && index == word.length() - 1) {
				found = true;
			} else {
				if (word.charAt(index) == 'Q') {
					index++;
				}
				// below
				if (valid(row + 1, colum) && !found && board[row + 1][colum] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row + 1, colum, index + 1);
				}
				// bottom left
				if (!found && valid(row + 1, colum - 1) && !found
						&& board[row + 1][colum - 1] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row + 1, colum - 1, index + 1);
				}
				// left
				if (!found && valid(row, colum - 1) && !found && board[row][colum - 1] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row, colum - 1, index + 1);
				}
				// top left
				if (!found && valid(row - 1, colum - 1) && !found
						&& board[row - 1][colum - 1] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row - 1, colum - 1, index + 1);
				}
				// top
				if (!found && valid(row - 1, colum) && !found && board[row - 1][colum] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row - 1, colum, index + 1);
				}
				// top right
				if (!found && valid(row - 1, colum + 1) && !found
						&& board[row - 1][colum + 1] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row - 1, colum + 1, index + 1);
				}
				// right
				if (!found && valid(row, colum + 1) && !found && board[row][colum + 1] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row, colum + 1, index + 1);
				}
				// bottom right
				if (!found && valid(row + 1, colum + 1) && !found
						&& board[row + 1][colum + 1] == word.charAt(index + 1)) {
					path[row][colum] = PART_OF_WORD;
					found = recursiveSearch(row + 1, colum + 1, index + 1);
				}
			}
		}

		path[row][colum] = '.';

		return found;
	}

	// check bounds and char
	private boolean valid(int r, int c) {
		return r >= 0 && r < SIZE && c >= 0 && c < SIZE && path[r][c] != PART_OF_WORD;
	}

}