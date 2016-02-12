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
 * This project implement a collection class ArrayPriorityList<E> using an array instance variable.
 * We can use the class create a object that is a list. We should fill out some dates to the list.
 */

/**
 * This class implements a generic collection to store elements where indexes
 * represent priorities and the priorities can change in several ways.
 *
 * @author Rick Mercer
 * @param <E>
 *            The type of all elements stored in this collection
 */
public class LinkedPriorityList<E> implements PriorityList<E> {

	private Object[] data; // The data structure storing elements
	private int n; // The number of meaningful elements

	// Create an empty list with zero elements
	public LinkedPriorityList() {
		data = new Object[20]; // Do NOT increase the initial capacity
		n = 0;
	}

	// Increases the capacity of the array by 20 elements.
	private void growArray() {
		Object[] temp = new Object[this.size() + 20];

		for (int i = 0; i < n; i++)
			temp[i] = this.data[i];

		this.data = temp;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 *
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		return this.n;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 *
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of
	 * the valid range of 0..size(), throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, 2, AND 3 because
	 * you can add an element as the new last.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el) throws IllegalArgumentException {
		if (index > this.size() || index < 0) {
			throw new IllegalArgumentException();
		}

		if (this.size() == data.length)
			this.growArray();

		for (int i = size(); i > index; i--) {
			this.data[i] = this.data[i - 1];
		}

		this.data[index] = el;
		this.n++;
	}

	/**
	 * If possible, return a reference to the element at the given index. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index >= this.size() || index < 0) {
			throw new IllegalArgumentException();
		}
		return (E) this.data[index];
	}

	/**
	 * If possible, remove the element at the given index. If index is out of
	 * the valid range of 0..size()-1, throw new IllegalArgumentException();
	 * When size is 3, the only possible values for index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index > this.size() - 1 || index < 0) {
			throw new IllegalArgumentException();
		}
		this.data[index] = null;
		for (int i = index; i < this.size() - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.data[this.size() - 1] = null;
		this.n--;
	}

	/**
	 * If possible, swap the element located at index with the element at index
	 * + 1. An attempt to lower the priority of the element at index size()-1
	 * has no effect. If index is out of the valid range of 0..size()-1, throw
	 * new IllegalArgumentException(); When size is 3, the only possible values
	 * for index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index > this.size() - 1 || index < 0) {
			throw new IllegalArgumentException();
		}

		if (index >= 0 && index < this.size() - 1) {
			Object temp = new Object();
			temp = this.data[index + 1];
			this.data[index + 1] = this.data[index];
			this.data[index] = temp;
		}
	}

	/**
	 * If possible, swap the element located at index with the element at
	 * index-1. An attempt to raise the priority at index 0 has no effect. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index > this.size() - 1 || index < 0) {
			throw new IllegalArgumentException();
		}

		if (index > 0 && index <= this.size() - 1) {
			Object temp = new Object();
			temp = this.data[index - 1];
			this.data[index - 1] = this.data[index];
			this.data[index] = temp;
		}
	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of
	 * this PriorityList and in the same order. If there are no elements in this
	 * list, return new Object[0]; A change to the return value must not affect
	 * this PriorityList object.
	 *
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {
		Object[] newData = new Object[this.size()];

		for (int i = 0; i < this.size(); i++) {
			Object temp = this.data[i];
			newData[i] = temp;
		}

		return newData;
	}

	/**
	 * If possible, move the element at the given index to the end of this list.
	 * An attempt to move the last element to the last has no effect. If the
	 * index is out of the valid range 0..size()-1 throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index > this.size() - 1)
			throw new IllegalArgumentException();

		if (index < this.size() - 1) {
			Object temp = this.data[index];

			for (int i = index; i < this.size() - 1; i++)
				this.data[i] = this.data[i + 1];

			this.data[this.size() - 1] = temp;
		}
	}

	/**
	 * If possible, move the element at the given index to the front of this
	 * list An attempt to move the top element to the top has no effect. If the
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index > this.size() - 1)
			throw new IllegalArgumentException();

		if (index > 0) {
			Object temp = this.data[index];

			for (int i = index; i > 0; i--)
				this.data[i] = this.data[i - 1];

			this.data[0] = temp;
		}
	}
}