public class LinkedSet<E> {

	private class Node {
		private E e; // Reference to the element
		private Node next; // null, or reference to next node

		public Node(E element) {
			e = element;
			next = null;
		}
	}

	private Node first;
	private int n;

	public LinkedSet() {
		this.first = null;
		this.n = 0;
	}

	public void addLast(E element) {
		if(this.contains(element)){
			return;
		}
		Node ref = first;
		if (first == null) {
			first = new Node(element);

		} else {
			while (ref.next != null) {
				ref = ref.next;
			}
			ref.next = new Node(element);
		}
		n++;
	}

	public int size() {
		return this.n;
	}

	public boolean contains(E element) {

		Node ref = first;

		while (ref != null) {
			if (ref.e.equals(element)) {
				return true;
			}
			ref = ref.next;
		}

		return false;
	}

	@Override
	public String toString() {
		String result = "";
		Node ref = first;
		while (ref != null) {
			result += ref.e.toString() + " ";
			ref = ref.next;
		}
		return result.trim();
	}

}
