
/*
 * CSc 127B Spring 2016, Project 05
 *
 * Project Name: ArrayPriorityList
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The class is test class to test all of methods from ArrayPriorityList
 * 
 */
// Unit test for ArrayPriorityList<E> implements PriorityList<E>
//
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayPriorityListTest {

	// Test insert elements
	@Test
	public void testInsertToLeft() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
	}

	// Write short test methods to ensure methods throw exceptions
	// when they are supposed to throw new IllegalArgumentException();
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(0);
	}

	// Get element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtMinusOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(-1);
	}

	// Insert element at 21
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionInsertElementAtTwentyOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(21, "Hello World");
	}

	// Insert element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionInsertElementAtMinusOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(-1, "Hello World");
	}

	// Raise priority of element at 1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRaisePriorityOfAtOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.raisePriorityOf(1);
	}

	// Raise priority of element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRaisePriorityOfAtMinusOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.raisePriorityOf(-1);
	}

	// Lower priority of element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLowerPriorityOfAtMinusOneWhenListIsEmpty() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.lowerPriorityOf(-1);
	}

	// Lower Priority Of element at 5
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLowerPriorityOfAtFive() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.insertElementAt(0, "World");

		list.lowerPriorityOf(5);
	}

	// Lower Priority Of element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLowerPriorityOfAtMinusOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.insertElementAt(0, "World");

		list.lowerPriorityOf(-1);
	}

	// Remove element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRemoveElementAtMinusOneWhenListIsEmpty() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.removeElementAt(-1);
	}

	// Remove element at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRemoveElementAtMinusOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.removeElementAt(-1);
	}

	// Remove element at 4
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRemoveElementAtFour() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.removeElementAt(4);
	}

	// Move element to Last at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionMoveToLastAtMinusTwo() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.moveToLast(-1);
	}

	// Move element to last at 3
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionMoveToLastAtThree() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.moveToLast(3);
	}

	// Move element to top at -1
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionMoveToTopAtMinusOne() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.moveToTop(-1);
	}

	// Move element to top at 3
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionMoveToTopAtThree() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");
		list.moveToTop(3);
	}

	// Test size when list is empty
	@Test
	public void testSizeAndIsEmpty() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	// test get and remove element
	@Test
	public void testGetAndRemoveElementAndIsNotEmpty() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");

		assertEquals("Hello", list.getElementAt(0));
		assertEquals("New First", list.getElementAt(1));
		assertEquals("First", list.getElementAt(2));
		assertFalse(list.isEmpty());

		list.removeElementAt(1);
		assertEquals("Hello", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));

		list.removeElementAt(1);
		assertEquals("Hello", list.getElementAt(0));

		list.removeElementAt(0);
		assertTrue(list.isEmpty());
	}

	// test lower and raise, move to last and top
	@Test
	public void testLowerAndRaiseAlsoMoveToLastAndTop() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");

		// Move first one to next
		list.lowerPriorityOf(0);
		assertEquals("New First", list.getElementAt(0));
		assertEquals("Hello", list.getElementAt(1));
		assertEquals("First", list.getElementAt(2));

		// Move second one to previous
		list.raisePriorityOf(1);
		assertEquals("Hello", list.getElementAt(0));
		assertEquals("New First", list.getElementAt(1));
		assertEquals("First", list.getElementAt(2));

		// Move first one to last
		list.moveToLast(0);
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals("Hello", list.getElementAt(2));

		// Move last one to top
		list.moveToTop(2);
		assertEquals("Hello", list.getElementAt(0));
		assertEquals("New First", list.getElementAt(1));
		assertEquals("First", list.getElementAt(2));

		// Move second one to next
		list.lowerPriorityOf(1);
		assertEquals("Hello", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals("New First", list.getElementAt(2));

		// Move first one to next
		list.lowerPriorityOf(0);
		assertEquals("First", list.getElementAt(0));
		assertEquals("Hello", list.getElementAt(1));
		assertEquals("New First", list.getElementAt(2));

	}

	// Test array out put
	@SuppressWarnings("deprecation")
	@Test
	public void testToArray() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		list.insertElementAt(0, "Hello");

		Object[] newData = list.toArray();

		assertEquals("Hello", newData[0]);
		assertEquals("New First", newData[1]);
		assertEquals("First", newData[2]);

	}

	// test toArray
	@Test
	public void toArrayTest() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);
		list.insertElementAt(3, 4);
		list.insertElementAt(4, 5);
		list.insertElementAt(5, 6);
		Object[] result = list.toArray();
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		assertEquals(5, result[4]);
		assertEquals(6, result[5]);
		result[5] = 10;
		assertEquals(10, result[5]);
		Integer temp = list.getElementAt(5);
		assertEquals(6, temp.intValue());
	}

	// test grow array
	@Test
	public void growArrayTest() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "1");
		list.insertElementAt(1, "2");
		list.insertElementAt(2, "3");
		list.insertElementAt(3, "4");
		list.insertElementAt(4, "5");
		list.insertElementAt(5, "6");
		list.insertElementAt(6, "7");
		list.insertElementAt(7, "8");
		list.insertElementAt(8, "9");
		list.insertElementAt(9, "10");
		list.insertElementAt(10, "11");
		list.insertElementAt(11, "12");
		list.insertElementAt(12, "13");
		list.insertElementAt(13, "14");
		list.insertElementAt(14, "15");
		list.insertElementAt(15, "16");
		list.insertElementAt(16, "17");
		list.insertElementAt(17, "18");
		list.insertElementAt(18, "19");
		list.insertElementAt(19, "20");
		list.insertElementAt(20, "21");
		list.insertElementAt(20, "22");
		assertEquals(22, list.size());
	}

} // End unit test for ArrayPriorityList
