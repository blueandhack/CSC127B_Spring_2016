import java.util.LinkedList;

public class HashTable<K, V> {

	private class HashNode {
		private K key;
		private V value;

		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return key + ":" + value;
		}
	}

	private LinkedList<LinkedList<HashNode>> table;
	private int tableSize = 10;

	// Initialize 10 lists of lists to be empty lists
	public HashTable() {
		table = new LinkedList<LinkedList<HashNode>>();
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<HashNode>());
		}
	}

	// Print the lists of lists using LinkedList's toString
	public String toString() {
		String result = "";
		int listNum = 0;
		for (LinkedList<HashNode> oneListOfLists : table) {
			result += listNum + ": " + oneListOfLists.toString() + "\n";
			listNum++;
		}
		return result;
	}

	// Return an integer on the range of 0..tableSize-1
	private int hash(K key) { // return 0..TABLE_SIZE-1
		return Math.abs(key.hashCode()) % tableSize;
	}

	// Place the new mapping into the correct list in the list of lists
	// Collisions may occur, but the same key is NOT allowed (so you can
	// hopefully get this done during section
	//
	// Precondition: key does NOT exist. Always return null!
	public V put(K key, V value) {
		V tempV = null;
		int hashKey = hash(key);
		for (int i = 0; i < table.get(hashKey).size(); i++) {
			if (table.get(hashKey).get(i).key.equals(key)) {
				tempV = table.get(hashKey).get(i).value;
				table.get(hashKey).get(i).value = value;
				return tempV;
			}
		}
		table.get(hashKey).add(new HashNode(key, value));
		return tempV;
	}

	// Return the value mapped to key or null if the key does not exist
	public V get(K key) {
		V tempV = null;
		int hashKey = hash(key);
		for (int i = 0; i < table.get(hashKey).size(); i++) {
			if (table.get(hashKey).get(i).key.equals(key)) {
				tempV = table.get(hashKey).get(i).value;
			}
		}
		return tempV;
	}
}