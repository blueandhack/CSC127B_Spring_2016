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

public interface ForwardIterator<E> {
	public boolean hasNext();

	public E next();
}
