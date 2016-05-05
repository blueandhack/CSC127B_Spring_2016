
/*
 * CSc 127B Spring 2016, Project 13
 *
 * Project Name: Boggle
 *
 * Author: Yujia Lin and Jiaxuan Chen 
 * ---
 * The console GUI for game.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BoggleGame {

	public static void main(String[] args) {

		// create new game
		BoggleGame game = new BoggleGame();
		game.setBoggleTray();
		System.out.println("Play one game of Boggle:");

		// show boggle tray
		System.out.println(game.dt);
		System.out.println("Enter words or ZZ to quit:");
		Scanner input = new Scanner(System.in);

		// read user's input
		while (input.hasNext()) {
			String word = (String) input.next();
			if (word.toLowerCase().equals("zz")) {
				break;
			}
			game.addWord(word);
		}

		input.close();

		System.out.println();
		// show score
		System.out.println("Your score: " + game.getScore());
		System.out.println();
		// show found words
		System.out.println("Words you found: ");
		System.out.println(game.getFoundWords());
		System.out.println();
		// show incorrect words
		System.out.println("Incorrect Words:");
		System.out.println(game.getIncorrectWords());
		System.out.println();
		// show all of words
		System.out.println("You could have found " + game.getNotGuessedWordsNumber() + " more words.");
		System.out.println("The computer found all of your words plus these: ");
		System.out.println();
		System.out.println(game.getNotGuessedWords());

	}

	private BoggleTray dt;
	private Boggle theGame;

	// constructor
	public BoggleGame() {
		this.dt = new BoggleTray();
		this.theGame = new Boggle();
	}

	// set boggle tray
	public void setBoggleTray() {
		this.theGame.setBoggleTray(dt);
	}

	// get score
	public int getScore() {
		return theGame.getScore();
	}

	// add word to game
	public void addWord(String str) {
		theGame.addGuess(str);
	}

	// get found words
	public String getFoundWords() {
		String result = "";
		List<String> words = theGame.getWordsFound();
		int i = 0;
		for (String string : words) {
			if (i == 9) {
				result += string + "\n";
				i = 0;
			} else {
				result += string + " ";
				i++;
			}
		}
		return result.trim();
	}

	// get incorrect words
	public String getIncorrectWords() {
		String result = "";
		List<String> words = theGame.getWordsIncorrect();
		int i = 0;
		for (String string : words) {
			if (i == 9) {
				result += string + "\n";
				i = 0;
			} else {
				result += string + " ";
				i++;
			}
		}
		return result.trim();
	}

	// get not guessed words
	public String getNotGuessedWords() {
		String result = "";
		List<String> words = theGame.getWordsNotGuessed();
		int i = 0;
		for (String string : words) {
			if (i == 9) {
				result += string + "\n";
				i = 0;
			} else {
				result += string + " ";
				i++;
			}
		}
		return result.trim();
	}

	// get guessed words number
	public int getNotGuessedWordsNumber() {
		return theGame.getWordsNotGuessed().size();
	}

}
