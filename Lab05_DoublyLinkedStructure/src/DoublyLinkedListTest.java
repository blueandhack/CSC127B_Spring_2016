import static org.junit.Assert.*;

import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void testSizeInsertinOrderAndToStringWhenAddedNotInorder() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals(0, list.size());
		list.insertInorder("C");
		list.insertInorder("B");
		list.insertInorder("A");
		assertEquals(3, list.size());
		assertEquals("A B C", list.toString());
	}

	@Test
	public void testSizeInsertinOrder() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals(0, list.size());
		list.insertInorder("C");
		list.insertInorder("B");
		list.insertInorder("A");
		list.insertInorder("A");
		list.insertInorder("A");
		list.insertInorder("A");
		list.insertInorder("B");
		list.insertInorder("C");
		assertEquals(8, list.size());
		assertEquals("A A A A B B C C", list.toString());
	}

}
