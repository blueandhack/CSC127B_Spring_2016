
/*
 * CSc 127B Spring 2016, Project 13
 *
 * Project Name: Boggle
 *
 * Author: Yujia Lin and Jiaxuan Chen 
 * ---
 * The class has more functions for the game.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boggle {

	// Boggle will use your well-tested BoggleTray.
	private BoggleTray boggleTray;

	// Other instance variables will be needed to store collections such
	// as the 80,000+ BoggleWords ...
	List<String> words;
	List<String> possibleWords;
	int score;
	int countPossibleWords;

	// Initialize a new game. Random dice not needed until part 3
	public Boggle() {
		this.words = new LinkedList<String>();
		this.possibleWords = new LinkedList<String>();
		score = 0;
		boggleTray = new BoggleTray();
		setPossibleWords();
	}

	// Allow testers to set the BoggleTray to a known one (not random).
	public void setBoggleTray(BoggleTray dt) {
		boggleTray = dt;
		setPossibleWords();
	}

	// set possible words
	private void setPossibleWords() {
		int count = 0;
		Scanner wordScanner = null;
		try {
			wordScanner = new Scanner(new FileInputStream("BoggleWords"));
		} catch (FileNotFoundException e) {
		}
		while (wordScanner.hasNext()) {
			String str = wordScanner.next();
			if (boggleTray.foundInBoggleTray(str)) {
				possibleWords.add(count, str);
				count++;
			}
		}
		countPossibleWords = count;
	}

	// Return the BoggleTray object as a textual representation as a String
	public String getBoggleTrayAsString() {
		return boggleTray.toString();
	}

	// Record one word (a string with no whitespace) as one of the users'
	// guesses.
	// Do what you want with it, but oneGuess should be processed so all methods
	// can return the correct values such as getScore() and getWordsFound().
	public void addGuess(String oneGuess) {
		if (oneGuess.length() == 0) {
			return;
		}
		if (!words.contains(oneGuess.toLowerCase())) {
			words.add(oneGuess.toLowerCase());
		}
	}

	// Return a list of all words the user entered that count for the score. The
	// found words
	// must be in their natural ordering. This method should return an empty
	// list until
	// addGuess(String) is called at least once. The returned List<E> could also
	// be empty if
	// no attempts actually counted for anything. There must be no duplicates!
	public List<String> getWordsFound() {
		LinkedList<String> result = new LinkedList<String>();
		String[] temp = new String[words.size()];
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (possibleWords.contains(words.get(i))) {
				temp[count] = words.get(i);
				count++;
			}
		}
		sort(temp, count);
		for (int i = 0; i < count; i++) {
			result.add(i, temp[i]);
		}
		return result;
	}

	// sort word list
	private void sort(String[] wordList, int size) {
		int indexOfSmallest = 0;
		for (int top = 0; top < size - 1; top++) {
			indexOfSmallest = top;
			for (int index = top + 1; index < size; index++) {
				if (wordList[index].compareTo(wordList[indexOfSmallest]) < 0)
					indexOfSmallest = index;
			}
			String temp = wordList[top];
			wordList[top] = wordList[indexOfSmallest];
			wordList[indexOfSmallest] = temp;
		}
	}

	// Return a list of all words the user entered that do not count for the
	// score
	// in their natural order. This list may be empty with no words guessed or
	// all
	// guessed words actually count for points. There must be no duplicates!
	public List<String> getWordsIncorrect() {
		LinkedList<String> incorrectWords = new LinkedList<String>();
		String[] temp = new String[words.size()];
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).length() < 3 || !possibleWords.contains(words.get(i))) {
				temp[count] = words.get(i);
				count++;
			}
		}

		sort(temp, count);
		for (int i = 0; i < count; i++) {
			incorrectWords.add(i, temp[i]);
		}
		return incorrectWords;
	}

	// All words the user could have guessed but didn't in their natural order.
	// This list could also be empty at first or if the user guessed ALL words
	// in the board and in the list of 80K words (unlikely).
	// There must be no duplicates!
	public List<String> getWordsNotGuessed() {
		LinkedList<String> result = new LinkedList<String>();
		String[] array = new String[countPossibleWords];
		int count = 0;
		for (int i = 0; i < countPossibleWords; i++) {
			String temp = possibleWords.get(i);
			if (words.contains(temp) == false) {
				array[count] = temp;
				count++;
			}
		}
		sort(array, count);
		for (int i = 0; i < count; i++) {
			result.add(i, array[i]);
		}
		return result;
	}

	// Return the correct score.
	public int getScore() {
		int score = 0;
		List<String> correctWords = this.getWordsFound();

		for (int i = 0; i < this.getWordsFound().size(); i++) {
			String temp = correctWords.get(i);
			score = score + this.calcuator(temp);
		}

		return score;
	}

	// check and calculate score
	private int calcuator(String str) {
		int length = str.length();
		int score = 0;
		switch (length) {
		case 3:
			score = 1;
			break;
		case 4:
			score = 1;
			break;
		case 5:
			score = 2;
			break;
		case 6:
			score = 3;
			break;
		case 7:
			score = 5;
			break;
		default:
			score = 11;
			break;
		}
		return score;
	}
}
