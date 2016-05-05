
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
 * That uses Joe Zachary's algorithm: create a list of followers for each character printed. 
 * Each char printed is O(n) where n is the number of characters in the input file.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProbTextWithList {

	public static void main(String[] args) {
		ProbTextWithList rw = new ProbTextWithList("Alice", 5);
		System.out.println("Print 500 probable letters using an ArrayList");
		System.out.println("============================================");
		rw.printRandom(500);
	}

	private String fileName; // name of file
	private Random generator;
	private int nGramLength;
	private String nGram;
	private StringBuilder text;

	public ProbTextWithList(String fileName, int nGramLength) {
		this.fileName = fileName;
		this.nGramLength = nGramLength;
		generator = new Random();

		// read book
		StringBuilder text = new StringBuilder();
		Scanner input;
		try {
			// scanner the book
			input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				text.append(input.next() + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR! The File Doesn't Exist!");
			return;
		}

		// put book to text
		this.text = text;

		// find first nGram using random
		int randNumber = generator.nextInt(text.length() - nGramLength - 1);
		nGram = text.substring(randNumber, randNumber + nGramLength);

	}

	// Print n characters using a probabilistic text generation scheme
	public void printRandom(int charsToPrint) {
		// I think it does not print first random nGram, so newText is empty.
		// Also, lineCounter is 0.
		String newText = "";
		char ch;
		boolean newLine = false;
		int lineCounter = 0;

		// do loop, it runs charsToPrint times
		for (int i = 0; i < charsToPrint; i++) {
			// generate new char using generateChar() method
			ch = generateChar(nGram);
			// connect to newText
			newText += "" + ch;
			// get new random char
			nGram = nGram.substring(1) + ch;
			// judge and put newLine after newText when random char is space
			if (newLine && ch == ' ') {
				newText += "\n";
				newLine = false;
				lineCounter = 0;
			}
			// judge and set newLine becomes true
			if (lineCounter != 0 && lineCounter % 60 == 0) {
				newLine = true;
			}
			lineCounter++;
		}

		// print out all of new text
		System.out.println(newText);

	}

	private char generateChar(String nGram) {

		// create a empty ArrayList
		ArrayList<Character> followers = new ArrayList<Character>();
		generator = new Random();
		// get first index
		int index = text.indexOf(nGram);

		// find all of nGram
		while (index != -1) {
			if (index + nGramLength < text.length()) {
				followers.add(text.charAt(index + nGramLength));
			}
			index = text.indexOf(nGram, index + 1);
		}

		// return a char
		if (followers.isEmpty()) {
			return ' ';
		} else if (followers.size() == 1) {
			return followers.get(0);
		} else {
			return followers.get(generator.nextInt(followers.size() - 1));
		}
	}

}