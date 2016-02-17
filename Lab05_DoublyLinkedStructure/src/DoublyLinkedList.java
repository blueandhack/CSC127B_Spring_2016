public class DoublyLinkedList<E extends Comparable<E>> {
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

	public DoublyLinkedList() {
		this.n = 0;
		this.header = new Node(null, null, null);
		this.trailer = new Node(null, null, null);

		this.header.next = this.trailer;
		this.trailer.prev = this.header;
	}

	public int size() {
		return this.n;
	}

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

	@Override
	public String toString() {
		String a = "";
		Node ref = header;
		while (ref.next != this.trailer) {
			a += ref.next.data + " ";
			ref = ref.next;
		}
		return a.trim();
	}

}
