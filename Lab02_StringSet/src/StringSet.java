public class StringSet {

	private String[] elements;
	private int n = 0;

	public StringSet() {
		elements = new String[20];
	}

	public String toString() {
		String result = "[";
		for (int index = 0; index < n - 1; index++) {
			result += elements[index] + ", ";
		}
		if (n > 0)
			result += elements[n - 1];
		return result + "]";
	}

	public boolean insertInOrder(String element) {
		if (this.contains(element)) {
			return false;
		}
		int spotToInsert = findInsertionIndex(element);
		// elements -> "C" | "Gee" | null | null ...
		shiftRightFrom(spotToInsert);
		// elements -> "C" | "C" | "Gee" | null | null ...
		elements[spotToInsert] = element;
		n++;
		return true;
	}

	// Return true if there are no elements in this Bag.
	public boolean isEmpty() {
		int count = 0;
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] != null) {
				count++;
			}
		}
		if (count == 0) {
			return true;
		}
		return false;
	}

	// Return the number of elements in this StringSet.
	public int size() {
		return n;
	}

	// Return true if element is found in this StringSet, false if element does
	// not exist
	public boolean contains(String element) {
		int count = 0;
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] != null && this.elements[i].equals(element)) {
				count++;
			}
		}
		if (count == 0) {
			return false;
		}
		return true;
	}

	// Remove the element if found and return true.
	// Return false if this set does not contains element
	public boolean remove(String element) {
		int count = 0;
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] != null && this.elements[i].equals(element)) {
				count++;
			}
		}
		if (count == 0) {
			return false;
		}

		int index = -1;
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] != null && this.elements[i].equals(element)) {
				index = i;
			}
		}
		shiftLeftFrom(index);
		return true;
	}

	// Return a StringSet that is the union of this StringSet
	// and the other StringSet.
	public StringSet union(StringSet other) {
		StringSet set = new StringSet();
		for (int i = 0; i < other.size(); i++) {
			set.insertInOrder(other.elements[i]);
		}

		for (int i = 0; i < this.size(); i++) {
			set.insertInOrder(this.elements[i]);
		}

		return set;
	}

	private int findInsertionIndex(String element) {
		int index = 0;
		while (index < n && element.compareTo(elements[index]) > 0) {
			index++;
		}
		return index;
	}

	private void shiftRightFrom(int spotToInsert) {
		for (int index = n; index > spotToInsert; index--) {
			elements[index] = elements[index - 1];
		}
	}

	private void shiftLeftFrom(int spotToInsert) {
		for (int index = spotToInsert + 1; index < n; index++) {
			elements[index - 1] = elements[index];
			// System.out.println(elements[index]);
		}
		this.elements[n - 1] = null;
		n--;
	}

}