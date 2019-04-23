package hangman;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FilterUnnecessaryWordTest {

	@Test
	public void testFilterUnnecessaryWord() {
		String[] wordArray = { "hello" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		String[] actualLines = testLines.getLines();
		int expected = 1;
		int actual = actualLines.length;
		assertEquals("The length of actualLines should be 1", expected, actual);
		String expected1 = "hello";
		String actual1 = actualLines[0];
		assertEquals("The only element in actualLines is 'hello'", expected1, actual1);
	}

	@Test
	public void testFilterUpperCase() {
		// when the lines contains invalid elements
		String[] wordArray = { "Hello", "world", "Java", "2programming're", "3NCAA" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterUpperCase();
		String[] filtered = testLines.getLines();
		int expected = 2;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 2", expected, actual);
		String expected2 = "world";
		String actual2 = filtered[0];
		assertEquals("The first element is 'world' ", expected2, actual2);
		String expected3 = "2programming're";
		String actual3 = filtered[1];
		assertEquals("The second element is '2programming're' ", expected3, actual3);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected4 = 1;
		int actual4 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected4, actual4);
		String expected5 = "hello";
		String actual5 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected5, actual5);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected6 = 0;
		int actual6 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected6, actual6);

	}

	@Test
	public void testFilterAbbreviations() {
		// when the lines contains invalid elements
		String[] wordArray = { "adv.", "world", "Java", "2programming're", "3NCA.A" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterAbbreviations();
		String[] filtered = testLines.getLines();
		int expected = 3;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 3", expected, actual);
		String expected2 = "world";
		String actual2 = filtered[0];
		assertEquals("The first element is 'world' ", expected2, actual2);
		String expected3 = "Java";
		String actual3 = filtered[1];
		assertEquals("The second element is 'Java' ", expected3, actual3);
		String expected4 = "2programming're";
		String actual4 = filtered[2];
		assertEquals("The third element is '2programming're' ", expected4, actual4);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected5 = 1;
		int actual5 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected5, actual5);
		String expected6 = "hello";
		String actual6 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected6, actual6);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected7 = 0;
		int actual7 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected7, actual7);

	}

	@Test
	public void testFilterApostrophe() {
		// when the lines contains invalid elements
		String[] wordArray = { "Hello's", "world", "Java", "2programming're", "3NCA.A" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterApostrophe();
		String[] filtered = testLines.getLines();
		int expected = 3;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 3", expected, actual);
		String expected2 = "world";
		String actual2 = filtered[0];
		assertEquals("The first element is 'world' ", expected2, actual2);
		String expected3 = "Java";
		String actual3 = filtered[1];
		assertEquals("The second element is 'Java' ", expected3, actual3);
		String expected4 = "3NCA.A";
		String actual4 = filtered[2];
		assertEquals("The third element is '3NCA.A' ", expected4, actual4);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected5 = 1;
		int actual5 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected5, actual5);
		String expected6 = "hello";
		String actual6 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected6, actual6);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected7 = 0;
		int actual7 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected7, actual7);
	}

	@Test
	public void testFilterHyphen() {
		// when the lines contains invalid elements
		String[] wordArray = { "Hello-a", "world", "Java", "2programming're", "3NCA-A" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterHyphen();
		String[] filtered = testLines.getLines();
		int expected = 3;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 3", expected, actual);
		String expected2 = "world";
		String actual2 = filtered[0];
		assertEquals("The first element is 'world' ", expected2, actual2);
		String expected3 = "Java";
		String actual3 = filtered[1];
		assertEquals("The second element is 'Java' ", expected3, actual3);
		String expected4 = "2programming're";
		String actual4 = filtered[2];
		assertEquals("The third element is '2programming're' ", expected4, actual4);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected5 = 1;
		int actual5 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected5, actual5);
		String expected6 = "hello";
		String actual6 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected6, actual6);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected7 = 0;
		int actual7 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected7, actual7);
	}

	@Test
	public void testFilterCompoundWords() {
		// when the lines contains invalid elements
		String[] wordArray = { "Hello a", "world", "Java", "2 programming re", "post office" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterCompoundWords();
		String[] filtered = testLines.getLines();
		int expected = 2;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 2", expected, actual);
		String expected2 = "world";
		String actual2 = filtered[0];
		assertEquals("The first element is 'world' ", expected2, actual2);
		String expected3 = "Java";
		String actual3 = filtered[1];
		assertEquals("The second element is 'Java' ", expected3, actual3);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected4 = 1;
		int actual4 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected4, actual4);
		String expected5 = "hello";
		String actual5 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected5, actual5);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected6 = 0;
		int actual6 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected6, actual6);
	}

	@Test
	public void testFilterDigit() {
		// when the lines contains invalid elements
		String[] wordArray = { "Hello", "world", "Java", "2programming're", "3NCA-A" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterDigit();
		String[] filtered = testLines.getLines();
		int expected = 3;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 3", expected, actual);
		String expected2 = "Hello";
		String actual2 = filtered[0];
		assertEquals("The first element is 'Hello' ", expected2, actual2);
		String expected3 = "world";
		String actual3 = filtered[1];
		assertEquals("The second element is 'world' ", expected3, actual3);
		String expected4 = "Java";
		String actual4 = filtered[2];
		assertEquals("The third element is 'Java' ", expected4, actual4);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected5 = 1;
		int actual5 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected5, actual5);
		String expected6 = "hello";
		String actual6 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected6, actual6);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected7 = 0;
		int actual7 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected7, actual7);
	}

	@Test
	public void testGetLines() {
		// when there are elements in the list
		String[] wordArray = { "Hello", "world", "Java", "2programming're", "3NCA-A" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		String[] filtered = testLines.getLines();
		int expected = 5;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 5", expected, actual);
		String expected2 = "Hello";
		String actual2 = filtered[0];
		assertEquals("The first element is 'Hello' ", expected2, actual2);
		String expected3 = "world";
		String actual3 = filtered[1];
		assertEquals("The second element is 'world' ", expected3, actual3);
		String expected4 = "Java";
		String actual4 = filtered[2];
		assertEquals("The third element is 'Java' ", expected4, actual4);
		String expected5 = "2programming're";
		String actual5 = filtered[3];
		assertEquals("The fourth element is '2programming're' ", expected5, actual5);
		String expected6 = "3NCA-A";
		String actual6 = filtered[4];
		assertEquals("The fifth element is '3NCA-A' ", expected6, actual6);
		// when there is no elements in the list
		String[] wordArray2 = {};
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		String[] filtered2 = testLines2.getLines();
		int expected7 = 0;
		int actual7 = filtered2.length;
		assertEquals("The length of the filtered array is 0", expected7, actual7);
	}

	@Test
	public void testFilterAll() {
		// when the lines contains invalid elements
		String[] wordArray = { "Hello", "world-wide", "java", "programming're", "adv.", "3D", "post office" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.filterAll();
		String[] filtered = testLines.getLines();
		int expected = 1;
		int actual = filtered.length;
		assertEquals("The length of the filtered array is 1", expected, actual);
		String expected2 = "java";
		String actual2 = filtered[0];
		assertEquals("The only element is 'java' ", expected2, actual2);
		// when the lines only have valid element
		String[] wordArray2 = { "hello" };
		ArrayList<String> lines2 = new ArrayList<String>(Arrays.asList(wordArray2));
		FilterUnnecessaryWord testLines2 = new FilterUnnecessaryWord(lines2);
		testLines2.filterUpperCase();
		String[] filtered2 = testLines2.getLines();
		int expected3 = 1;
		int actual3 = filtered2.length;
		assertEquals("The length of the filtered array is 1", expected3, actual3);
		String expected4 = "hello";
		String actual4 = filtered2[0];
		assertEquals("The only element is 'hello' ", expected4, actual4);
		// when there is no elements in lines
		String[] wordArray3 = {};
		ArrayList<String> lines3 = new ArrayList<String>(Arrays.asList(wordArray3));
		FilterUnnecessaryWord testLines3 = new FilterUnnecessaryWord(lines3);
		testLines2.filterUpperCase();
		String[] filtered3 = testLines3.getLines();
		int expected5 = 0;
		int actual5 = filtered3.length;
		assertEquals("The length of the filtered array is 0", expected5, actual5);
	}

	@Test
	public void testDividedByLength() {
		String[] wordArray = { "hello", "java", "apple" };
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(lines);
		testLines.dividedByLength();
		Map<Integer, ArrayList<String>> testDivided = testLines.dividedByLength();
		Set<Integer> length = testDivided.keySet();
		int expectedLength = 2;
		int actualLengthOfSet = length.size();
		assertEquals("the size of the length should be 2", expectedLength, actualLengthOfSet);
		ArrayList<String> wordLengthOf4 = testDivided.get(4);
		String[] wordLengthOfFour = wordLengthOf4.toArray(new String[wordLengthOf4.size()]);
		String expectedWordOf4 = "java";
		String actualWordOf4 = wordLengthOfFour[0];
		assertEquals("The only element of length of 4 is 'java'", expectedWordOf4, actualWordOf4);
		ArrayList<String> wordLengthOf5 = testDivided.get(5);
		String[] wordLengthOfFive = wordLengthOf5.toArray(new String[wordLengthOf5.size()]);
		String expectedWordOf5First = "hello";
		String actualWordOf5First = wordLengthOfFive[0];
		assertEquals("The only element of length of 4 is 'java'", expectedWordOf5First, actualWordOf5First);
		String expectedWordOf5Second = "apple";
		String actualWordOf5Second = wordLengthOfFive[1];
		assertEquals("The only element of length of 4 is 'java'", expectedWordOf5Second, actualWordOf5Second);
	}

	@Test
	public void testEvilHangmanOperator() {
		// if there is only one position has the most words
		String[] wordArray = { "cable", "cabce", "cbecd", "cbael", "befdc", "cghfd", "degha" };
		ArrayList<String> linesArray = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(linesArray);
		ArrayList<String> linesEvil = testLines.evilHangmanOperator("c", linesArray);
		int expectedLength = 3;
		int actualLength = linesEvil.size();
		assertEquals("The length should be 3", expectedLength, actualLength);
	}

	@Test
	public void testEvilHangmanOperatorMultiple() {
		// if there is only one positions have the most words
		// and the size of the corresponding arrayList not equals to 1
		String[] wordArray = { "cable", "cabce", "cbecd", "cbael", "befdc", "cghfd", "degha" };
		ArrayList<String> linesArray = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(linesArray);
		ArrayList<String> evilopeartor = testLines.evilHangmanOperator("c", linesArray);
		int expected = 3;
		int actual = evilopeartor.size();
		assertEquals("three elements should in evilopeartor", expected, actual);
	}

	@Test
	public void testEvilHangmanOperatorSingle() {
		// if there are more than one positions have the most words
		// and the size of the corresponding arrayList equals to 1
		String[] wordArray = { "cable", "cabce", "befdc", "degha" };
		ArrayList<String> linesArray = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(linesArray);
		ArrayList<String> evilopeartor = testLines.evilHangmanOperator("c", linesArray);
		int expected = 1;
		int actual = evilopeartor.size();
		assertEquals("only one elements should in evilopeartor", expected, actual);
	}

	@Test
	public void testEvilHangmanOperatorEmpty() {
		// if the word Array is empty
		String[] wordArray = {};
		ArrayList<String> linesArray = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(linesArray);
		ArrayList<String> evilopeartor = testLines.evilHangmanOperator("c", linesArray);
		int expected = 0;
		int actual = evilopeartor.size();
		assertEquals("three elements should in evilopeartor", expected, actual);
	}

	@Test
	public void testGetPosition() {
		// if the more than one position in the string
		String[] wordArray = { "cable", "cabce", "cbecd", "befdc", "degha" };
		ArrayList<String> linesArray = new ArrayList<String>(Arrays.asList(wordArray));
		FilterUnnecessaryWord testLines = new FilterUnnecessaryWord(linesArray);
		testLines.evilHangmanOperator("c", linesArray);
		String expected = "03";
		String actual = testLines.getPosition();
		assertEquals("position should be 03", expected, actual);
		// if only one position in the string
		String[] wordArray2 = { "cabfe", "cbefd", "cefdc", "degha" };
		ArrayList<String> linesArray2 = new ArrayList<String>(Arrays.asList(wordArray2));
		testLines.evilHangmanOperator("c", linesArray2);
		String expected2 = "0";
		String actual2 = testLines.getPosition();
		assertEquals("position should be 0", expected2, actual2);
		String[] wordArray3 = { "cabfe", "cbecd", "cefdc", "degha" };
		ArrayList<String> linesArray3 = new ArrayList<String>(Arrays.asList(wordArray3));
		testLines.evilHangmanOperator("c", linesArray3);
		String expected3 = "04";
		String actual3 = testLines.getPosition();
		assertEquals("position should be 04", expected3, actual3);
		// if the position string is "other"
		String[] wordArray4 = { "cabfe", "cbecd", "qwert", "degha" };
		ArrayList<String> linesArray4 = new ArrayList<String>(Arrays.asList(wordArray4));
		testLines.evilHangmanOperator("c", linesArray4);
		String expected4 = "other";
		String actual4 = testLines.getPosition();
		assertEquals("position should be other", expected4, actual4);
	}

}
