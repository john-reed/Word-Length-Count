import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class AverageSentenceLengthTest.
 * 
 * 28 total tests, 17 integration tests, and 11 true unit tests.
 * 
 * @author Justin Stringer
 * 
 * @version 1.0 Final Draft
 * @version 1.01 Added test for invalid delimiter defect.
 */
public class AverageSentenceLengthTest {

	/** The average sentence length under test. */
	private AverageSentenceLength averageSentenceLengthUnderTest;

	/** The test file name0. */
	private final String testFileName0 = "test_essay_0.txt";

	/** The test file name1. */
	private final String testFileName1 = "test_essay_1.txt";

	/** The test file name2. */
	private final String testFileName2 = "test_essay_2.txt";

	/** The test file name3. */
	private final String testFileName3 = "test_essay_3.txt";

	/** The test sentence delimiters1. */
	private final String testSentenceDelimiters1 = ".?!";

	/** The test word length threshold1. */
	private final int testWordLengthThreshold1 = 3;

	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.averageSentenceLengthUnderTest = new AverageSentenceLength();
	}

	/**
	 * Tear down.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		this.averageSentenceLengthUnderTest = null;
	}

	/**
	 * Test parse command line arguments with null argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithNullArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(null);
	}

	/**
	 * Test parse command line arguments with only file name argument for empty
	 * file.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithOnlyFileNameArgumentForEmptyFile() {
		averageSentenceLengthUnderTest
				.parseCommandLineArguments(new String[] { this.testFileName0 });
	}

	/**
	 * Test parse command line arguments with only file name argument for
	 * existant file.
	 */
	@Test
	public void testParseCommandLineArgumentsWithOnlyFileNameArgumentForExistantFile() {
		averageSentenceLengthUnderTest
				.parseCommandLineArguments(new String[] { this.testFileName1 });

		assertEquals(this.testFileName1,
				averageSentenceLengthUnderTest.getInputFileName());

		assertEquals(AverageSentenceLength.DEFAULT_SENTENCE_DELIMITERS,
				averageSentenceLengthUnderTest.getSentenceDelimiters());

		assertEquals(AverageSentenceLength.DEFAULT_WORD_LENGTH_THRESHOLD,
				averageSentenceLengthUnderTest.getWordLengthThreshold());
	}

	/**
	 * Test parse command line arguments with only file name argument for non
	 * existant file.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithOnlyFileNameArgumentForNonExistantFile() {
		averageSentenceLengthUnderTest
				.parseCommandLineArguments(new String[] { "non_existant_file_name.txt" });
	}

	/**
	 * Test parse command line arguments with only2 arguments.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithOnly2Arguments() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				"non_existant_file_name.txt", "-d" });
	}

	/**
	 * Test parse command line arguments with only4 arguments.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithOnly4Arguments() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				"non_existant_file_name.txt", "-d", ".", "-l" });
	}

	/**
	 * Test parse command line arguments with6 arguments.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWith6Arguments() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				"non_existant_file_name.txt", "-d", ".", "-l", "5", "NA" });
	}

	/**
	 * Test parse command line arguments with all valid arguments but non
	 * existant file.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithAllValidArgumentsButNonExistantFile() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				"non_existant_file_name.txt", "-d", ".", "-l", "3" });
	}

	/**
	 * Test parse command line arguments with valid delimiter only.
	 */
	@Test
	public void testParseCommandLineArgumentsWithValidDelimiterOnly() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-d", "." });

		assertEquals(this.testFileName1,
				averageSentenceLengthUnderTest.getInputFileName());

		assertEquals(".",
				averageSentenceLengthUnderTest.getSentenceDelimiters());

		assertEquals(AverageSentenceLength.DEFAULT_WORD_LENGTH_THRESHOLD,
				averageSentenceLengthUnderTest.getWordLengthThreshold());
	}

	/**
	 * Test parse command line arguments with valid word length threshold only.
	 */
	@Test
	public void testParseCommandLineArgumentsWithValidWordLengthThresholdOnly() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-l", "5" });

		assertEquals(this.testFileName1,
				averageSentenceLengthUnderTest.getInputFileName());

		assertEquals(AverageSentenceLength.DEFAULT_SENTENCE_DELIMITERS,
				averageSentenceLengthUnderTest.getSentenceDelimiters());

		assertEquals(5, averageSentenceLengthUnderTest.getWordLengthThreshold());
	}

	/**
	 * Test parse command line arguments with two delimiter arguments.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithTwoDelimiterArguments() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-d", ".", "-d", "?" });
	}

	/**
	 * Test parse command line arguments with two word length threshold
	 * arguments.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithTwoWordLengthThresholdArguments() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-l", "4", "-l", "5" });
	}

	/**
	 * Test parse command line arguments with all valid arguments.
	 */
	@Test
	public void testParseCommandLineArgumentsWithAllValidArguments() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-d", ".", "-l", "5" });

		assertEquals(this.testFileName1,
				averageSentenceLengthUnderTest.getInputFileName());

		assertEquals(".",
				averageSentenceLengthUnderTest.getSentenceDelimiters());

		assertEquals(5, averageSentenceLengthUnderTest.getWordLengthThreshold());
	}

	/**
	 * Test parse command line arguments with invalid word length threshold as
	 * only argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithInvalidWordLengthThresholdAsOnlyArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-l", "X" });
	}

	/**
	 * Test parse command line arguments with invalid word length threshold as
	 * first argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithInvalidWordLengthThresholdAsFirstArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-l", "X", "-d", "!" });
	}

	/**
	 * Test parse command line arguments with invalid word length threshold as
	 * second argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithInvalidWordLengthThresholdAsSecondArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-d", "!", "-l", "X" });
	}

	/**
	 * Test parse command line arguments with only invalid argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithOnlyInvalidArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-x", "!" });
	}

	/**
	 * Test parse command line arguments with invalid first argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithInvalidFirstArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-x", "!", "-l", "2" });
	}

	/**
	 * Test parse command line arguments with invalid second argument.
	 */
	@Test(expected = RuntimeException.class)
	public void testParseCommandLineArgumentsWithInvalidSecondArgument() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-d", "!", "-x", "2" });
	}

	/**
	 * Test process essay for non existant file.
	 */
	@Test(expected = RuntimeException.class)
	public void testProcessEssayForNonExistantFile() {
		this.averageSentenceLengthUnderTest.setInputFile(null);
		this.averageSentenceLengthUnderTest.processEssay();
	}

	/**
	 * Test get list of sentences in essay with test file name1 and test
	 * sentence delimiters1.
	 */
	@Test
	public void testGetListOfSentencesInEssayWithTestFileName1AndTestSentenceDelimiters1() {
		this.averageSentenceLengthUnderTest.setInputFile(new File(
				this.testFileName1));
		this.averageSentenceLengthUnderTest
				.setSentenceDelimiters(this.testSentenceDelimiters1);
		List<String> listOfSentencesInEssay = this.averageSentenceLengthUnderTest
				.getListOfSentencesInEssay();

		assertEquals(listOfSentencesInEssay.size(), 2);
		assertEquals(listOfSentencesInEssay.get(0), "a quick brown fox");
		assertEquals(listOfSentencesInEssay.get(1), "a dog");
	}

	/**
	 * Test get list of sentences in essay with test file name2 and test
	 * sentence delimiters1.
	 */
	@Test
	public void testGetListOfSentencesInEssayWithTestFileName2AndTestSentenceDelimiters1() {

		this.averageSentenceLengthUnderTest.setInputFile(new File(
				this.testFileName2));
		this.averageSentenceLengthUnderTest
				.setSentenceDelimiters(this.testSentenceDelimiters1);
		List<String> listOfSentencesInEssay = this.averageSentenceLengthUnderTest
				.getListOfSentencesInEssay();

		assertEquals(listOfSentencesInEssay.size(), 4);
		assertEquals(
				listOfSentencesInEssay.get(0),
				"This example shows that even for an engineer with years of experience in the field, the fundamentals of personal essay writing remain the same");
		assertEquals(
				listOfSentencesInEssay.get(1),
				"This statement opens with the engineer describing a formative experience—visiting a meat packaging plant as a teenager—that influenced the writer to work in the health and safety field");
		assertEquals(
				listOfSentencesInEssay.get(2),
				"Now, as the writer prepares to advance his education while remaining a full-time safety engineer, he proves that he is capable by detailing examples that show his record of personal and professional success");
		assertEquals(
				listOfSentencesInEssay.get(3),
				"Especially noteworthy is his partnering with a government agency to help protect workers from dust exposures, and he ties his extensive work experience directly to his goal of becoming a Certified Industrial Hygienist");

	}

	/**
	 * Test get list of sentences in essay with test file name3 and test
	 * sentence delimiters1.
	 */
	@Test
	public void testGetListOfSentencesInEssayWithTestFileName3AndTestSentenceDelimiters1() {
		this.averageSentenceLengthUnderTest.setInputFile(new File(
				this.testFileName3));
		this.averageSentenceLengthUnderTest
				.setSentenceDelimiters(this.testSentenceDelimiters1);

		List<String> listOfSentencesInEssay = this.averageSentenceLengthUnderTest
				.getListOfSentencesInEssay();

		assertEquals(listOfSentencesInEssay.size(), 15);
		assertEquals(
				listOfSentencesInEssay.get(0),
				"Growing up in Canada with a life-long fascination for Canadian geography, I have always been interested in returning to the country");
		assertEquals(listOfSentencesInEssay.get(7), "What else");
		assertEquals(listOfSentencesInEssay.get(12), "You talk about fun");
		assertEquals(
				listOfSentencesInEssay.get(14),
				"With my deep-rooted interest in Canadian geology and recognition of the quality of your university programs, I hope you will give my application every consideration");
	}

	/**
	 * Test get number of words that exceed threshold1.
	 */
	@Test
	public void testGetNumberOfWordsThatExceedThreshold1() {
		assertEquals(
				this.averageSentenceLengthUnderTest.getNumberOfWordsThatExceedThreshold(
						"word word", 2), 2);
	}

	/**
	 * Test get number of words that exceed threshold2.
	 */
	@Test
	public void testGetNumberOfWordsThatExceedThreshold2() {
		assertEquals(2,
				this.averageSentenceLengthUnderTest
						.getNumberOfWordsThatExceedThreshold("word word a", 2));
	}

	/**
	 * Test get number of words that exceed threshold with apostrophes.
	 */
	@Test
	public void testGetNumberOfWordsThatExceedThresholdWithApostrophes() {
		assertEquals(5,
				this.averageSentenceLengthUnderTest
						.getNumberOfWordsThatExceedThreshold(
								"word's that can't i'd word a", 2));
	}

	/**
	 * Test get number of words that exceed threshold with numbers.
	 */
	@Test
	public void testGetNumberOfWordsThatExceedThresholdWithNumbers() {
		assertEquals(
				3,
				this.averageSentenceLengthUnderTest
						.getNumberOfWordsThatExceedThreshold("word 139 word", 2));
	}

	/**
	 * Test with invalid sentence delimiter.
	 */
	@Test(expected = RuntimeException.class)
	public void testWithInvalidSentenceDelimiter() {
		averageSentenceLengthUnderTest.parseCommandLineArguments(new String[] {
				this.testFileName1, "-d", "$", "-l", "5" });
	}
}
