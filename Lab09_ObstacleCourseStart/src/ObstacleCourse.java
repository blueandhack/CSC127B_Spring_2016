
/**
 * ObstacleCourse: A type that reads a text file representing an obstacle
 * course from which to escape. This does not find the shortest path.
 * 
 * The two methods you must implement are at the bottom of this file
 * 
 * @author Rick Mercer
 * @author YOUR NAMW
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ObstacleCourse {

	protected char[][] course;
	private int rows;
	private int cols;
	private int startRow;
	private int startCol;
	private int foundRow;
	private int foundCol;

	public ObstacleCourse(String fileName) {
		rows = 0;
		cols = 0;
		startRow = -1;
		startCol = -1;
		foundRow = -1;
		foundCol = -1;
		Scanner obstacleCourseFile = null;
		try {
			obstacleCourseFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
		}

		rows = obstacleCourseFile.nextInt();
		cols = obstacleCourseFile.nextInt();
		obstacleCourseFile.nextLine();
		course = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			String line = obstacleCourseFile.nextLine();
			for (int c = 0; c < cols; c++) {
				course[r][c] = line.charAt(c);
				if (course[r][c] == 'S') {
					startRow = r;
					startCol = c;
					course[r][c] = ' ';
				}
			}
		}
	}

	public int getExitColumn() {
		return foundCol;
	}

	public int getExitRow() {
		return foundRow;
	}

	public int getStartColumn() {
		return startCol;
	}

	public int getStartRow() {
		return startRow;
	}

	public String toString() {
		String result = "";
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (course[r][c] == '.')
					result += "  ";
				else
					result += " " + course[r][c];
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Mark a path with 'O' to an exit if found and return true using the
	 * recursive backtracking algorithm shown in the assignment. If you try a
	 * different algorithm don't ask for help.
	 */
	public boolean findTheExit(int row, int col) {
		boolean escaped = false;
		if (this.possible(row, col)) {
			course[row][col] = '.';
			if (((row == course.length - 1 || row == 0) || (col == course[0].length - 1 || col == 0))
					&& course[row][col] != ' ') {
				foundRow = row;
				foundCol = col;
				escaped = true;
			} else {
				escaped = findTheExit(row + 1, col);
				if (!escaped && course[row][col + 1] == ' ')
					escaped = findTheExit(row, col + 1);
				if (!escaped && course[row - 1][col] == ' ')
					escaped = findTheExit(row - 1, col);
				if (!escaped && course[row][col - 1] == ' ')
					escaped = findTheExit(row, col - 1);
			}
			if (escaped) {
				course[row][col] = 'O';
			}
		}

		return escaped;
	}

	/**
	 * @return True if row and col are in range and the char is a blank ' '
	 */
	public boolean possible(int row, int col) {
		// TODO: Finish this method
		if (course[row][col] == ' ') {
			return true;
		}
		return false;
	}
}
