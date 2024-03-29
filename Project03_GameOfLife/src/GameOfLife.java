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
 * The Game of Life was invented by John Conway to simulate the birth and death of cells in a society. 
 * The file is a class, and it can create a object that is a society. We can add some cells at "the socitey".
 * "The socitey" has rows and cols, and it like a chessboard.
 */
public class GameOfLife {

	private int rows;
	private int cols;
	private String[][] society;

	/**
	 * the constructor so it takes two integer arguments to represent the number
	 * of rows and columns in the game of life. The constructor creates a
	 * society with no cells but space to store rows*cols cells.
	 *
	 * @param rows
	 *            The height of the grid that shows the cells.
	 * @param cols
	 *            The width of the grid that shows the cells.
	 */
	public GameOfLife(int rows, int cols) {
		// Constructor method create a empty chessboard
		// it like this:
		// ..............
		// ..............
		// ..............
		// ..............
		this.rows = rows;
		this.cols = cols;
		this.society = new String[rows][cols];
		for (int i = 0; i < society.length; i++) {
			for (int j = 0; j < society[i].length; j++) {
				society[i][j] = ".";
			}
		}
	}

	/**
	 * Return the number of rows, which can be indexed from 0..numberOfRows()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfRows() {
		return this.rows;
	}

	/**
	 * The number of columns, which can be indexed from 0..numberOfColumns()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfColumns() {
		return this.cols;
	}

	/**
	 * Place a new cell in the society. Precondition: row and col are in range.
	 *
	 * @param row
	 *            The row to grow the cell.
	 * @param col
	 *            The column to grow the cell.
	 */
	public void growCellAt(int row, int col) {
		// "O" is a cell
		if (col < this.cols && col >= 0) {
			if (row < this.rows && row >= 0) {
				this.society[row][col] = "O";
			}
		}

	}

	/**
	 * Return true if there is a cell at the given row and column. Return false
	 * if there is none at the specified location.
	 *
	 * @param row
	 *            The row to check.
	 * @param col
	 *            The column to check.
	 * @return True if there is a cell at the given row or false if none
	 */
	public boolean cellAt(int row, int col) {
		if (col < this.cols && col >= 0) {
			if (row < this.rows && row >= 0) {
				if (society[row][col] == "O") {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return one big string of cells to represent the current state of the
	 * society of cells (see output below where '.' represents an empty space
	 * and 'O' is a live cell. There is no need to test toString. Simply use it
	 * to visually inspect if needed. Here is one sample output from toString:
	 *
	 * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
	 * society.growCellAt(2, 3); society.growCellAt(3, 4);
	 * System.out.println(society.toString());
	 *
	 * Output ..............\n..O...........\n...O..........\n....O.........
	 * 
	 * @return A textual representation of this society of cells.
	 */
	@Override
	public String toString() {
		String society = "";
		for (int i = 0; i < this.society.length; i++) {
			for (int j = 0; j < this.society[i].length; j++) {
				// if (j == this.society[i].length - 1) {
				society = society + this.society[i][j];
				// } else {
				// society = society + this.society[i][j] + " ";
				// }
			}
			if (i != this.society.length - 1) {
				society = society + "\n";
			}
		}
		return society;
	}

	// .....O..O
	// O........
	// O.......O
	// O.......O
	// ....O.O..
	/**
	 * Count the neighbors around the given location. Use wraparound. A cell in
	 * row 0 has neighbors in the last row if a cell is in the same column, or
	 * the column to the left or right. In this example, cell 0,5 has two
	 * neighbors in the last row, cell 2,8 has four neighbors, cell 2,0 has four
	 * neighbors, cell 1,0 has three neighbors. The cell at 3,8 has 3 neighbors.
	 * The potential location for a cell at 4,8 would have three neighbors.
	 *
	 *
	 * The return values should always be in the range of 0 through 8.
	 *
	 * @return The number of neighbors around any cell using wrap around.
	 */
	public int neighborCount(int row, int col) {

		// 0 1 2
		// 7 O 3
		// 6 5 4

		int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

		int count = 0;

		// get the coordinates around, after it count how many cell do they have
		for (int i = 0; i < dirs.length; i++) {
			int r = row + dirs[i][0];
			int c = col + dirs[i][1];
			if (r < 0) {
				r = this.rows - 1;
			}
			if (r > this.rows - 1) {
				r = 0;
			}
			if (c < 0) {
				c = this.cols - 1;
			}
			if (c > this.cols - 1) {
				c = 0;
			}
			if (this.society[r][c] == "O") {
				count++;
			}
		}
		return count;

		// int count = 0;
		// // row - 1, col - 1
		// if (row - 1 < 0 && col - 1 < 0) {
		// if (society[this.rows - 1][this.cols - 1] == "O") {
		// count++;
		// }
		// } else if (row - 1 < 0 && col - 1 >= 0) {
		// if (society[this.rows - 1][col - 1] == "O") {
		// count++;
		// }
		// } else if (row - 1 >= 0 && col - 1 < 0) {
		// if (society[row - 1][this.cols - 1] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row - 1][col - 1] == "O") {
		// count++;
		// }
		// }
		//
		// // row - 1, col
		//
		// if (row - 1 < 0) {
		// if (society[this.rows - 1][col] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row - 1][col] == "O") {
		// count++;
		// }
		// }
		//
		// // row - 1, col + 1
		//
		// if (row - 1 < 0 && col + 1 > this.cols - 1) {
		// if (society[this.rows - 1][0] == "O") {
		// count++;
		// }
		// } else if (row - 1 < 0 && col + 1 <= this.cols - 1) {
		// if (society[this.rows - 1][col + 1] == "O") {
		// count++;
		// }
		// } else if (row - 1 >= 0 && col + 1 > this.cols - 1) {
		// if (society[row - 1][0] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row - 1][col + 1] == "O") {
		// count++;
		// }
		// }
		//
		// // row, col + 1
		//
		// if (col + 1 > this.cols - 1) {
		// if (society[row][0] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row][col + 1] == "O") {
		// count++;
		// }
		// }
		//
		// // row + 1, col + 1
		//
		// if (row + 1 > this.rows - 1 && col + 1 > this.cols - 1) {
		// if (society[0][0] == "O") {
		// count++;
		// }
		// } else if (row + 1 > this.rows - 1 && col + 1 <= this.cols - 1) {
		// if (society[0][col + 1] == "O") {
		// count++;
		// }
		// } else if (row + 1 <= this.rows - 1 && col + 1 > this.cols - 1) {
		// if (society[row + 1][0] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row + 1][col + 1] == "O") {
		// count++;
		// }
		// }
		//
		// // row + 1, col
		//
		// if (row + 1 > this.rows - 1) {
		// if (society[0][col] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row + 1][col] == "O") {
		// count++;
		// }
		// }
		//
		// // row + 1, col - 1
		//
		// if (row + 1 > this.rows - 1 && col - 1 < 0) {
		// if (society[0][this.cols - 1] == "O") {
		// count++;
		// }
		// } else if (row + 1 > this.rows - 1 && col - 1 >= 0) {
		// if (society[0][col - 1] == "O") {
		// count++;
		// }
		// } else if (row + 1 <= this.rows - 1 && col - 1 < 0) {
		// if (society[row + 1][this.cols - 1] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row + 1][col - 1] == "O") {
		// count++;
		// }
		// }
		//
		// // row , col -1
		//
		// if (col - 1 < 0) {
		// if (society[row][this.cols - 1] == "O") {
		// count++;
		// }
		// } else {
		// if (society[row][col - 1] == "O") {
		// count++;
		// }
		// }
		//
		// return count;
	}

	/**
	 * Update the state to represent the next society. Typically, some cells
	 * will die off while others are born.
	 */
	public void update() {

		String[][] societyTwo = new String[this.rows][this.cols];

		for (int i = 0; i < this.society.length; i++) {
			for (int j = 0; j < this.society[i].length; j++) {
				societyTwo[i][j] = this.society[i][j];
			}
		}

		for (int i = 0; i < this.society.length; i++) {
			for (int j = 0; j < this.society[i].length; j++) {
				if (neighborCount(i, j) == 3) {
					societyTwo[i][j] = "O";
				} else if (neighborCount(i, j) == 2) {
					if (this.society[i][j] == "O") {
						societyTwo[i][j] = "O";
					}
					if (this.society[i][j] != "O") {
						societyTwo[i][j] = ".";
					}
				} else if (neighborCount(i, j) == 0 || neighborCount(i, j) == 1 || neighborCount(i, j) == 4
						|| neighborCount(i, j) == 5 || neighborCount(i, j) == 6 || neighborCount(i, j) == 7
						|| neighborCount(i, j) == 8) {
					societyTwo[i][j] = ".";
				}
			}
		}

		for (int i = 0; i < this.society.length; i++) {
			for (int j = 0; j < this.society[i].length; j++) {
				this.society[i][j] = societyTwo[i][j];
			}
		}

	}
}
