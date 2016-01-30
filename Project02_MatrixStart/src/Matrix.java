/*
 * CSc 127B Spring 2016, Project 02
 *
 *	Project Name: Matrix
 *
 * SL Letter: C
 * Author:  Yujia Lin
 * SL Name: Cody Jensen
 *
 * ---
 * The file is a class, and we can use the class to create a object.
 * The class should store a 2D array, and it has some method can add, multiply, 
 * get sum all of elements and transpose the 2D array. 
 */
public class Matrix {

	private int[][] t = null;
	int rows, cols;

	// The construct method creates an empty 2D array
	public Matrix(int[][] table) {
		rows = table.length;
		cols = table[0].length;

		t = new int[table.length][table[0].length];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				t[r][c] = table[r][c];
			}
		}
	}

	// get row
	public int rows() {
		return rows;
	}

	// get col
	public int columns() {
		return cols;
	}

	// get a element by row and column
	public int get(int row, int column) {
		return t[row][column];
	}

	// add a 2D array for Matrix
	public Matrix add(Matrix b) {
		int[][] temp = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				temp[r][c] += this.get(r, c) + b.get(r, c);
			}
		}
		return new Matrix(temp);
	}

	// Multiply every element in this matrix by factor
	// 1 2 3 scalarMultiply(2) -> 2 4 6
	// 4 5 6 -> 8 10 12
	public void scalarMultiply(int factor) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				this.t[r][c] = this.get(r, c) * factor;
			}
		}
	}

	// Return the sum of all integers in this Matrix
	// 1 2 3 sumOfAllElements() returns 1+2+3+4+5+6 = 21
	// 4 5 6
	public int sumOfAllElements() {
		int sum = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				sum += this.get(r, c);
			}
		}
		return sum;
	}

	// Change this Matrix to its transpose. Explained at
	// https://en.wikipedia.org/wiki/Transpose
	// 1 2 3 transpose()
	// 4 5 6
	// -> 1 4
	// -> 4 5
	// -> 3 6
	// The rows become the columns.
	public void transpose() {
		int[][] temp = new int[cols][rows];
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				temp[i][j] = t[j][i];
			}
		}

		int tempRows = rows;
		rows = cols;
		cols = tempRows;
		t = temp;
	}

}