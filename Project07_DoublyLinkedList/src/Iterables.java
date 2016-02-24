/*
 * CSc 127B Spring 2016, Project 07
 *
 * Project Name: DoublyLinkedList
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The file is interface
 */

public interface Iterables<E> {
	public ForwardIterator<E> forwardIterator();

	public ReverseIterator<E> reverseIterator();
}
