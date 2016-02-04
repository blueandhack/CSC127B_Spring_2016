public class ArraySet implements GenericSet {

	private Object array[];
	private int n;

	public ArraySet() {
		this.array = new Object[99];
		this.n = 0;
	}

	@Override
	public boolean add(Object element) {
		if (!this.contains(element)) {
			this.array[n] = element;
			n++;
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (n == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return this.n;
	}

	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.n; i++) {
			if (this.array[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

}
