package hangman;

import java.util.*;

public abstract class Game {
	protected ArrayList<String> wrongGuess = new ArrayList<String>();
	protected ArrayList<String> allGuess = new ArrayList<String>();
	protected int counter = 0;

	/**
	 * This is the setter of allGuess
	 * @param allGuess
	 */
	public void setAllGuess(ArrayList<String> allGuess) {
		this.allGuess = allGuess;
	}

	/**
	 * This is the setter of wrongGuess
	 * @param wrongGuess
	 */
	public void setWrongGuess(ArrayList<String> wrongGuess) {
		this.wrongGuess = wrongGuess;
	}

	/**
	 * This is the setter of counter
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * This method helps get the arrayList of allGuess
	 * @return arrayList of allGuess
	 */
	public ArrayList<String> getAllGuess() {
		return allGuess;
	}

	/**
	 * This method helps get the arrayList of wrongGuess
	 * @return arrayList of wrongGuess
	 */
	public ArrayList<String> getWrongGuess() {
		return wrongGuess;
	}

	/**
	 * This method helps get the value of counter
	 * @return the value of counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * This method helps count the tries
	 */
	public void countTheTries() {
		counter++;
	}

	// did not test this method since it is a abstract method
	/**
	 * This method helps add the letter Guessed to correspond arrayList
	 * 
	 * @param letter
	 * @param words
	 */
	public abstract void addElementToArray(String letter, String words);

	// did not test this method since it is a abstract method
	/**
	 * This method helps replaced "_" with the letter guessed successfully in the
	 * print array
	 * @param letter
	 * @param word
	 * @param initial
	 */
	public abstract void replaceInitialArray(String letter, String word, 
			String[] initial);

	// did not test this method since it is a abstract method
	/**
	 * This method helps play each game (normal/evil)
	 * @param notPlayed
	 * @param wordsSelected
	 * @param wordofSpecificLength
	 */
	public abstract void play(String[] notPlayed, String wordsSelected, 
			ArrayList<String> wordofSpecificLength);

	/**
	 * This method helps get the words array by reading the file
	 * @return the words array from the "words.txt"
	 */
	public String[] getLinesArray() {
		FileReaderTxt theFile = new FileReaderTxt("words.txt");
		ArrayList<String> lines = theFile.getAllLines();
		FilterUnnecessaryWord filteredWords = new FilterUnnecessaryWord(lines);
		filteredWords.filterAll();
		String[] arrayOfGame = filteredWords.getLines();
		return arrayOfGame;
	}

	/**
	 * This method helps check whether the input user entered is valid or not
	 * @param guess
	 * @param allGuess
	 * @return the boolean represent whether certain input is valid or not
	 */
	public boolean vaildInput(String guess, ArrayList<String> allGuess) {
		// check whether the input is not alphabetic or contains more than one
		// character
		if (!(Character.isAlphabetic(guess.charAt(0))) || guess.length() > 1) {
			System.out.println("Please enter a single letter");
			ArrayList<String> wrongGuess = this.getWrongGuess();
			System.out.println("Incorrect Guess");
			System.out.println(wrongGuess);
			return false;
			// check whether the user already guessed that letter before
		} 
		else if (allGuess.contains(guess)) {
			System.out.println("You enter that letter before,enter another one");
			ArrayList<String> wrongGuess = this.getWrongGuess();
			System.out.println("Incorrect Guess");
			System.out.println(wrongGuess);
			return false;
		} 
		else {
			return true;
		}
	}

	// did not test this method because it takes users input
	/**
	 * This method helps get the valid input from the user
	 * @param scanner
	 * @return the valid string input from user
	 */
	public String getValidInput(Scanner scanner) {
		String letter = "";
		boolean checkValid = false;
		// the loop will not end until the user enter a valid input
		while (checkValid == false) {
			System.out.println("Please give me a letter");
			String userInput = scanner.nextLine();
			letter = userInput.toLowerCase();
			ArrayList<String> allGuess = this.getAllGuess();
			checkValid = this.vaildInput(letter, allGuess);
		}
		return letter;
	}

	/**
	 * This method helps create the print array
	 * @param length
	 * @return the initial print array with "_" on all spots
	 */
	public String[] initialArray(int length) {
		String[] notPlayed = new String[length];
		for (int i = 0; i < length; i++) {
			notPlayed[i] = "_";
		}
		return notPlayed;
	}

	/**
	 * This method helps check whether the game is over or not
	 * @param words
	 * @param wordsPlay
	 * @return the boolean that represents if the game is over
	 */
	public boolean isGameOver(String words, String[] wordsPlay) {
		int lowerLineCounter = 0;
		String[] wordsList = words.split("");
		for (int i = 0; i < words.length(); i++) {
			if (wordsPlay[i].equals(wordsList[i].toUpperCase())) {
				lowerLineCounter++;
			}
		}
		// check whether the each element of the print array is the same as
		// each element(upper case) in the word selected
		if (lowerLineCounter == words.length()) {
			return true;
		} 
		else {
			return false;
		}
	}

	/**
	 * This method helps pick a word randomly from the words array
	 * @param upperLimit
	 * @param arrayOfGame
	 * @return a random word string from the words array
	 */
	public String pickARandonWord(int upperLimit, String[] arrayOfGame) {
		Random rand = new Random();
		int indexValue = rand.nextInt(upperLimit);
		String wordsSelected = arrayOfGame[indexValue];
		return wordsSelected;
	}

	/**
	 * This method helps get the length HashMap
	 * @return the HashMap which contains words classified by their lengths
	 */
	public HashMap<Integer, ArrayList<String>> getlengthHashMap() {
		MainControllerNormal game = new MainControllerNormal();
		String[] wordsArray = game.getLinesArray();
		ArrayList<String> lines = new ArrayList<String>
		(Arrays.asList(wordsArray));
		FilterUnnecessaryWord filteredWords = new FilterUnnecessaryWord(lines);
		HashMap<Integer, ArrayList<String>> dividedWords = 
				filteredWords.dividedByLength();
		return dividedWords;
	}

	/**
	 * This method helps print the print array
	 * @param printArray
	 */
	public void print(String[] printArray) {
		for (int i = 0; i < printArray.length; i++) {
			System.out.print(printArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// revise the first line(if want to play normal one)
		// to "Game game = new MainControllerNormal"
		Game game = new MainControllerEvil();
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, ArrayList<String>> dividedWords = game.
				getlengthHashMap();
		Set<Integer> lengthOfDivideWords = dividedWords.keySet();
		// let the user to select the length of the word
		System.out.println("Pick the number of words' length from " 
		+ lengthOfDivideWords);
		int userChoice = scan.nextInt();
		scan.nextLine();
		// get the corresponding arrayList
		ArrayList<String> wordofSpecificLength = dividedWords.get(userChoice);
		// build the initial print array
		String[] notPlayed = game.initialArray(userChoice);
		game.print(notPlayed);
		String[] arraySlected = wordofSpecificLength.
				toArray(new String[wordofSpecificLength.size()]);
		int lengthOfArraySlected = arraySlected.length;
		// randomly select a word from the arrayList
		String wordsSelected = game.
				pickARandonWord(lengthOfArraySlected, arraySlected);
		// play each game
		game.play(notPlayed, wordsSelected, wordofSpecificLength);
		// print different sentences for different cases
		if (game.getCounter() > 10) {
			System.out.println("Sorry you lost because you exceed 10 tries.");
		} 
		else if (game.isGameOver(wordsSelected, notPlayed) == true) {
			System.out.println("You win!!");
		}
		scan.close();
	}
}
