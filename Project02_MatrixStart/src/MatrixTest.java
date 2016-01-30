
/*
 *  A Unit test for class Matrix
 *
 * CSc 127B Spring 2016, Project 02
 *
 * SL Letter: C
 * Author:  Yujia Lin
 * SL Name: Cody Jensen
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void FailedTestingRowsAndColumnsAndGet() {
		int[][] a1 = { { 1, 2, 3 }, { -1, -2, -3 } }; // two rows, three columns

		int[][] a2 = { { 4, 5 }, { 6, 7 }, { 8, 9 } }; // three rows, two
														// columns

		Matrix m1 = new Matrix(a1);
		Matrix m2 = new Matrix(a2);

		// Test m1
		assertEquals(2, m1.rows());
		assertEquals(3, m1.columns());
		assertEquals(1, m1.get(0, 0));
		assertEquals(2, m1.get(0, 1));
		assertEquals(3, m1.get(0, 2));
		assertEquals(-1, m1.get(1, 0));
		assertEquals(-2, m1.get(1, 1));
		assertEquals(-3, m1.get(1, 2));

		// Test m2
		assertEquals(3, m2.rows());
		assertEquals(2, m2.columns());
		assertEquals(4, m2.get(0, 0));
		assertEquals(5, m2.get(0, 1));
		assertEquals(6, m2.get(1, 0));
		assertEquals(7, m2.get(1, 1));
		assertEquals(8, m2.get(2, 0));
		assertEquals(9, m2.get(2, 1));

	}

	@Test
	public void FailedTestingAdd() {
		int[][] a1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		Matrix a = new Matrix(a1);

		int[][] a2 = { { -2, 2, -2, 2 }, { 4, -4, 4, -4 } };
		Matrix b = new Matrix(a2);

		Matrix c = a.add(b);

		// Check all elements
		assertEquals(-1, c.get(0, 0));
		assertEquals(4, c.get(0, 1));
		assertEquals(1, c.get(0, 2));
		assertEquals(6, c.get(0, 3));
		assertEquals(9, c.get(1, 0));
		assertEquals(2, c.get(1, 1));
		assertEquals(11, c.get(1, 2));
		assertEquals(4, c.get(1, 3));
	}

	@Test
	public void failedTestingAdd() {
		int[][] a1 = { { 14, 9, 3 }, { 2, 11, 15 }, { 5, 2, 3 } };
		Matrix a = new Matrix(a1);

		int[][] a2 = { { 12, 2, 5 }, { 9, 10, 1 }, { 8, 5, -9 } };
		Matrix b = new Matrix(a2);

		Matrix c = a.add(b);
		assertEquals(26, c.get(0, 0));
		assertEquals(11, c.get(0, 1));
		assertEquals(8, c.get(0, 2));
		assertEquals(11, c.get(1, 0));
		assertEquals(21, c.get(1, 1));
		assertEquals(16, c.get(1, 2));
		assertEquals(13, c.get(2, 0));
		assertEquals(7, c.get(2, 1));
		assertEquals(-6, c.get(2, 2));
	}

	@Test
	public void FailedTestScalarMultiply() {
		int[][] a1 = { { 1, 2, 3 }, { 4, 5, 6 } }; // two rows, three columns
		Matrix a = new Matrix(a1);

		// multiply by 2
		a.scalarMultiply(2);

		// check elements
		assertEquals(2, a.get(0, 0));
		assertEquals(4, a.get(0, 1));
		assertEquals(6, a.get(0, 2));
		assertEquals(8, a.get(1, 0));
		assertEquals(10, a.get(1, 1));
		assertEquals(12, a.get(1, 2));

	}

	@Test
	public void FailedTestSumOfAllElements() {

		int[][] a1 = { { 1, 2, 3 }, { 4, 5, 6 } }; // two rows, three columns
		Matrix a = new Matrix(a1); // add a1 to a

		// check sum of all elements
		assertEquals(21, a.sumOfAllElements());

	}

	@Test
	public void FailedTestTranspose() {
		int[][] a1 = { { 1, 2, 3 }, { 4, 5, 6 } }; // two rows, three columns
		Matrix a = new Matrix(a1);

		// transpose the 2D array
		a.transpose();

		// check new 2D array via transpose()
		assertEquals(1, a.get(0, 0));
		assertEquals(4, a.get(0, 1));
		assertEquals(2, a.get(1, 0));
		assertEquals(5, a.get(1, 1));
		assertEquals(3, a.get(2, 0));
		assertEquals(6, a.get(2, 1));

	}

}