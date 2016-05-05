
/*
 * CSc 127B Spring 2016, Project 13
 *
 * Project Name: Boggle
 *
 * Author: Yujia Lin and Jiaxuan Chen 
 * ---
 * The GUI for game.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * An event driven graphical user interface for the Boggle game using the design
 * of BoggleTray and Boggle classes during Rick Mercer's CSc classes at the UofA
 */
@SuppressWarnings("serial")
public class BoggleGUI extends JFrame {
	public static void main(String[] args) {
		// This main method allows us to can run this class as a Java
		// Application
		BoggleGUI theView = new BoggleGUI();
		theView.setVisible(true);
	}

	// Need the well test model in several methods of this GUI
	private Boggle game;

	private JTextArea diceTrayArea;
	private JButton newGameButton = new JButton("New Game");
	private JButton endButton = new JButton("End game");
	private JTextArea userInputArea = new JTextArea();
	private JLabel label;

	public BoggleGUI() {
		// create new game
		setNewBoggle();
		// set window
		setWindow();
		// set buttons listeners
		setupListeners();
		// start new game
		startNewGame();

	}

	// start new game
	private void startNewGame() {
		userInputArea.setText("");
		game = null;
		game = new Boggle();

		diceTrayArea.setText(game.getBoggleTrayAsString());
		userInputArea.setEditable(true);
	}

	// set up listeners
	private void setupListeners() {
		ActionListener newListener = new newGameListener();
		newGameButton.addActionListener(newListener);

		ActionListener endListener = new endGameListener();
		endButton.addActionListener(endListener);
	}

	// set new boggle
	private void setNewBoggle() {
		game = new Boggle();
	}

	// set window
	private void setWindow() {
		// Set up the JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 270);
		this.setResizable(false);
		setLocation(10, 10);
		setTitle("Boggle");
		// With null layout, you must set the size and location of every
		// component.
		setLayout(null);
		// Layout the GUI like the picture below
		// Every GUI component must receive a setSize and setLocation
		// message and then be added to the this JFrame

		diceTrayArea = new JTextArea(game.getBoggleTrayAsString());
		diceTrayArea.setEditable(false);
		diceTrayArea.setBackground(Color.cyan);
		diceTrayArea.setFont(new Font("Courier", Font.BOLD, 19));
		diceTrayArea.setSize(190, 190);
		diceTrayArea.setLocation(20, 20);
		add(diceTrayArea);
		Border border = BorderFactory.createLineBorder(Color.cyan);
		diceTrayArea
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 15, 15, 15)));

		label = new JLabel("Enter your words below");
		label.setLocation(280, 5);
		label.setSize(180, 30);
		label.setVisible(true);
		add(label);

		userInputArea.setLocation(245, 40);
		userInputArea.setSize(240, 170);
		userInputArea.setVisible(true);
		userInputArea.setLineWrap(true);
		userInputArea.setWrapStyleWord(true);
		userInputArea.setBackground(Color.white);
		add(userInputArea);

		newGameButton.setLocation(245, 220);
		newGameButton.setSize(110, 30);
		add(newGameButton);

		endButton.setLocation(375, 220);
		endButton.setSize(110, 30);
		add(endButton);
	}

	// new game button listener
	private class newGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			startNewGame();
		}
	}

	// end game button listener
	private class endGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Scanner scanner = new Scanner(userInputArea.getText());
			while (scanner.hasNext()) {
				String temp = scanner.next();
				game.addGuess(temp);
			}
			scanner.close();
			JOptionPane pane = new JOptionPane();

			// show message
			pane.setMessage("Your score: " + game.getScore() + '\n' + '\n' + "Words you found: \n" + '\n'
					+ getFoundWords() + '\n' + '\n' + "Incorrect words:\n" + '\n' + getIncorrectWords() + '\n' + '\n'
					+ "You could have found " + game.getWordsNotGuessed().size() + " more words." + '\n'
					+ "The computer found all of your words plus these you could have:" + '\n' + '\n'
					+ getNotGuessedWords());
			JDialog dialog = pane.createDialog(null, "Message");
			dialog.setSize(600, 400);
			dialog.setResizable(true);
			dialog.setVisible(true);
			userInputArea.setEditable(false);
		}
	}

	// get found words
	public String getFoundWords() {
		String result = "";
		List<String> words = game.getWordsFound();
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
		List<String> words = game.getWordsIncorrect();
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
		List<String> words = game.getWordsNotGuessed();
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

	// get not guessed words number
	public int getNotGuessedWordsNumber() {
		return game.getWordsNotGuessed().size();
	}

}