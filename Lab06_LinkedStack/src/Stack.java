import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {

	private class Node {
		private E data;
		private Node next;

		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	private Node header;
	private int n;

	public Stack() {
		this.header = null;
		this.n = 0;
	}

	@Override
	public boolean isEmpty() {
		if (this.n == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void push(E element) {
		if (this.header == null) {
			header = new Node(element, null);
		} else {
			Node first = header;
			Node newNode = new Node(element, null);
			newNode.next = first;
			header = newNode;
		}
		n++;
	}

	@Override
	public E peek() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		return header.data;
	}

	
	@Override
	public E pop() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		
		Node first = header;
		header = header.next;
		n--;
		
		return first.data;
	}

}
