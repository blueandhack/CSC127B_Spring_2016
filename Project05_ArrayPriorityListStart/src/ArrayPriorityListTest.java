
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
 */
// Unit test for ArrayPriorityList<E> implements PriorityList<E>
//
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayPriorityListTest {

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

	//
	// You must add MANY, MANY more @Tests here.
	//
	// WebcCat test has 33 @Tests, 52 assertions, in 475 lines.
	//
	// In addition to the obvious, try inserting at index 0 when the list has
	// three elements, in the middle, and at size()

	// Every method that throws an exception has a test cases when index == -1,
	// index == size()-1, index == size()
	//
	// Add an @Test to requires insertElementAt to grow the array several times.
	//
	// Add @Test to ensure your cloned the array in toArray. A change to the
	// returned array must NOT change the ArrayPriorityList. The capacity of the
	// returned array must be equal to the size() of the PriorityList (not 20).
	//
} // End unit test for ArrayPriorityList
