
/*
 * CSc 127B Spring 2016, Project 09
 *
 * Project Name: RecursionFun21
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * This is test case for RecursionFun21
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionFunTest {

	private RecursionFun rf = new RecursionFun();

	// test for No.1
	@Test
	public void testCombinations() {
		assertEquals(4, rf.combinations(4, 1));
		assertEquals(6, rf.combinations(4, 2));
		assertEquals(20, rf.combinations(6, 3));
		assertEquals(rf.combinations(4, 1) + rf.combinations(4, 2), rf.combinations(5, 2));
		assertEquals(0, rf.combinations(-2, -1));
		assertEquals(0, rf.combinations(-2, 3));
	}

	// test for No.2
	@Test
	public void testFactorial() {
		assertEquals(1, rf.factorial(1));
		assertEquals(2, rf.factorial(2));
		assertEquals(6, rf.factorial(3));
		assertEquals(24, rf.factorial(4));
	}

	// test for No.3
	@Test
	public void testAddReciprocals() {
		assertEquals(1.5, rf.addReciprocals(2), 0.00001);
		assertEquals(1.83333, rf.addReciprocals(3), 0.00001);
		assertEquals(0, rf.addReciprocals(0), 0.00001);
	}

	// test for No.4
	@Test
	public void testGCD() {
		assertEquals(1, rf.GCD(1, 1));
		assertEquals(1, rf.GCD(1, 0));
		assertEquals(1, rf.GCD(0, 1));
		assertEquals(3, rf.GCD(24, 9));
		assertEquals(10, rf.GCD(50, 20));
		assertEquals(1, rf.GCD(7, 20));
	}

	// test for No.5
	@Test
	public void testFibonacci() {
		assertEquals(1, rf.fibonacci(1));
		assertEquals(1, rf.fibonacci(2));
		assertEquals(2, rf.fibonacci(3));
	}

	// test for No.6
	@Test
	public void testUnderScore() {
		assertEquals("hel_lo", rf.underScore("hello"));
		assertEquals("x_xy_y", rf.underScore("xxyy"));
		assertEquals("a_a_a_a", rf.underScore("aaaa"));
		assertEquals("", rf.underScore(""));
	}

	// test for No.7
	@Test
	public void testNestParen() {
		assertTrue(rf.nestParen("(())"));
		assertTrue(rf.nestParen("((()))"));
		assertFalse(rf.nestParen("(((()))"));
		assertFalse(rf.nestParen("("));
		assertTrue(rf.nestParen(""));
		assertFalse(rf.nestParen("(no)"));
		assertFalse(rf.nestParen("no"));
		assertFalse(rf.nestParen("noo)"));
	}

	// test for No.8
	@Test
	public void testNoAdjacents() {
		assertEquals("yza", rf.noAdjacents("yyzzza"));
		assertEquals("abcd", rf.noAdjacents("abbbcdd"));
		assertEquals("Helo", rf.noAdjacents("Hello"));
		assertEquals("", rf.noAdjacents(""));
	}

	// test for No.9
	@Test
	public void testConvert() {
		assertEquals("1", rf.convert(1, 2));
		assertEquals("11", rf.convert(3, 2));
		assertEquals("101", rf.convert(5, 2));
		assertEquals("15", rf.convert(13, 8));
		assertEquals("10", rf.convert(8, 8));
		assertEquals("123", rf.convert(123, 10));
	}

	// test for No.10
	@Test
	public void testIntWithCommas() {
		assertEquals("10", rf.intWithCommas(10));
		assertEquals("999", rf.intWithCommas(999));
		assertEquals("1,234", rf.intWithCommas(1234));
		assertEquals("1,007", rf.intWithCommas(1007));
		assertEquals("1,023,004,567", rf.intWithCommas(1023004567));
	}

	// test for No.11
	@Test
	public void testSumArray() {
		// Add a test method to RecursionTest.java with assertions like these:
		int[] x = { 1, 5, 7, 2, 3, 4 };
		assertEquals(0, rf.sumArray(x, 5, 0));
		assertEquals(22, rf.sumArray(x, 0, 5));
		assertEquals(13, rf.sumArray(x, 0, 2));
		assertEquals(9, rf.sumArray(x, 2, 3));
		assertEquals(0, rf.sumArray(x, 4, 3));
		assertEquals(0, rf.sumArray(x, 1, 9));
		assertEquals(0, rf.sumArray(x, -1, 3));
		assertEquals(0, rf.sumArray(x, 2, 7));
		assertEquals(0, rf.sumArray(x, -10, -19));
		assertEquals(0, rf.sumArray(x, 6, 7));
	}

	// test for No.12
	@Test
	public void testSumArrayTwo() {
		int[] a = { 2, 4, 6 };
		assertEquals(12, rf.sumArray(a));
		int[] b = { 2 };
		assertEquals(2, rf.sumArray(b));
		int[] c = {};
		assertEquals(0, rf.sumArray(c));
	}

	// test for No.13
	@Test
	public void testReverseArray() {
		int[] a = { 2, 4, 6 };
		rf.reverseArray(a);
		assertEquals(6, a[0]);
		assertEquals(4, a[1]);
		assertEquals(2, a[2]);

		int[] b = { 2, 4, 6, 8, 10, 12 };
		rf.reverseArray(b);
		assertEquals(12, b[0]);
		assertEquals(10, b[1]);
		assertEquals(8, b[2]);

		int[] c = { 2, 4 };
		rf.reverseArray(c);
		assertEquals(4, c[0]);
		assertEquals(2, c[1]);

	}

	// test for No.14
	@Test
	public void testArrayRange() {
		assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
		assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
		assertEquals(0, rf.arrayRange(new int[] { 3 }));
		assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
	}

	// test for No.15
	@Test
	public void testIsSorted() {
		int[] intsOne = { 1, 2, 5, 5, 6, 6, 7 };
		int[] intsTwo = { 1, 2, 5, 5, 7, 6, 7 };
		int[] intsThree = {};
		assertTrue(rf.isSorted(intsOne));
		assertFalse(rf.isSorted(intsTwo));
		assertTrue(rf.isSorted(intsThree));
	}

	// test for No.16
	@Test
	public void testFound() {
		String[] strs = { "Ttt", "Ccc", "Fff", "Ddd", "Hhh", "Aaa" };
		assertTrue(rf.found("Aaa", strs));
		assertTrue(rf.found("Hhh", strs));
		assertFalse(rf.found("Not Here", strs));
	}

	// test for No.17
	@Test
	public void testBinarySearch() {
		String[] strs = { "Aaa", "Ccc", "Ddd", "Fff", "Hhh", "Ttt" };
		assertEquals(0, rf.binarySearch("Aaa", strs));
		assertEquals(4, rf.binarySearch("Hhh", strs));
		assertEquals(-1, rf.binarySearch("Not here", strs));
	}
}
