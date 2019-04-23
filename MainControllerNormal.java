package hangman;

import java.util.*;

public class MainControllerNormal extends Game {

	/**
	 * This method helps add the letter Guessed to correspond arrayList
	 */
	public void addElementToArray(String letter, String words) {
		allGuess.add(letter);
		// if the word does not contain the letter guessed, add the letter
		// into WrongGuess
		if (!(words.contains(letter))) {
			wrongGuess.add(letter.toUpperCase());
		}
	}

	/**
	 * This method helps replaced "_" with the letter guessed successfully in the
	 * print array
	 */
	public void replaceInitialArray(String letter, String word, String[] initial) {
		// the print array will not changed if the word does not contain 
		// the letter guessed
		if (word.contains(letter) == true) {
			String[] arrayGameWord = word.split("");
			for (int k = 0; k < word.length(); k++) {
				if (arrayGameWord[k].equals(letter)) {
					initial[k] = letter.toUpperCase();
				}
			}
		}
	}

	// did not test this method since it takes user's input to play the game
	/**
	 * This method helps play the normal Hangman
	 */
	public void play(String[] notPlayed, 
			String wordsSelected, ArrayList<String> wordofSpecificLength) {
		Scanner scan = new Scanner(System.in);
		// if the user already guessed over 10 times, skip the loops
		// this is also helpful for the code reuse in Evil Hangman
		boolean isGameOver = this.isGameOver(wordsSelected, notPlayed);
		if (this.getCounter() > 10) {
			isGameOver = true;
		}
		// The loop will not over until all the letters are replaced correctly
		while (isGameOver == false) {
			String letter = this.getValidInput(scan);
			this.addElementToArray(letter, wordsSelected);
			this.countTheTries();
			this.replaceInitialArray(letter, wordsSelected, notPlayed);
			this.print(notPlayed);
			System.out.println("Incorrect Guess");
			System.out.println(this.getWrongGuess());
			isGameOver = this.isGameOver(wordsSelected, notPlayed);
			// if the guessed more than 10 times, quit the loop
			if (this.getCounter() > 10) {
				isGameOver = true;
				System.out.println("The correct answer is " + wordsSelected);
			}
		}
		scan.close();
	}
}
