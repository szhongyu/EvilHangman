package hangman;

import java.util.*;

public class FilterUnnecessaryWord {
	protected ArrayList<String> lines;
	protected String position;

	/**
	 * This is the constructor
	 * @param lines
	 */
	public FilterUnnecessaryWord(ArrayList<String> lines) {
		this.lines = lines;
	}

	/**
	 * This method helps filter upper case words from the words list
	 */
	public void filterUpperCase() {
		// use the iterator
		Iterator<String> itr = lines.iterator();
		// the loop will not end until the last word
		while (itr.hasNext()) {
			int numOfUpper = 0;
			String eachWord = itr.next();
			for (char ch : eachWord.toCharArray()) {
				if (Character.isUpperCase(ch)) {
					// counter the number of upper case letter in the word
					numOfUpper++;
				}
			}
			if (numOfUpper != 0) {
				itr.remove();
			}
		}
	}

	/**
	 * This method helps filter abbreviation words from the words list
	 */
	public void filterAbbreviations() {
		Iterator<String> itr2 = lines.iterator();
		while (itr2.hasNext()) {
			String eachWord2 = itr2.next();
			// check if "." in the word or not
			if (eachWord2.contains(".")) {
				itr2.remove();
			}
		}
	}

	/**
	 * This method helps filter apostrophe words from the words list
	 */
	public void filterApostrophe() {
		Iterator<String> itr3 = lines.iterator();
		while (itr3.hasNext()) {
			String eachWord3 = itr3.next();
			if (eachWord3.contains("'")) {
				itr3.remove();
			}
		}
	}

	/**
	 * This method helps filter hyphen words from the words list
	 */
	public void filterHyphen() {
		Iterator<String> itr4 = lines.iterator();
		while (itr4.hasNext()) {
			String eachWord3 = itr4.next();
			if (eachWord3.contains("-")) {
				itr4.remove();
			}
		}
	}

	/**
	 * This method helps filter compound words from the words list
	 */
	public void filterCompoundWords() {
		Iterator<String> itr5 = lines.iterator();
		while (itr5.hasNext()) {
			String eachWord5 = itr5.next();
			if (eachWord5.contains(" ")) {
				itr5.remove();
			}
		}
	}

	/**
	 * This method helps filter words contains digit from the words list
	 */
	public void filterDigit() {
		Iterator<String> itr6 = lines.iterator();
		while (itr6.hasNext()) {
			int numOfDigit = 0;
			String eachWord6 = itr6.next();
			for (char ch : eachWord6.toCharArray()) {
				if (Character.isDigit(ch)) {
					numOfDigit++;
				}
			}
			if (numOfDigit != 0) {
				itr6.remove();
			}
		}
	}

	/**
	 * This method helps filter all unnecessary words in the words list
	 */
	public void filterAll() {
		// let the arrayList filtered by all conditions
		this.filterDigit();
		this.filterAbbreviations();
		this.filterApostrophe();
		this.filterHyphen();
		this.filterCompoundWords();
		this.filterUpperCase();
	}

	/**
	 * This method helps get the lines in string array
	 * @return the lines in string array
	 */
	public String[] getLines() {
		return lines.toArray(new String[lines.size()]);
	}

	/**
	 * This method helps classify the words list by length
	 * @return the HashMap contains words classified by length
	 */
	public HashMap<Integer, ArrayList<String>> dividedByLength() {
		HashMap<Integer, ArrayList<String>> wordsByLength = 
				new HashMap<Integer, ArrayList<String>>();
		// get length of each word/lines
		for (String newWord : lines) {
			int length = newWord.length();
			// create an arrayList with words have same lengths
			if (wordsByLength.containsKey(length)) {
				ArrayList<String> valueArrayList2 = wordsByLength.get(length);
				valueArrayList2.add(newWord);
				wordsByLength.put(length, valueArrayList2);
			}
			else {
				// if certain length is not in the key set, add the key as well 
				// as the corresponding word
				ArrayList<String> valueArrayList3 = new ArrayList<String>();
				valueArrayList3.add(newWord);
				wordsByLength.put(length, valueArrayList3);
			}
		}
		return wordsByLength;
	}

	/**
	 * This method helps find the arrayList which meet the requirement of evil
	 * Hangman
	 * @param targetLetter
	 * @param linesChoose
	 * @return the arrayList which has the most elements among the arrayList in each
	 *         category
	 */
	public ArrayList<String> evilHangmanOperator
	(String targetLetter, ArrayList<String> linesChoose) {
		HashMap<String, ArrayList<String>> evilFilter = 
				new HashMap<String, ArrayList<String>>();
		// check which position of the words has the target letter
		for (String each : linesChoose) {
			String keysString = "";
			// if no position has the target letter then
			// I treat the key as "other"
			if (!(each.contains(targetLetter))) {
				keysString = "other";
			} 
			else {
				String[] letterEach = each.split("");
				for (int i = 0; i < letterEach.length; i++) {
					// create a string contains the position
					// information of each word
					if (letterEach[i].equals(targetLetter)) {
						keysString = keysString + i;
					}
				}
			}
			// classify the words by their position string
			if (evilFilter.containsKey(keysString)) {
				ArrayList<String> valueEvil = evilFilter.get(keysString);
				valueEvil.add(each);
				evilFilter.put(keysString, valueEvil);
			} 
			else {
				ArrayList<String> valueEvil2 = new ArrayList<String>();
				valueEvil2.add(each);
				evilFilter.put(keysString, valueEvil2);
			}
		}
		Set<String> keyEvil = evilFilter.keySet();
		int max = 0;
		ArrayList<String> valueEvilTotal = new ArrayList<String>();
		for (String key : keyEvil) {
			ArrayList<String> eachCategory = evilFilter.get(key);
			// check which arrayList in the HashMap has the most element
			// if more than one arrayList has the most element, choose the
			// latter one
			if (eachCategory.size() >= max) {
				max = eachCategory.size();
				valueEvilTotal = evilFilter.get(key);
				// set the position equals to the key whose arrayList
				// has the most elements
				position = key;
			}
		}
		return valueEvilTotal;
	}

	/**
	 * This method helps find the position string where on that position, the
	 * arrayList has the most words
	 * @return the position string
	 */
	public String getPosition() {
		return position;
	}

}
