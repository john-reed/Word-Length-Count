import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The Class AverageSentenceLength.
 * 
 * Scanner class was chosen for performance when processing large text files.
 * 
 * See printInstructions method for program instructions.
 * 
 * @author Justin Stringer
 * 
 * @version 1.0 Final Draft
 * @version 1.1 Fixed invalid delimiter defect.
 */
public class AverageSentenceLength {

	/** The input file name. */
	private String inputFileName;

	/** The input file. */
	private File inputFile;

	/** The sentence delimiters. */
	private String sentenceDelimiters;

	/** The Constant DEFAULT_SENTENCE_DELIMITERS. */
	static final String DEFAULT_SENTENCE_DELIMITERS = ".?!";

	/** The Constant SUPPORTED_SENTENCE_DELIMITERS. */
	static final String SUPPORTED_SENTENCE_DELIMITERS = ".?!;:,";

	/** The word length threshold. */
	private int wordLengthThreshold;

	/** The Constant DEFAULT_WORD_LENGTH_THRESHOLD. */
	static final int DEFAULT_WORD_LENGTH_THRESHOLD = 3;

	/** The number of sentences in essay. */
	private int numberOfSentencesInEssay;

	/**
	 * The total number of words in all sentences in essay that exceed the
	 * threshold.
	 */
	private int totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold;

	/** The average number of words per sentence rounded up. */
	private int averageNumberOfWordsPerSentenceRoundedUp;

	/** The Constant WORD_LENGTH_THRESHOLD_ERROR_MESSAGE. */
	private static final String WORD_LENGTH_THRESHOLD_ERROR_MESSAGE = "Invalid word length threshold: Word length threshold must be a positive whole number greater than 0, for example: 1, 2, 3, 4, 5, ... 12, ....";
	
	/** The Constant INVALID_DELIMITER_ARGUMENT_ERROR_MESSAGE. */
	private static final String INVALID_DELIMITER_ARGUMENT_ERROR_MESSAGE = "Invalid sentence delimiter argument: Acceptable sentence delimiters are .?!;:,";

	/** The Constant INVALID_ARGUMENT_ERROR_MESSAGE. */
	private static final String INVALID_ARGUMENT_ERROR_MESSAGE = "Invalid command line argument: -d and -l are the only acceptable command line options.";

	/**
	 * Gets the input file name.
	 * 
	 * @return the input file name
	 */
	public String getInputFileName() {
		return this.inputFileName;
	}

	/**
	 * Sets the input file name.
	 * 
	 * @param inputFileName
	 *            the new input file name
	 */
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	/**
	 * Gets the input file.
	 * 
	 * @return the input file
	 */
	public File getInputFile() {
		return this.inputFile;
	}

	/**
	 * Sets the input file.
	 * 
	 * @param inputFile
	 *            the new input file
	 */
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * Gets the sentence delimiters.
	 * 
	 * @return the sentence delimiters
	 */
	public String getSentenceDelimiters() {
		return this.sentenceDelimiters;
	}

	/**
	 * Sets the sentence delimiters.
	 * 
	 * @param sentenceDelimiters
	 *            the new sentence delimiters
	 */
	public void setSentenceDelimiters(String sentenceDelimiters) {
		this.sentenceDelimiters = sentenceDelimiters;
	}

	/**
	 * Gets the word length threshold.
	 * 
	 * @return the word length threshold
	 */
	public int getWordLengthThreshold() {
		return this.wordLengthThreshold;
	}

	/**
	 * Sets the word length threshold.
	 * 
	 * @param wordLengthThreshold
	 *            the new word length threshold
	 */
	public void setWordLengthThreshold(int wordLengthThreshold) {
		this.wordLengthThreshold = wordLengthThreshold;
	}

	/**
	 * Gets the number of sentences in essay.
	 * 
	 * @return the number of sentences in essay
	 */
	public int getNumberOfSentencesInEssay() {
		return this.numberOfSentencesInEssay;
	}

	/**
	 * Sets the number of sentences in essay.
	 * 
	 * @param numberOfSentencesInEssay
	 *            the new number of sentences in essay
	 */
	public void setNumberOfSentencesInEssay(int numberOfSentencesInEssay) {
		this.numberOfSentencesInEssay = numberOfSentencesInEssay;
	}

	/**
	 * Gets the total number of words in all sentences in essay that exceed the
	 * threshold.
	 * 
	 * @return the total number of words in all sentences in essay that exceed
	 *         the threshold
	 */
	public int getTotalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold() {
		return this.totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold;
	}

	/**
	 * Sets the total number of words in all sentences in essay that exceed the
	 * threshold.
	 * 
	 * @param totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold
	 *            the new total number of words in all sentences in essay that
	 *            exceed the threshold
	 */
	public void setTotalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold(
			int totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold) {
		this.totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold = totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold;
	}

	/**
	 * Gets the average number of words per sentence rounded up.
	 * 
	 * @return the average number of words per sentence rounded up
	 */
	public int getAverageNumberOfWordsPerSentenceRoundedUp() {
		return this.averageNumberOfWordsPerSentenceRoundedUp;
	}

	/**
	 * Sets the average number of words per sentence rounded up.
	 * 
	 * @param averageNumberOfWordsPerSentenceRoundedUp
	 *            the new average number of words per sentence rounded up
	 */
	public void setAverageNumberOfWordsPerSentenceRoundedUp(
			int averageNumberOfWordsPerSentenceRoundedUp) {
		this.averageNumberOfWordsPerSentenceRoundedUp = averageNumberOfWordsPerSentenceRoundedUp;
	}

	/**
	 * Instantiates a new average sentence length.
	 */
	public AverageSentenceLength() {
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		AverageSentenceLength averageSentenceLength = new AverageSentenceLength();

		try {
			averageSentenceLength.parseCommandLineArguments(args);
			averageSentenceLength.processEssay();

			System.out
					.println("With sentences delimited by "
							+ averageSentenceLength.getSentenceDelimiters()
							+ " the average number of words per sentence in the file \""
							+ averageSentenceLength.getInputFileName()
							+ "\" with "
							+ averageSentenceLength.getWordLengthThreshold()
							+ " or more letters is "
							+ averageSentenceLength
									.getAverageNumberOfWordsPerSentenceRoundedUp()
							+ ".");

		} catch (RuntimeException runtimeException) {
			System.out.println("An error occurred processing the essay. "
					+ runtimeException.getMessage());
			AverageSentenceLength.printInstructions();
		}
	}

	/**
	 * Parses the command line arguments.
	 * 
	 * @param args
	 *            the args
	 */
	void parseCommandLineArguments(String[] args) {

		this.setSentenceDelimiters(AverageSentenceLength.DEFAULT_SENTENCE_DELIMITERS);
		this.setWordLengthThreshold(AverageSentenceLength.DEFAULT_WORD_LENGTH_THRESHOLD);

		// If there are no arguments or an incompatible number of arguments then
		// terminate.
		if (args == null
				|| !(args.length == 1 || args.length == 3 || args.length == 5)) {
			throw new RuntimeException(
					"Invalid number of command line arguments!");
		}

		this.setInputFileName(args[0]);

		// Check if we have at least one optional command line argument.
		if (args.length > 1) {
			if (args[1].equalsIgnoreCase("-d")) { // Is it a delimiter?
				this.setSentenceDelimiters(args[2]);
			} else if (args[1].equalsIgnoreCase("-l")) { // Is it a word length
															// threshold?
				if (args[2].matches("^\\d+$")) { // Check if it is an integer.
					this.setWordLengthThreshold(Integer.valueOf(args[2]));
				} else { // If word length threshold is not an integer then
							// terminate.
					throw new RuntimeException(
							AverageSentenceLength.WORD_LENGTH_THRESHOLD_ERROR_MESSAGE);
				}
			} else { // If it is not a delimiter or a word length threshold then
						// terminate.
				throw new RuntimeException(
						AverageSentenceLength.INVALID_ARGUMENT_ERROR_MESSAGE);
			}
		}

		// Check if we have a second optional command line argument.
		if (args.length == 5) {
			if (args[3].equalsIgnoreCase(args[1])) { // If we we have two -d's
														// or two -l's, then
														// terminate.
				throw new RuntimeException(
						"Invalid command line arguments: cannot have two -d or -l arguments!");
			} else {
				if (args[3].equalsIgnoreCase("-d")) { // Is it a delimiter?
					this.setSentenceDelimiters(args[4]);
				} else if (args[3].equalsIgnoreCase("-l")) { // Is it a word
																// length
																// threshold?
					if (args[4].matches("^\\d+$")) { // Check if it is an
														// integer.
						this.setWordLengthThreshold(Integer.valueOf(args[4]));
					} else { // If word length threshold is not an integer then
						// terminate.
						throw new RuntimeException(
								AverageSentenceLength.WORD_LENGTH_THRESHOLD_ERROR_MESSAGE);
					}
				} else { // If it is not a delimiter or a word length threshold
							// then terminate.
					throw new RuntimeException(
							AverageSentenceLength.INVALID_ARGUMENT_ERROR_MESSAGE);
				}
			}
		}

		this.setInputFile(new File(this.getInputFileName()));

		if (!this.getInputFile().exists()) {
			throw new RuntimeException("Input file \""
					+ this.getInputFileName() + "\" not found!");
		}

		if (this.getInputFile().length() == 0) {
			throw new RuntimeException("Input file \""
					+ this.getInputFileName() + "\" is empty!");
		}

		// Check that each optional sentence delimiter supplied is in the list
		// of supported sentence delimiters.
		for (Character delimiter : this.getSentenceDelimiters().toCharArray()) {
			if (AverageSentenceLength.SUPPORTED_SENTENCE_DELIMITERS
					.indexOf(delimiter) == -1) {
				throw new RuntimeException(
						AverageSentenceLength.INVALID_DELIMITER_ARGUMENT_ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Prints the instructions.
	 */
	private static void printInstructions() {
		System.out
				.println("This program is executed as: java AverageSentenceLength <filename> -d \"<comma separated list of sentence delimiters>\" -l <integer>");
		System.out
				.println("Supported sentence delimiters are \".\" (period), \"?\" (question mark), \"!\" (exclamation mark), \",\" (comma), \";\" (semi-colon), and \":\" (colon).");
		System.out
				.println("Word length threshold must be a positive whole number greater than 0, i.e. 1, 2, 3, 4, 5, ... 12, ....");
		System.out
				.println("An example execution could be: java AverageSentenceLength my_essay.txt -d \".,?,!\" -l 5");
		System.out
				.println("Both the sentence delimiter and word length threshold arguments are optional.");
		System.out
				.println("If a sentence delimiter argument is not supplied, then the default sentence delimiters of \".\" (period), \"?\" (question mark), and \"!\" (exclamation mark) are used.");
		System.out
				.println("If a word length threshold argument is not supplied then a default value of 3 is used.");
		System.out
				.println("For example \'java AverageSentenceLength my_essay.txt\' is the same as \'java AverageSentenceLength my_essay.txt -d \""
						+ AverageSentenceLength.DEFAULT_SENTENCE_DELIMITERS
						+ "\" -l 3\'");
	}

	/**
	 * Process essay.
	 */
	public void processEssay() {
		List<String> listOfSentencesInEssay = this.getListOfSentencesInEssay();

		this.numberOfSentencesInEssay = listOfSentencesInEssay.size();

		for (String sentence : listOfSentencesInEssay) {
			this.setTotalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold(this
					.getTotalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold()
					+ this.getNumberOfWordsThatExceedThreshold(sentence,
							this.getWordLengthThreshold()));
		}

		this.setAverageNumberOfWordsPerSentenceRoundedUp((int) Math
				.ceil(this.totalNumberOfWordsInAllSentencesInEssayThatExceedTheThreshold
						/ this.numberOfSentencesInEssay));
	}

	/**
	 * Gets the list of sentences in essay.
	 * 
	 * @return the list of sentences in essay
	 */
	List<String> getListOfSentencesInEssay() {
		ArrayList<String> listOfSentencesInEssay = new ArrayList<String>();

		Scanner scanner;
		try {
			scanner = new Scanner(this.getInputFile());
		} catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException("Input file " + this.getInputFileName()
					+ " not found!");
		}

		scanner.useDelimiter(Pattern.compile("[" + this.getSentenceDelimiters()
				+ "]"));
		while (scanner.hasNext()) {
			String sentence = scanner.next().replaceAll("\\s+", " ").trim();
			if (sentence.length() != 0) {
				listOfSentencesInEssay.add(sentence);
			}
		}
		scanner.close();

		return listOfSentencesInEssay;
	}

	/**
	 * Gets the number of words that exceed threshold.
	 * 
	 * @param sentence
	 *            the sentence
	 * @param wordLengthThreshold
	 *            the word length threshold
	 * @return the number of words that equal or exceed threshold
	 */
	int getNumberOfWordsThatExceedThreshold(String sentence,
			int wordLengthThreshold) {
		int numberOfWordsThatExceedThreshold = 0;
		for (String word : sentence.split("\\s+")) {
			// Remove all non-alphanumeric characters.
			String strippedWord = word.replaceAll("[^a-zA-Z1-9]", "");
			if (strippedWord.length() >= wordLengthThreshold) {
				numberOfWordsThatExceedThreshold++;
			}
		}

		return numberOfWordsThatExceedThreshold;
	}
}
