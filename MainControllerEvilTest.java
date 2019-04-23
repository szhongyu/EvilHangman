package hangman;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainControllerEvilTest {

	MainControllerEvil game = new MainControllerEvil();
	
	@Test
	public void testAddElementToArray() {
		//no operation
		int expected = 0;
		int actualAll = game.getAllGuess().size();
		int actualWrong = game.getWrongGuess().size();
		assertEquals("there is no elements in the allGuess",expected,actualAll);
		assertEquals("there is no elements in the wrongGuess",expected,actualWrong);
		//position is not "other"
		game.addElementToArray("a", "12");
		int expectedAll2 = 1;
		int actualAll2 = game.getAllGuess().size();
		assertEquals("there is one element in the allGuess",expectedAll2,actualAll2);
		boolean expectedAll3 = true;
		boolean actualAll3 = game.getAllGuess().contains("a");
		assertEquals("'a' is in allGuess",expectedAll3,actualAll3);
		int expectedWrong2 = 0;
		int actualWrong2 = game.getWrongGuess().size();
		assertEquals("there is one element in the allGuess",expectedWrong2,actualWrong2);
		boolean expectedWrong3 = false;
		boolean actualWrong3 = game.getWrongGuess().contains("A");
		assertEquals("'A' is not in wrongGuess",expectedWrong3,actualWrong3);
		//position not "other"
		game.addElementToArray("b", "other");
		int expectedAll4 = 2;
		int actualAll4 = game.getAllGuess().size();
		assertEquals("there is two element in the allGuess",expectedAll4,actualAll4);
		boolean expectedAll5 = true;
		boolean actualAll5 = game.getAllGuess().contains("b");
		assertEquals("'b' is in allGuess",expectedAll5,actualAll5);
		int expectedWrong4 = 1;
		int actualWrong4 = game.getWrongGuess().size();
		assertEquals("there is one element in the allGuess",expectedWrong4,actualWrong4);
		boolean expectedWrong5 = true;
		boolean actualWrong5 = game.getWrongGuess().contains("B");
		assertEquals("'B' is in wrongGuess",expectedWrong5,actualWrong5);
	}

	@Test
	public void testReplaceInitialArray() {
		//when the position string is "other"
		String[] notPlayed = game.initialArray(4);
		game.replaceInitialArray("other", "a",notPlayed);
		String expected =  "_";
		String actual = notPlayed[0];
		String actual1 = notPlayed[1];
		String actual2 = notPlayed[2];
		String actual3 = notPlayed[3];
		assertEquals("first spot is '_'",expected,actual);
		assertEquals("second spot is '_'",expected,actual1);
		assertEquals("thrird spot is '_'",expected,actual2);
		assertEquals("fourth spot is '_'",expected,actual3);
		//when there is only one position
		game.replaceInitialArray("2", "v",notPlayed);
		String expected2 =  "_";
		String expected3 = "V";
		String actual4 = notPlayed[0];
		String actual5 = notPlayed[1];
		String actual6 = notPlayed[2];
		String actual7 = notPlayed[3];
		assertEquals("first spot is '_'",expected2,actual4);
		assertEquals("second spot is '_'",expected2,actual5);
		assertEquals("thrird spot is 'V'",expected3,actual6);
		assertEquals("fourth spot is '_'",expected2,actual7);
		//when there are more than one positions
		game.replaceInitialArray("03", "a",notPlayed);
		String expected4 =  "_";
		String expected5 = "V";
		String expected6 = "A";
		String actual8 = notPlayed[0];
		String actual9 = notPlayed[1];
		String actual10 = notPlayed[2];
		String actual11 = notPlayed[3];
		assertEquals("first spot is 'A'",expected6,actual8);
		assertEquals("second spot is '_'",expected4,actual9);
		assertEquals("thrird spot is 'V'",expected5,actual10);
		assertEquals("fourth spot is 'A'",expected6,actual11);
		
	}

}
