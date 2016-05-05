/*
 * CSc 127B Spring 2016, Project 12
 *
 * Project Name: ProbText
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * OrderedMap<K, V> implements a Map ADT using a Binary search tree that
 * maintains all element in order based on the key.
 * 
 * @author Rick Mercer and Yujia Lin
 * 
 * @param <K>
 *            The key (must implement Comparable)
 * @param <V>
 *            he value mapped the the key K
 */
public class OrderedMap<K extends Comparable<K>, V> {

	// Store one node int the BST data structure
	private class MapNode {
		private K key;
		private V value;
		private MapNode left;
		private MapNode right;

		public MapNode(K theKey, V theValue) {
			key = theKey;
			value = theValue;
			left = null;
			right = null;
		}
	} // end class MapNode

	// The single instance variable
	private MapNode root;

	// Private instance variables
	private int size;

	/**
	 * Build an empty BST of MapNodes with size == 0
	 */
	public OrderedMap() { // Create an empty tree
		root = null;
		size = 0;
	}

	/**
	 * If the key is not in this Map, add a mapping and return null. If the key
	 * is present, return the previous value to indicate the old mapping is
	 * removed after replacing the old value with newValue.
	 * 
	 * @return null if the key exists or return the old value if the key is
	 *         present
	 */
	public V put(K key, V newValue) {
		V tempV = null;

		MapNode pre = null;
		MapNode curr = root;

		if (root == null) {
			root = new MapNode(key, newValue);
			size++;
			return tempV;
		}

		while (curr != null) {
			pre = curr;
			if (curr.key.compareTo(key) < 0) {
				curr = curr.right;
			} else if (curr.key.compareTo(key) > 0) {
				curr = curr.left;
			} else {
				tempV = curr.value;
				curr.value = newValue;
				return tempV;
			}
		}
		if (tempV == null) {
			if (pre.key.compareTo(key) < 0) {
				pre.right = new MapNode(key, newValue);
				size++;
			}
			if (pre.key.compareTo(key) > 0) {
				pre.left = new MapNode(key, newValue);
				size++;
			}
		}

		return tempV;
	}

	/**
	 * Find out how many mappings exist in this Map.
	 * 
	 * @return The number of key/value mappings.
	 */
	public int size() {
		return size;
	}

	/**
	 * Get the value mapped to the given key or null if the key does not exist
	 * 
	 * @param key
	 *            The key for the desired value
	 * @return the value mapped to the key or null if key was not found
	 */
	public V get(K key) {
		MapNode curr = root;
		if (root == null) {
			return null;
		}
		while (curr != null) {

			if (curr.key.compareTo(key) < 0) {
				curr = curr.right;
			} else if (curr.key.compareTo(key) > 0) {
				curr = curr.left;
			} else {
				return curr.value;
			}
		}
		return null;
	}

	/**
	 * Determine if searchKey is already in the Map
	 * 
	 * @return true if key exists in the OrderedMap object, or false if it
	 *         doesn't
	 */
	public boolean containsKey(K searchKey) {
		MapNode curr = root;
		if (root == null) {
			return false;
		}
		while (curr != null) {
			if (curr.key.compareTo(searchKey) < 0) {
				curr = curr.right;
			} else if (curr.key.compareTo(searchKey) > 0) {
				curr = curr.left;
			} else {
				return true;
			}
		}
		return false;
	}

}