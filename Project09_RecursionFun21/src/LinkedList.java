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
 * This is LinkedList class
 */

public class LinkedList<E extends Comparable<E>> {

	// class Node
	private class Node {
		private E data;
		private Node next;

		public Node(E element) {
			data = element;
			next = null;
		}

	}

	// instance variables
	private Node first;
	private int n;

	// Constructor
	public LinkedList() {
		first = null;
		n = 0;
	}

	// size method
	public int size() {
		return n;
	}

	// add a node at last
	public void addLast(E el) {
		if (first == null)
			first = new Node(el);
		else
			addLast(el, first);
		n++;
	}

	// add a node at last
	private void addLast(E el, Node ref) {
		if (ref.next == null)

			ref.next = new Node(el);
		else
			addLast(el, ref.next);
	}

	/*
	 * 18.Return a reference to the element at the given index. This method may
	 * run O(n). Use recursion. Do not use a loop.
	 */
	public E get(int index) {
		return get(index, first, 0);
	}

	// private method for get, and it is a helper method
	private E get(int index, Node ref, int point) {
		if (index > size() - 1 || index < 0) {
			return null;
		}
		if (index == point) {
			return ref.data;
		}
		return get(index, ref.next, point + 1);
	}

	/*
	 * 19.Return the largest element in this list according to the type’s
	 * compareTo method. Use recursion. Do not use a loop. If the list is empty
	 * (size() == 0) return null.
	 */
	public E max() {
		if (this.size() == 0) {
			return null;
		}
		return max(first, first.data);
	}

	// private method for max, and it is a helper method
	private E max(Node ref, E maxEl) {
		if (ref.data.compareTo(maxEl) > 0) {
			maxEl = ref.data;
		}
		if (ref.next == null) {
			return maxEl;
		}
		return max(ref.next, maxEl);
	}

	/*
	 * 20.Return how often el occurs in this list. Use recursion. Do not use a
	 * loop. Return 0 if the list is empty.
	 */
	public int occurencesOf(E el) {
		return occurencesOf(first, el, 0);
	}

	// private method for occurencesOf, and it is a helper method
	private int occurencesOf(Node ref, E el, int index) {
		if (size() == 0) {
			return 0;
		}
		if (index == size()) {
			return 0;
		}
		if (ref.data.equals(el)) {
			return 1 + occurencesOf(ref.next, el, index + 1);
		}
		return occurencesOf(ref.next, el, index + 1);
	}

	/*
	 * 21.To the LinkedList class, add method duplicateAll(E element) so all
	 * elements in the singly linked structure that equals element are repeated
	 * next to the original. The size should increase for each element.
	 */
	public void duplicateAll(E el) {
		duplicateAll(first, el);
	}

	// private method for duplicateAll, and it is a helper method
	private void duplicateAll(Node ref, E el) {
		if (ref.next == null) {
			return;
		}
		if (ref.data.equals(el)) {
			Node temp = ref.next;
			ref.next = new Node(el);
			ref.next.next = temp;
			n++;
			duplicateAll(temp, el);
		} else {
			duplicateAll(ref.next, el);
		}
	}

	@Override
	public String toString() {
		return toString(first).trim();
	}

	private String toString(Node ref) {
		if (ref == null) {
			return "";
		} else
			return ref.data + " " + toString(ref.next);
	}

}