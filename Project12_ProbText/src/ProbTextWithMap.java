
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
 * That uses Rick's algorithm to create all mappings where all possible nGrams are the keys. 
 * Each key (the nGram) has the list of all characters in the input file that follow that nGram. 
 * Each char printed is O(1). Building the map is O(n), but it happens only once.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProbTextWithMap {

	public static void main(String[] args) {
		ProbTextWithMap rw = new ProbTextWithMap("Alice", 5);
		System.out.println("Print 500 random letters using an OrderedMap");
		System.out.println("==========================================");
		rw.printRandom(500);
	}

	private OrderedMap<String, ArrayList<Character>> all;
	private int seedLength;
	private String fileName;
	private static Random generator;
	private String nGram;
	private StringBuilder text;

	public ProbTextWithMap(String fileName, int seedLength) {
		this.fileName = fileName;
		this.seedLength = seedLength;
		generator = new Random();
		// read book
		StringBuilder text = new StringBuilder();
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				text.append(input.next() + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR! The File Doesn't Exist!");
			return;
		}

		// read book after put to text
		this.text = text;

		ArrayList<Character> followers = new ArrayList<Character>();
		all = new OrderedMap<String, ArrayList<Character>>();

		// set up OrderedMap
		for (int i = 0; i < text.length() - seedLength; i++) {
			// get every nGram from whole text
			nGram = text.substring(i, i + seedLength);
			// if OrderedMap has the nGram then skip it
			if (!all.containsKey(nGram)) {
				followers = generateArrayList(nGram);
				all.put(nGram, followers);
			}

		}

	}

	// Print n characters using a probabilistic text generation scheme
	public void printRandom(int n) {

		generator = new Random();
		int randNumber = generator.nextInt(text.length() - seedLength - 1);

		// find a first random nGram
		nGram = text.substring(randNumber, randNumber + seedLength);
		ArrayList<Character> followers = new ArrayList<Character>();

		// I think it does not print first random nGram, so newText is empty.
		// Also, lineCounter is 0.
		String newText = "";
		char ch;
		boolean newLine = false;
		int lineCounter = 0;

		// do loop, it runs n times
		for (int i = 0; i < n; i++) {
			followers = all.get(nGram);
			ch = followers.get(generator.nextInt(followers.size()));
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

	private ArrayList<Character> generateArrayList(String nGram) {
		// create a empty ArrayList
		ArrayList<Character> followers = new ArrayList<Character>();

		// get first index
		int index = text.indexOf(nGram);

		// find all of nGram in the text
		while (index != -1) {
			if (index + seedLength < text.length()) {
				followers.add(text.charAt(index + seedLength));
			}
			index = text.indexOf(nGram, index + 1);
		}

		// return ArrayList
		return followers;
	}

}