
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
 * A collection class for storing a list of any type elements using a
 * doubly-linked data structure.
 */
public class DoublyLinkedList<E extends Comparable<E>> implements Iterables<E> {

	// Private class node
	private class Node {

		Node prev;
		E data;
		Node next;

		public Node(Node prevRef, E element, Node nextRef) {
			prev = prevRef;
			this.data = element;
			next = nextRef;
		}
	}

	private int n;
	private Node header, trailer;

	// Construct an empty list
	public DoublyLinkedList() {
		this.n = 0;
		this.header = new Node(null, null, null);
		this.trailer = new Node(null, null, null);

		this.header.next = this.trailer;
		this.trailer.prev = this.header;

	}

	// Return the number of elements in this list
	public int size() {
		return n;
	}

	// Insert element so this list is always in its natural ordering according
	// to Comparable.
	public void insertInorder(E element) {

		Node ref = header;
		if (ref.next == this.trailer && trailer.prev == ref) {
			Node newNode = new Node(header, element, trailer);
			header.next = newNode;
			trailer.prev = newNode;
			n++;
		} else {
			while (ref.next != this.trailer) {
				if (ref.next.data.compareTo(element) > 0) {
					break;
				}
				ref = ref.next;
			}

			Node newNode = new Node(ref, element, ref.next);
			Node temp = ref.next;
			ref.next = newNode;
			temp.prev = newNode;
			n++;
		}

	}

	// Return a reference to the element at the given index.
	// Precondition: index > 0 && index < size
	public E get(int index) {
		if (index < 0 || index > this.size() - 1) {
			throw new IllegalArgumentException();
		}
		int count = 0;
		Node ref = header;
		while (count != index) {
			ref = ref.next;
			count++;
		}
		return ref.next.data;

	}

	// Remove element if found and return true. If not found, return false.
	public boolean remove(E element) {

		if (this.size() == 0) {
			return false;
		}

		int count = 0;
		Node ref = header;
		while (ref.next != this.trailer) {
			if (ref.next.data.equals(element)) {
				count++;
			}
			ref = ref.next;
		}

		if (count == 0) {
			return false;
		}

		ref = header;

		while (ref.next != this.trailer) {
			if (ref.next.data.equals(element)) {
				Node temp = ref;
				ref.next = ref.next.next;
				ref.prev = temp;
				n--;
			} else {
				ref = ref.next;
			}
		}

		return true;
	}

	// Return a reference to an object that has access to this list's elements
	@Override
	public ForwardIterator<E> forwardIterator() {
		return new ForwardIter<E>();
	}

	private class ForwardIter<T> implements ForwardIterator<T> {

		private Node currentNode = header.next;

		@Override
		public boolean hasNext() {
			if (currentNode == trailer) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			@SuppressWarnings("unchecked")
			T temp = (T) currentNode.data;
			currentNode = currentNode.next;
			return temp;
		}

	}

	// Return a reference to an object that has access to this list's elements
	@Override
	public ReverseIterator<E> reverseIterator() {
		return new ReverseItr<E>();
	}

	private class ReverseItr<T> implements ReverseIterator<T> {

		private Node currentNode = trailer.prev;

		@Override
		public boolean hasPrev() {
			if (currentNode == header) {
				return false;
			}
			return true;
		}

		@Override
		public T prev() {
			@SuppressWarnings("unchecked")
			T temp = (T) currentNode.data;
			currentNode = currentNode.prev;
			return temp;
		}
	}

} // end class DoublyLinkedList