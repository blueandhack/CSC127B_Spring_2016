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
 * The class can create a object, and it is like a guitar string, we can play the "Guitar String".
 * Also, the class can control ArrayQueue object using below methods.
 */

public class GuitarString {

	// Set three instance variables
	private ArrayQueue buffer;
	private int tic;
	private int capacity;

	// This constructor is supplied for the purpose of testing. You know exactly
	// the elements to be added to the ArrayQueue because you have to supply a
	// completely initialized double[]. This constructor creates an ArrayQueue
	// of capacity equal to the size of the array, and initializes the contents
	// of the buffer to the values in the array.
	public GuitarString(double[] init) {
		this.capacity = init.length;
		buffer = new ArrayQueue(this.capacity);
		for (int i = 0; i < this.capacity; i++) {
			buffer.enqueue(init[i]);
		}
	}

	// The constructor creates a ArrayQueue with the capacity of the ArrayQueue
	// as the samplingRate divided by the frequency and rounded UP the nearest
	// whole number. Once the ArrayQueue is created, it should be filled with
	// 0's.
	public GuitarString(double frequency) {
		this.capacity = (int) Math.ceil(44100 / frequency);
		buffer = new ArrayQueue(this.capacity);
		for (int i = 0; i < this.capacity; i++) {
			buffer.enqueue(0.0);
		}
	}

	// Replace all the items in the ring buffer with random values between -0.5
	// and +0.5. You will first have to dequeue all elements. Math.random()
	// returns a random floating point number from 0.0 to 1.0.
	public void pluck() {
		for (int i = 0; i < this.capacity; i++) {
			double rand = Math.random() - 0.5;
			this.buffer.dequeue();
			this.buffer.enqueue(rand);
		}

	}

	// Apply the Karplus-Strong update. To do this, remove the sample at the
	// front of the ArrayQueue. Use the sample that was removed and the sample
	// that is now at the front of the ArrayQueue and find their average.
	// Multiply the average of these two numbers with the energy decay factor.
	// The energy decay factor is 0.996. Then, place the result at the end of
	// the ArrayQueue.
	public void tic() {
		double first = this.buffer.dequeue();
		double second = this.sample();
		this.buffer.enqueue(0.996 * ((first + second) / 2));
		tic++;
	}

	// Return the value of the item at the front of the ring buffer
	public double sample() {
		return this.buffer.peek();
	}

	// Return the total number of times tic() was called on this instance.
	// This is a measure of how much time has elapsed.
	public int time() {
		return this.tic;
	}

	// Return the value for the maximum capacity of the ArrayQueue
	public int getCapacity() {
		return this.capacity;
	}
}
