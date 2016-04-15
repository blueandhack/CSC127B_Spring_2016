
/*
 * CSc 127B Spring 2016, Project 10
 *
 * Project Name: GameOf20
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * This project is one of several resulting from the Apprenticeship learning approach of Owen Astrachan (Duke), 
 * Robert Smith (North Carolina Central), James Wilkes (Appalachian State), 
 * and their students with support in part by the National Science Foundation Grant #DUE-9954910. 
 * This assignment provides practice with trees, recursion, file input, file output, 
 * and a linked hierarchical data structure-- specifically, a binary tree.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * A model for the game of 20 questions
 * 
 * @author Rick Mercer
 */
public class GameTree {

	// Node class
	private class TreeNode {
		private String data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	// private instance variables
	private Scanner inFile;
	private TreeNode root;
	private TreeNode currentNode;
	private String fileName;

	/**
	 * Constructor needed to create the game.
	 * 
	 * @param name
	 *            this is the name of the file we need to import the game
	 *            questions and answers from.
	 */
	public GameTree(String name) {
		fileName = name;
		try {
			if (fileName == null) {
				throw new FileNotFoundException();
			}
			inFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			inFile = null;
			root = null;
		}
		root = build();
		if (inFile != null) {
			inFile.close();
		}
		currentNode = root;
	}

	// build a binary tree
	private TreeNode build() {
		if (inFile == null || !inFile.hasNextLine()) {
			return null;
		}
		String token = inFile.nextLine();
		if (isQuestion(token)) {
			TreeNode t = new TreeNode(token);
			t.left = build();
			t.right = build();
			return t;
		} else {
			return new TreeNode(token);
		}
	}

	// to find question
	private boolean isQuestion(String str) {
		return str.substring(str.length() - 1).equals("?");
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQuestion
	 *            The question to add where the old answer was.
	 * @param newAnswer
	 *            The new Yes answer for the new question.
	 */
	public void add(String newQuestion, String newAnswer) {
		String tempAnswer = currentNode.data;
		currentNode.data = newQuestion;
		currentNode.left = new TreeNode(newAnswer);
		currentNode.right = new TreeNode(tempAnswer);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 * 
	 * @return False if the current node is an internal node rather than an
	 *         answer at a leaf.
	 */
	public boolean foundAnswer() {
		if (currentNode != null && !isQuestion(currentNode.data)) {
			return true;
		}
		return false;
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.
	 * 
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		if (currentNode != null) {
			return currentNode.data;
		}
		return "";
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 * 
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		if (inFile == null) {
			return;
		}
		if (yesOrNo == Choice.Yes) {
			currentNode = currentNode.left;
		} else {
			currentNode = currentNode.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the
	 * question at the root of this GameTree.
	 */
	public void reStart() {
		currentNode = root;
	}

	/**
	 * Return a textual version of this object
	 */
	@Override
	public String toString() {
		return traversal(root, "").trim();
	}

	// traversal for the binary tree
	private String traversal(TreeNode t, String str) {
		if (t == null) {
			return "";
		}
		return traversal(t.right, str + "-") + str + t.data + '\n' + traversal(t.left, str + "-");
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 * 
	 */
	public void saveGame() {
		PrintWriter pWriter = null;
		try {
			if (inFile == null) {
				throw new FileNotFoundException();
			}
			pWriter = new PrintWriter(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			return;
		}
		write(pWriter, root);
		pWriter.close();
	}

	// write file
	private void write(PrintWriter writer, TreeNode t) {
		if (t != null) {
			writer.println(t.data);
			write(writer, t.left);
			write(writer, t.right);
		}
	}
}