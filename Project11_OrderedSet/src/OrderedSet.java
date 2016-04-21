/*
 * CSc 127B Spring 2016, Project 11
 *
 * Project Name: OrderedSet
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * The class OrderedSet<E extends Comparable<E>> as a generic collection 
 * that stores nodes in a binary search tree data structure.
 */
public class OrderedSet<E extends Comparable<E>> {

	// Private class TreeNodes
	private class TreeNode {
		private E data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	// Instance variables
	private TreeNode root;
	private TreeNode pre;
	private TreeNode curr;

	// Constructor
	public OrderedSet() {
		root = null;
	}

	// 1) Add element to this OrderedSet and return true keeping this a
	// OrderedSet. If element is found to already exist, do not change this
	// OrderedSet, return false.
	public boolean insert(E element) {
		if (root == null) {
			root = new TreeNode(element);
			return true;
		}
		pre = null;
		curr = root;

		while (curr != null) {
			if (curr.data.compareTo(element) > 0) {
				pre = curr;
				curr = curr.left;
			} else if (curr.data.compareTo(element) < 0) {
				pre = curr;
				curr = curr.right;
			} else {
				return false;
			}
		}

		if (pre.data.compareTo(element) > 0) {
			pre.left = new TreeNode(element);

		}
		if (pre.data.compareTo(element) < 0) {
			pre.right = new TreeNode(element);
		}

		return true;
	}

	// 2) The number of elements in this OrderedSet, which should be 0 when
	// first constructed. This may run O(n) or O(1)--your choice.
	public int size() {
		return size(root);
	}

	// Private helper method for size
	private int size(TreeNode t) {
		if (t == null) {
			return 0;
		} else {
			return 1 + size(t.left) + size(t.right);
		}
	}

	// 3) Return one string that concatenates all elements in this OrderedSet as
	// they are visited in order. Elements are separated by spaces as in "1 4 9"
	// from this OrderedSet:
	// --------4
	// ------/---\
	// -----1-----9
	public String toStringInorder() {
		return toStringInorder(root).trim();
	}

	// Private helper method for toStringInorder
	private String toStringInorder(TreeNode t) {
		if (t == null) {
			return "";
		} else {
			return toStringInorder(t.left) + t.data + " " + toStringInorder(t.right);
		}
	}

	// 4) Return true is search equals an element in this OrderedSet.
	public boolean contains(E search) {
		curr = root;
		while (curr != null) {
			if (curr.data.equals(search)) {
				return true;
			} else if (curr.data.compareTo(search) > 0) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return false;
	}

	// 5) Return the element in this OrderedSet that is greater than all other
	// elements. If this OrderedSet is empty, return null.
	public E max() {
		if (root == null) {
			return null;
		} else {
			TreeNode t = root;
			while (t.right != null) {
				t = t.right;
			}
			return t.data;
		}
	}

	// 6) Return how many nodes are at the given level. If level > the height of
	// the tree, return 0. Remember that an empty tree has a height of -1 (see
	// page 252).
	// ------4-------- There is 1 node on level 0
	// ----/---\------
	// ---3-----9----- There are 2 nodes on level 1
	// --/-----/-\----
	// -1-----5---11-- There are 3 nodes in level 2 (and 0 nodes on levels >= 3)
	public int nodesAtLevel(int level) {
		return nodesAtLevel(level, root, 0);
	}

	// Private helper method for nodesAtLevel
	private int nodesAtLevel(int level, TreeNode t, int count) {
		if (root == null) {
			return 0;
		} else if (t == null) {
			return 0;
		} else if (level < count) {
			return 0;
		} else {
			if (count == level) {
				return nodesAtLevel(level, t.left, count + 1) + 1 + nodesAtLevel(level, t.right, count + 1);
			} else {
				return nodesAtLevel(level, t.left, count + 1) + nodesAtLevel(level, t.right, count + 1);
			}
		}
	}

	// 7) Return the intersection of this OrderedSet and the other OrderedSet as
	// a new OrderedSet. Do not modify this OrderedSet or the other OrderedSet.
	// The intersection of two sets is the set of elements that are in both
	// sets. The intersection of {2, 4, 5, 6} and {2, 5, 6, 9} is {2, 5, 6}
	public OrderedSet<E> intersection(OrderedSet<E> other) {
		OrderedSet<E> result = new OrderedSet<E>();
		intersection(other, result, root);
		return result;
	}

	// Private helper method for intersection
	private void intersection(OrderedSet<E> other, OrderedSet<E> result, TreeNode t) {
		if (t == null) {
			return;
		}
		intersection(other, result, t.left);
		if (other.contains(t.data)) {
			result.insert(t.data);
		}
		intersection(other, result, t.right);
	}

	// 8) Return the union of this OrderedSet and the other OrderedSet as a new
	// OrderedSet. Do not modify this OrderedSet or the other OrderedSet. The
	// union of two sets is the set all distinct elements in the collection.
	// The union of {2, 4, 6} and {2, 5, 9} is {2, 4, 5, 6, 9}
	public OrderedSet<E> union(OrderedSet<E> other) {
		OrderedSet<E> result = new OrderedSet<E>();
		union(result, root);
		union(result, other.root);
		return result;
	}

	// Private helper method for union
	private void union(OrderedSet<E> result, TreeNode t) {
		if (t == null) {
			return;
		}
		union(result, t.left);
		result.insert(t.data);
		union(result, t.right);
	}

	// 9) Return an OrderedSet that contains all elements that are greater than
	// or equal to the first parameter (inclusive) and strictly less than the
	// second parameter (exclusive).
	public OrderedSet<E> subset(E inclusive, E exclusive) {
		OrderedSet<E> result = new OrderedSet<E>();
		subet(inclusive, exclusive, root, result);
		return result;
	}

	// Private helper method for subset
	private void subet(E inclusive, E exclusive, TreeNode t, OrderedSet<E> result) {
		if (t == null) {
			return;
		}
		if (t.data.compareTo(inclusive) >= 0 && t.data.compareTo(exclusive) < 0) {
			result.insert(t.data);
		}
		subet(inclusive, exclusive, t.left, result);
		subet(inclusive, exclusive, t.right, result);
	}

	// 10) Return true if two different OrderedSet objects have the same exact
	// structure. Each node must have the same number of nodes on every level,
	// the same height, // the same size, the same number of leaves, and the
	// same number of internal nodes. Each corresponding node must also have the
	// same number of children (0, 1, or 2) in the same place. The data need NOT
	// be the same. Do not compare corresponding elements.
	public boolean sameStructure(OrderedSet<E> other) {
		if (this.size() != other.size()) {
			return false;
		}
		return sameStructure(this.root, other.root);
	}

	// Private helper method for sameStructure
	private boolean sameStructure(TreeNode thisT, TreeNode otherT) {
		if (thisT == null && otherT == null) {
			return true;
		} else if (thisT != null && otherT == null) {
			return false;
		} else if (thisT == null && otherT != null) {
			return false;
		} else {
			return sameStructure(thisT.left, otherT.left) && sameStructure(thisT.right, otherT.right);
		}
	}

	// 11) If element equals an element in this OrderedSet, remove it and return
	// true. Return false whenever element is not found. In all cases, this
	// OrderedSet must remain a true OrderedSet. Here is one recommended
	// algorithm http://www.cs.arizona.edu/~mercer/Projects/BSTRemoveGeneric.pdf
	public boolean remove(E element) {
		if (root != null && root.data.equals(element) && root.left == null) {
			root = root.right;
			return true;
		}
		curr = root;
		pre = null;
		while (curr != null && !curr.data.equals(element)) {
			pre = curr;
			if (curr.data.compareTo(element) > 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
		if (curr != null && curr.left == null) {
			if (curr == pre.left)
				pre.left = curr.right;
			else
				pre.right = curr.right;
			return true;
		}
		if (curr != null && curr.left != null) {
			TreeNode prevMax = curr.left;
			TreeNode max = curr.left;
			while (max.right != null) {
				prevMax = max;
				max = max.right;
			}
			curr.data = max.data;
			if (curr.left == max) {
				curr.left = max.left;
			} else
				prevMax.right = max.left;
			return true;
		}
		return false;
	}

}
