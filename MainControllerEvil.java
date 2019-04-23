package hangman;

import java.util.*;

public class MainControllerEvil extends Game {

	/**
	 * This method helps add the letter Guessed to correspond arrayList
	 */
	public void addElementToArray(String letter, String positions) {
		allGuess.add(letter);
		// if the position is "other" then the guess is wrong
		if (positions.equals("other")) {
			wrongGuess.add(letter.toUpperCase());
		}
	}

	/**
	 * This method helps replaced "_" with the letter guessed successfully in the
	 * print array
	 */
	public void replaceInitialArray(String position, String letter, 
			String[] gameArray) {
		// print array will not change if the position string is "other"
		if (!(position.equals("other"))) {
			// get each position as the integer
			String[] positionArray = position.split("");
			for (int n = 0; n < positionArray.length; n++) {
				// replace the position with the letter guessed correct
				gameArray[Integer.parseInt(positionArray[n])] = letter.
						toUpperCase();
			}
		}
	}

	// did not test this method since it takes user's input to play the game
	/**
	 * This method helps play the evil Hangman
	 */
	public void play(String[] notPlayed, String wordsSelected, 
			ArrayList<String> wordofSpecificLength) {
		Scanner scan = new Scanner(System.in);
		// build a instance for MainControllerNormal since I need to use the 
		// method in MainControllerNormal class
		MainControllerNormal normal = new MainControllerNormal();
		int lengthOfArrayList = 100;
		// the loop will not end until maximum size of the arrayList in the
		// position HashMap equals to 1
		while (lengthOfArrayList != 1) {
			String letter = this.getValidInput(scan);
			FilterUnnecessaryWord filteredWords = new 
					FilterUnnecessaryWord(wordofSpecificLength);
			wordofSpecificLength = filteredWords.evilHangmanOperator
					(letter, wordofSpecificLength);
			lengthOfArrayList = wordofSpecificLength.size();
			String positionOfGuess = filteredWords.getPosition();
			// add letter guessed to the allGuess (wrongGuess if needed)
			this.addElementToArray(letter, positionOfGuess);
			this.countTheTries();
			this.replaceInitialArray(positionOfGuess, letter, notPlayed);
			this.print(notPlayed);
			System.out.println("Incorrect Guess");
			System.out.println(this.getWrongGuess());
			// if the user already guessed ten times, quit the loop
			if (this.getCounter() > 10) {
				lengthOfArrayList = 1;
				wordsSelected = wordofSpecificLength.toArray
						(new String[wordofSpecificLength.size()])[0];
				System.out.println("The correct answer is " + wordsSelected);
			}
		}
		// get the finalWord String if the word in Evil Hangman is decided
		// if not decided, the value of finalWord will not affect next steps
		String[] finalWordArray = wordofSpecificLength.
				toArray(new String[wordofSpecificLength.size()]);
		String finalWord = finalWordArray[0];
		// because I need to use the method in MainControllerNormal class
		// so I need to set the variables of normal extends the variables'
		// values of "this"
		normal.setCounter(this.getCounter());
		normal.setAllGuess(this.getAllGuess());
		normal.setWrongGuess(this.getWrongGuess());
		// once the word is decided, the next steps are exactly same as normal 
		// one
		normal.play(notPlayed, finalWord, wordofSpecificLength);
		// set the value of counter for "this" equals to the value of counter 
		// for normal
		this.setCounter(normal.getCounter());
		scan.close();
	}
}
