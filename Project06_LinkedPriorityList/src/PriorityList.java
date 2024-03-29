/*
 * CSc 127B Spring 2016, Project 06
 *
 * Project Name: LinkedPriorityList
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The class is interface class, it is like a template. We should contain all of method for class.
 */

/**
 * This interface describes an abstract data type to store elements where
 * indexes represent priorities and the priorities can change in several ways.
 * 
 * @author Rick Mercer
 * @param <E>
 *            The type of all elements stored in this collection
 */
public interface PriorityList<E> {

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	public int size();

	/**
	 * Return true if there are zero elements in this PriorityList *
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty();

	/**
	 * If possible, insert the element at the given index. If index is out of
	 * range, throw new IllegalArgumentException();. For example, when size is
	 * 3, the only possible values for index are 0, 1, 2, and 3.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el) throws IllegalArgumentException;

	/**
	 * If possible, return a reference to the element at the given index. If
	 * index is out of range, throw new IllegalArgumentException(); When size is
	 * 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to to element at index index.
	 * @throws IllegalArgumentException
	 */
	public E getElementAt(int index) throws IllegalArgumentException;

	/**
	 * If possible, remove the element at the given index. If index is out of
	 * range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException;

	/**
	 * If possible, swap the element located at index with the element at
	 * index+1. An attempt to lower the priority of the element at index
	 * size()-1 has no effect. If index is out of range, throw new
	 * IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException;

	/**
	 * If possible, swap the element located at index with the element at
	 * index-1. An attempt to raise the priority at index 0 has no effect. If
	 * index is out of range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException;

	/**
	 * Return a copy of all elements as an array of Objects that is the size of
	 * this PriorityList and in the same order. If there are no elements in this
	 * list, return new Object[0];. A change to the return value must not affect
	 * this ArrayPriorityList object.
	 * 
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray();

	/**
	 * If possible, move the element at the given index to the end of this list.
	 * An attempt to move the last element to the last has no effect. If the
	 * index is out of range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException;

	/**
	 * If possible, move the element at the given index to the front of this
	 * list. An attempt to move the top element to the top has no effect. If the
	 * index is out of range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException;
}