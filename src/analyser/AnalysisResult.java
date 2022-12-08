package analyser;
import java.util.ArrayList;
import java.util.List;
/**
 * Stores result information related to the analysis of text.
 * 
 * @author mdixon
 */
public class AnalysisResult {
	
	// TODO::Part1 add missing attributes (use UML model to identify these)
	public String lastWord = "";
	
	public int wordCount = 0;
	
	public int characterCount = 0;
	
	public int resetCount = 0;
	
	List<Integer> characterCountList = new ArrayList<>();
	
	public String shortestWord = "";
	
	public String longestWord = "";
	

	
	////////////////////////////////////////////////////////////

	/**
	 * Records a word, using the information given to calculate analysis results.
	 * 
	 * Any whitespace is trimmed from either side of the word prior to it being
	 * recorded.
	 * 
	 * @param word the word to be recorded (null or empty words are ignored).
	 */
	
	public void recordWord(String word) {
		// TODO:Part1 ensure word is not null or empty
		if(word != null && word.length() > 0) {
			// TODO:Part1 remove any whitespace
			word = word.trim();
			// TODO:Part1 store the word in the last word attribute
			setLastWord(word);
			// TODO:Part1 increment the word count attribute
			this.incWordCount();
			// TODO:Part1 check if word is the longest so far, if so record in appropriate attribute+
			// TODO:Part1 check if word is the shortest so far, if so record in appropriate attribute
			// TODO:Part1 add length of word to the total character count attribute
			this.setCharacterCount(word.length());
			this.setLongestWord(word);
			this.setShortedWord(word);	
		}

	}

	/**
	 * @return total number of characters recorded.
	 */
	
	public int getTotalChars() {
				
		return this.characterCount; // TODO:Part1 return correct attribute
	}

	/**
	 * @return total number of words recorded.
	 */
	
	public int getWordCount() {

		return this.wordCount; // TODO:Part1 return correct attribute
	}

	/**
	 * @return the number of times {@link #reset()} has been called.
	 */
	
	public int getResetCount() {

		return this.resetCount; // TODO:Part1 return correct attribute
	}

	/**
	 * Gets the longest word recorded.
	 * 
	 * note: If multiple longest recorded words contain the same number of
	 * characters, then the first one recorded is returned.
	 * @return 
	 */
	
	public String getLongestWord() {
		// TODO:Part1 return correct attribute
		return this.longestWord;
	}

	/**
	 * Gets the shortest word recorded.
	 * 
	 * note: If multiple shortest recorded words contain the same number of
	 * characters, then the first one recorded is returned.
	 * @param strings 
	 * 
	 * @return the shortest recorded word
	 */
	public String getShortestWord() {
		
		return this.shortestWord; // TODO:Part1 return correct attribute
	}

	/**
	 * Gets the most recently recorded word.
	 * 
	 * @return the most recently recorded word.
	 */
	public String getLastWord() {

		return this.lastWord; // TODO:Part1 return correct attribute
	}

	/*
	 * Calculates and returns the average length of all recorded words.
	 * 
	 * @return the average length of all recorded words. This will be 0.0 if no
	 *         words have been recorded.
	 */
	
	public double getAveWordLength() {
		// TODO:Part1 calculate average and return
		return this.characterCountList.stream().mapToDouble(d->d).average().orElse(0.0);
	}

	/**
	 * Resets the analysis results back to the initial state, and increments the
	 * reset count as returned by {@link #getResetCount()}.
	 */
	
	public void reset() {
		// TODO:Part1 reset appropriate attributes, and increment the reset count
		this.lastWord = "";
		this.characterCount = 0;
		this.shortestWord = "";
		this.longestWord = "";
		this.wordCount = 0;
		this.characterCountList.clear();
		this.resetCount++;
	}

	public void setLastWord(String lastWord) {
		this.lastWord = lastWord;
	}
	
	public void incWordCount(){
		this.wordCount++;
	}
	
	public void setCharacterCount(int characters){
		this.characterCount = this.characterCount+ characters;
		this.characterCountList.add(characters);
	}
	
	public void setShortedWord(String word) {
		if(this.shortestWord == ""){
			this.shortestWord = word;
			return;
		}
		
		if(word.length() < this.shortestWord.length()){
			this.shortestWord.trim();
			this.shortestWord = word;
		}
	}
	
	public void setLongestWord(String word) {	
		if(word.length() > this.longestWord.length()){
			this.longestWord = word;
		}
	}
}
