import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void testShowAFewMethods() {
		ArrayQueue queue = new ArrayQueue(5);
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		assertEquals(0, queue.size());

		queue.enqueue(1.1);
		queue.enqueue(2.2);
		assertEquals(2, queue.size());
		assertEquals(1.1, queue.peek(), 0.0001);

		queue.enqueue(2.3);
		queue.enqueue(4.4);
		queue.enqueue(5.5);

		assertTrue(queue.isFull());

		// System.out.println(queue.toString());
		// System.out.println("first:" + queue.first + " last:" + queue.last);

		assertEquals(1.1, queue.dequeue(), 0.0001);
		assertEquals(2.2, queue.dequeue(), 0.0001);
		assertFalse(queue.isEmpty());

		queue.enqueue(4.4);
		queue.enqueue(5.5);

		// System.out.println(queue.toString());
		// System.out.println("first:" + queue.first + " last:" + queue.last);

		assertTrue(queue.isFull());

	}

	@Test
	public void testFillFullArray() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(1.1);
		queue.enqueue(2.2);
		queue.dequeue();
		queue.enqueue(3.3);
		queue.enqueue(4.4);
		queue.enqueue(5.5);
	}

	// TODO: Add more @Test methods

	// More @Tests needed here.
}