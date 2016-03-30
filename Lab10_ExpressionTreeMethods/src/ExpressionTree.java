/**
 * ExpressionTree objects are built by performing a pre-order traversal over prefix 
 * expressions passed as a String object.   You job is to add several methods that you test well.  
 * 
 *  1) This class has the private TreeNode build() method for building a tree
 *  2) int valueOf() with only two operator + and * 
 *  
 *  Add these new methods during lab
 *
 * Implement, code and test (write your own @Test methods), the methods specified on ExpressionTree 
 *
 * 1) to int valueOf()add the other 3 arithmetic operators: - / %   
 * 2) complete String preOrder() to return a String that is the tree in a pre order traversal
 * 3) complete String postOrder() to return a String that is the tree in a post order traversal
 * 4) complete int nodeCount() to return how many nodes are in the tree
 * 5) complete int leafCount() to return how many leafs are in the tree
 * 6) complete boolean isFull() to return true if all nodes have 0 or exactly 2 children. An empty tree is full
 * 7) complete int nodesAtLevel(int level) to return the number of nodes at any given level
 *
 */
import java.util.Scanner;

public class ExpressionTree {

	private class TreeNode {
		private String data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}

		public TreeNode(String dataRef, TreeNode leftTree, TreeNode rightTree) {
			data = dataRef;
			left = leftTree;
			right = rightTree;
		}
	} // end class TreeNode

	// The external reference starting point
	TreeNode root;
	private Scanner scanner;

	public ExpressionTree(String prefix) {
		// Convert the prefix expression to an expression tree
		scanner = new Scanner(prefix);
		root = build();
	}

	private TreeNode build() {
		if (!scanner.hasNext())
			return null;

		// There must be at least one more token in the scanner
		String token = scanner.next();
		if (isOperator(token)) {
			TreeNode leftSubtree = build();
			TreeNode rightSubtree = build();
			return new TreeNode(token, leftSubtree, rightSubtree);
		} else
			return new TreeNode(token);
	}

	private boolean isOperator(String token) {
		return "+-*/%^".indexOf(token) >= 0;
	}

	public int valueOf() {
		if (root == null)
			return 0;
		else
			return valueOf(root);
	}

	// helper method
	private int valueOf(TreeNode t) {
		if (t.left == null && t.right == null) // The token must be an operand
			return Integer.parseInt(t.data);
		else if (t.data.equals("+"))
			return valueOf(t.left) + valueOf(t.right);
		else if (t.data.equals("*"))
			return valueOf(t.left) * valueOf(t.right);
		else if (t.data.equals("/"))
			return valueOf(t.left) / valueOf(t.right);
		else if (t.data.equals("-"))
			return valueOf(t.left) - valueOf(t.right);
		else
			return valueOf(t.left) % valueOf(t.right);
	}

	String result;

	public String inFix() {
		result = "";
		inFix(root);
		return result.trim();
	}

	private void inFix(TreeNode t) {
		if (t != null) {
			inFix(t.left);
			result += t.data + " ";
			inFix(t.right);
		}
	}

	public String preOrder() {
		return preOrder(root);
	}

	private String preOrder(TreeNode t) {
		if (t.left == null && t.right == null) {
			return t.data;
		}
		return t.data + preOrder(t.left) + preOrder(t.right);
	}

	public String postOrder() {
		return postOrder(root);
	}

	private String postOrder(TreeNode t) {
		if (t.left == null && t.right == null) {
			return t.data;
		}
		return postOrder(t.left) + postOrder(t.right) + t.data;
	}

	public int nodeCount() {
		return nodeCount(root);
	}

	private int nodeCount(TreeNode t) {
		if (t.left == null && t.right == null) {
			return 1;
		}
		return nodeCount(t.left) + nodeCount(t.right);
	}

	public int leafCount() {
		return leafCount(root);
	}

	private int leafCount(TreeNode t) {
		if (t.left == null && t.right == null) {
			return 1;
		}

		return leafCount(t.left) + leafCount(t.right);
	}

	public boolean isFull() {

		return isFull(root);
	}

	private boolean isFull(TreeNode t) {
		if (t.left == null && t.right == null) {
			return true;
		}
		if (t.left == null && t.right != null)
			return false;
		if (t.left != null && t.right == null)
			return false;
		return isFull(t.right) == isFull(t.right);
	}

	public int nodesAtLevel(int level) {
		return nodesAtLevel(root, level, 0);
	}

	private int nodesAtLevel(TreeNode t, int level, int currLevel) {
		if (level == currLevel) {
			return 1;
		}
		if (t.left == null && t.right == null) {
			return 0;
		}
		return nodesAtLevel(t.left, level, currLevel + 1)
				+ nodesAtLevel(t.right, level, currLevel + 1);
	}
}
