/*
 * CSc 127B Spring 2016, Project 04
 *
 * Project Name: GuitarString
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The class is a test class. It tests ArrayQueue class, and it checks every situation.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayQueueTest {

	// Test create a ArrayQueue, and enqueue or dequeue
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

		assertEquals(1.1, queue.dequeue(), 0.0001);
		assertEquals(2.2, queue.dequeue(), 0.0001);
		assertFalse(queue.isEmpty());

		queue.enqueue(4.4);
		queue.enqueue(5.5);

		assertTrue(queue.isFull());

	}

	// Test if fill full array
	@Test
	public void testFillFullArray() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(1.1);
		queue.enqueue(2.2);
		queue.enqueue(3.3);
		queue.enqueue(4.4);
		queue.enqueue(5.5);
		assertTrue(queue.isFull());
	}

	// Test fill array
	@Test
	public void testFillArray() {
		ArrayQueue queue = new ArrayQueue(4);
		queue.enqueue(1.1);
		queue.enqueue(2.2);
		queue.enqueue(3.3);
		queue.enqueue(4.4);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(3.3);
		queue.enqueue(4.4);
		assertEquals(3, queue.size());
	}

	// Test dequeue a array
	@Test
	public void testFillArrayTwo() {
		ArrayQueue queue = new ArrayQueue(4);
		queue.enqueue(1.1);
		queue.enqueue(2.2);
		queue.enqueue(3.3);
		queue.enqueue(4.4);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}
}