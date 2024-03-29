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
 * The class can control a 1D array, we should use enqueue and dequeue to add and remove.
 * Also, We use queue knowledge to solve problems.
 */

// This collection class model a circular queue in that it uses an array as the
// data structure to hold elements. When when an element is added, modulus
// arithmetic is employed to place the new element in the "last" position.
// Another instance variable "first", keeps track of the where the first is.
//  
// When first is at index 6 and last is at index 1 in this ArrayQueue:
//
// data-> | 0.2 | 0.4 | 0.6 | -0.1 | -0.4 | 0.2 | 0.5 | 0.2 | -0.1 | -0.4 | 
//                 |                               |
//               last                            first
// 
// peek() would return 0.5 and enqueue(-0.3) would place -0.3 where the 0.6 is.
// This portion is not really in the queue | 0.6 | -0.1 | -0.4 | 0.2 |
//
public class ArrayQueue {

	// Set three instance variables
	private double array[];
	private int n;
	private int last, first;

	public ArrayQueue(int capacity) {
		this.array = new double[capacity];
		this.n = 0;
		this.first = 0;
		this.last = 0;
	}

	// The size() method returns the number of elements currently in this
	public int size() {
		return this.n;
	}

	// Returns true if this ArrayQueue is empty
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	// Returns true if this ArrayQueue is full
	public boolean isFull() {
		if (this.size() == this.array.length) {
			return true;
		}
		return false;
	}

	// This method puts element into the ArrayQueue. Since the ArrayQueue is a
	// queue, the element being inserted should be added at the end of the
	// queue.
	// Precondition: the Queue is not full.
	public void enqueue(double element) {

		this.array[this.last] = element;

		// back = (back+1) % data.length;

		if (this.last + 1 >= this.array.length) {
			this.last = 0;
		} else {
			this.last++;
		}

		this.n++;

	}

	// Removes the first element from the ArrayQueue and returns it.
	// Precondition: This ArrayQueue is not empty.
	public double dequeue() {
		int index = this.first;
		double temp = this.array[index];
		if (this.first + 1 >= this.array.length) {
			this.first = 0;
		} else {
			this.first++;
		}
		this.n--;
		return temp;
	}

	// Returns the first element from the ArrayQueue but does NOT remove it.
	// Precondition: This ArrayQueue is not empty.
	public double peek() {
		return this.array[this.first];
	}

}
