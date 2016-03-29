
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
 * This is test case for LinkedList class
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	// test get
	@Test
	public void testAddlastAndGet() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals(null, list.get(4));
		assertEquals(null, list.get(-1));
	}

	// test max
	@Test
	public void testAddlastAndGetMax() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		assertEquals(4, (int) list.max());

		LinkedList<Integer> listTwo = new LinkedList<Integer>();
		assertEquals(null, listTwo.max());
	}

	// test find one element in the LinkedList
	@Test
	public void testAddlastAndFindOne() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		assertEquals(1, list.occurencesOf(1));

		LinkedList<String> listTwo = new LinkedList<String>();
		assertEquals(0, listTwo.occurencesOf("A"));
		listTwo.addLast("A");
		listTwo.addLast("B");
		listTwo.addLast("X");
		listTwo.addLast("X");
		listTwo.addLast("X");
		assertEquals("A B X X X", listTwo.toString());
		assertEquals(1, listTwo.occurencesOf("A"));
		assertEquals(3, listTwo.occurencesOf("X"));

		LinkedList<Integer> listThree = new LinkedList<Integer>();
		assertEquals(0, listThree.occurencesOf(1));
	}

	// test duplicate all
	@Test
	public void testAddlastAndDuplicateAll() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		list.duplicateAll("B");
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("C", list.get(3));
		assertEquals("A B B C D E", list.toString());
		assertEquals(6, list.size());

		LinkedList<Integer> listTwo = new LinkedList<Integer>();
		assertEquals(0, listTwo.occurencesOf(1));
	}
}
