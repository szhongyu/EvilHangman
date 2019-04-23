package hangman;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class GameTest {

	MainControllerNormal gameNormal = new MainControllerNormal();

	@Test
	public void testSetAllGuess() {
		ArrayList<String> allGuess = new ArrayList<String>();
		gameNormal.setAllGuess(allGuess);
		ArrayList<String> allGuessGet = gameNormal.getAllGuess();
		int expected = 0;
		int actual = allGuessGet.size();
		assertEquals("there is no elements in the allGuessGet", expected, actual);
		allGuess.add("a");
		allGuess.add("c");
		ArrayList<String> allGuessGet2 = gameNormal.getAllGuess();
		int expected2 = 2;
		int actual2 = allGuessGet2.size();
		assertEquals("there is two elements in the allGuessGet", expected2, actual2);
		boolean expected3 = true;
		boolean actual3 = allGuessGet2.contains("a");
		assertEquals("'a' is in the allGuessGet", expected3, actual3);
		boolean expected4 = true;
		boolean actual4 = allGuessGet2.contains("c");
		assertEquals("'c' is in the allGuessGet", expected4, actual4);
	}

	@Test
	public void testSetWrongGuess() {
		ArrayList<String> wrongGuess = new ArrayList<String>();
		gameNormal.setWrongGuess(wrongGuess);
		ArrayList<String> wrongGuessGet = gameNormal.getWrongGuess();
		int expected = 0;
		int actual = wrongGuessGet.size();
		assertEquals("there is no elements in the wrongGuessGet", expected, actual);
		wrongGuess.add("a");
		wrongGuess.add("c");
		ArrayList<String> wrongGuessGet2 = gameNormal.getWrongGuess();
		int expected2 = 2;
		int actual2 = wrongGuessGet2.size();
		assertEquals("there is two elements in the wrongGuessGet", expected2, actual2);
		boolean expected3 = true;
		boolean actual3 = wrongGuessGet2.contains("a");
		assertEquals("'a' is in the wrongGuessGet", expected3, actual3);
		boolean expected4 = true;
		boolean actual4 = wrongGuessGet2.contains("c");
		assertEquals("'c' is in the wrongGuessGet", expected4, actual4);
	}

	@Test
	public void testSetCounter() {
		gameNormal.setCounter(5);
		int expected = 5;
		int actual = gameNormal.getCounter();
		assertEquals("the counter equals to 5", expected, actual);
	}

	@Test
	public void testGetAllGuess() {
		ArrayList<String> allGuess = new ArrayList<String>();
		gameNormal.setAllGuess(allGuess);
		ArrayList<String> allGuessGet = gameNormal.getAllGuess();
		int expected = 0;
		int actual = allGuessGet.size();
		assertEquals("there is no elements in the allGuessGet", expected, actual);
		allGuess.add("a");
		allGuess.add("c");
		ArrayList<String> allGuessGet2 = gameNormal.getAllGuess();
		int expected2 = 2;
		int actual2 = allGuessGet2.size();
		assertEquals("there is two elements in the allGuessGet", expected2, actual2);
		boolean expected3 = true;
		boolean actual3 = allGuessGet2.contains("a");
		assertEquals("'a' is in the allGuessGet", expected3, actual3);
		boolean expected4 = true;
		boolean actual4 = allGuessGet2.contains("c");
		assertEquals("'c' is in the allGuessGet", expected4, actual4);
	}

	@Test
	public void testGetWrongGuess() {
		ArrayList<String> wrongGuess = new ArrayList<String>();
		gameNormal.setWrongGuess(wrongGuess);
		ArrayList<String> wrongGuessGet = gameNormal.getWrongGuess();
		int expected = 0;
		int actual = wrongGuessGet.size();
		assertEquals("there is no elements in the wrongGuessGet", expected, actual);
		wrongGuess.add("a");
		wrongGuess.add("c");
		ArrayList<String> wrongGuessGet2 = gameNormal.getWrongGuess();
		int expected2 = 2;
		int actual2 = wrongGuessGet2.size();
		assertEquals("there is two elements in the wrongGuessGet", expected2, actual2);
		boolean expected3 = true;
		boolean actual3 = wrongGuessGet2.contains("a");
		assertEquals("'a' is in the wrongGuessGet", expected3, actual3);
		boolean expected4 = true;
		boolean actual4 = wrongGuessGet2.contains("c");
		assertEquals("'c' is in the wrongGuessGet", expected4, actual4);
	}

	@Test
	public void testGetCounter() {
		gameNormal.setCounter(5);
		int expected = 5;
		int actual = gameNormal.getCounter();
		assertEquals("the counter equals to 5", expected, actual);
	}

	@Test
	public void testCountTheTries() {
		int expected = 0;
		int actual = gameNormal.getCounter();
		assertEquals("the counter is 0 now", expected, actual);
		gameNormal.countTheTries();
		int expected2 = 1;
		int actual2 = gameNormal.getCounter();
		assertEquals("the counter is 1 now", expected2, actual2);
		gameNormal.countTheTries();
		gameNormal.countTheTries();
		int expected3 = 3;
		int actual3 = gameNormal.getCounter();
		assertEquals("the counter is 3 now", expected3, actual3);
	}

	@Test
	public void testGetLinesArray() {
		String[] gameArray = gameNormal.getLinesArray();
		String expected = "a";
		String actual = gameArray[0];
		assertEquals("the first element of gameArray should be 'a'", expected, actual);
		String expected2 = "aah";
		String actual2 = gameArray[1];
		assertEquals("the first element of gameArray should be 'aah'", expected2, actual2);
	}

	@Test
	public void testValidInput() {
		ArrayList<String> allGuess = new ArrayList<String>();
		allGuess.add("a");
		allGuess.add("c");
		// test the case the input is number
		boolean expected = false;
		boolean actual = gameNormal.vaildInput("1", allGuess);
		assertEquals("digit is not a valid input", expected, actual);
		// test the case the input is more than one character
		boolean expected2 = false;
		boolean actual2 = gameNormal.vaildInput("qwe", allGuess);
		assertEquals("multiple letter is not a valid input", expected2, actual2);
		// test the case the input is guessed before
		boolean expected3 = false;
		boolean actual3 = gameNormal.vaildInput("a", allGuess);
		assertEquals("'a' is in the guess list", expected3, actual3);
		// test the case the input is valid
		boolean expected4 = true;
		boolean actual4 = gameNormal.vaildInput("b", allGuess);
		assertEquals("'b' is a valid guess", expected4, actual4);
	}

	@Test
	public void testInitialArray() {
		String[] notPlayed = gameNormal.initialArray(5);
		int expected = 5;
		int actual = notPlayed.length;
		assertEquals("the length of notPlayed is 5", expected, actual);
		String expected2 = "_";
		String actual2 = notPlayed[0];
		assertEquals("any spot in notPlayed is '_'", expected2, actual2);
		String expected3 = "_";
		String actual3 = notPlayed[4];
		assertEquals("any spot in notPlayed is '_'", expected3, actual3);
	}

	@Test
	public void testIsGameOver() {
		// test the case when no letters are replaced
		String[] wordsPlay = { "_", "_", "_" };
		boolean expected = false;
		boolean actual = gameNormal.isGameOver("ohh", wordsPlay);
		assertEquals("the game is not over", expected, actual);
		// test the case when only one letter are replaced
		String[] wordsPlay2 = { "_", "_", "h" };
		boolean expected2 = false;
		boolean actual2 = gameNormal.isGameOver("ohh", wordsPlay2);
		assertEquals("the game is not over", expected2, actual2);
		// test the case when all letters are replaced
		String[] wordsPlay3 = { "O", "H", "H" };
		boolean expected3 = true;
		boolean actual3 = gameNormal.isGameOver("ohh", wordsPlay3);
		assertEquals("the game is over", expected3, actual3);
	}

	@Test
	public void testIsOverWordsAndWordsPlayNotSame() {
		// test the case when replaced print array is not same as the Uppercase of the
		// selected word
		String[] wordsPlay = { "o", "h", "h" };
		boolean expected = false;
		boolean actual = gameNormal.isGameOver("ohh", wordsPlay);
		assertEquals("the game is over", expected, actual);
		String[] wordsPlay2 = { "q", "w", "t" };
		boolean expected2 = false;
		boolean actual2 = gameNormal.isGameOver("ohh", wordsPlay2);
		assertEquals("the game is over", expected2, actual2);
	}

	@Test
	public void testPickARandonWord() {
		String[] arrayOfGame = { "a", "ab", "abc", "abcd", "abcde" };
		String random = gameNormal.pickARandonWord(5, arrayOfGame);
		boolean expected = true;
		boolean actual = Arrays.asList(arrayOfGame).contains(random);
		assertEquals("random world should in arrayOfGame", expected, actual);
	}

	@Test
	public void testGetlengthHashMap() {
		// based on there is only one word with length 45 in the words array
		HashMap<Integer, ArrayList<String>> lengthHashMap = gameNormal.getlengthHashMap();
		Set<Integer> keysOfLength = lengthHashMap.keySet();
		boolean expected = true;
		boolean actual = keysOfLength.contains(45);
		assertEquals("length 45 is in the keysOfLength set", expected, actual);
		ArrayList<String> stringOf45 = lengthHashMap.get(45);
		int expected2 = 1;
		int actual2 = stringOf45.size();
		assertEquals("the length of stringOf45 is only 1", expected2, actual2);
	}
}
