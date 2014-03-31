# Test Plan Document – Team 11

## 0 Versions

<ul>
<li>
Version 1.0 Final Draft
</li>
<li>
Version 1.1 Fixed minor typos.
</li>
<li>
Version 1.2 Updated with test execution results.
</li>
</ul>

## 1 Introduction
The name of this product is Average Sentence Length. The purpose of this program is to calculate the average length of sentences in an essay submitted by a student. The program will have options to allow the user to designate the minimum word length and what constitutes the ending of a sentence. 

## 2 Quality Control

### 2.1 Test Plan Quality
The test plan is going to be designed to test input errors by the user. The program will also have unit tests to test the code coverage and calculations. The testing will be rigorous enough to catch any unexpected events outside of the assumptions made by the design.

### 2.2 Adequacy Criterion
As this program is very small we should be able to cover 100% functional and structural testing and pass all criteria.

### 2.3 Bug Tracking
The product after testing and delivery will not be delivered to production and therefore bug tracking and enhancements are not possible. 

## 3 Test Strategy
The unit testing will be written by the developer in such a way as to test the code coverage in the program. The test lead will write test cases for manual command line testing to replicate the actions of the user.
### 3.1 Testing Process
The developer will write JUnit test cases.
The tester will test manual test cases for functional testing and catching user errors.

### 3.2 Technology
JUnit testing was used by the developer. 

## 4 Test Cases

<table>
<tbody>
	<tr>
		<td><b>TEST CASE</b></td>
		<td><b>PURPOSE</b></td>
		<td><b>STEPS</b></td>
		<td><b>EXPECTED RESULT</b></td>
		<td><b>ACTUAL RESULT</b></td>
		<td><b>PASS/FAIL</b></td>
	</tr>
	<tr>
		<td>Instructor provided execution statement</td>
		<td>To test the bare minimum success to pass</td>
		<td>Run the command "java AverageSentenceLength input.txt -d "." -l 2</td>
		<td>Average sentence length of 2</td>
		<td>With sentences delimited by . the average number of words per sentence in the file "input.txt" with 2 or more letters is 2.</td>
		<td>PASS</td>
	</tr>
	<tr>
		<td>Default delimiters</td>
		<td>To test the default delimiters</td>
		<td>Run the command with out a -d option</td>
		<td>Sentence length with default ". ? ! ;" </td>
		<td>With sentences delimited by .?! the average number of words per sentence in the file "input.txt" with 3 or more letters is 2.</td>
		<td>PASS</td>
	</tr>
	<tr>
		<td>Default Word length</td>
		<td>To test the default word length</td>
		<td>Run the command without a -l option</td>
		<td>Sentence length with default word length 4</td>
		<td>With sentences delimited by . the average number of words per sentence in the file "input.txt" with 3 or more letters is 2.</td>
		<td>PASS</td>
	</tr>
	<tr>
		<td>Incorrect file name </td>
		<td>To test the error message when the file name is incorrect or the file does not exist</td>
		<td>Run the command with an incorrect file name</td>
		<td>Error Message</td>
		<td>An error occurred processing the essay. Input file "inpt.txt" not found!</td>
		<td>PASS</td>
	</tr>
	<tr>
		<td>Incorrect delimiter options</td>
		<td>To test the incorrect delimiter options error catching</td>
		<td>Run the command with an incorrect delimiter "$"</td>
		<td>Error Message</td>
		<td>An error occurred processing the essay. Invalid sentence delimiter argument: Acceptable sentence delimiters are .?!;:,</td>
		<td>PASS</td>
	</tr>
	<tr>
		<td>Word Length option not an integer</td>
		<td>To test the incorrect usage of word length option</td>
		<td>Run command with -l option A</td>
		<td>Error Message</td>
		<td>An error occurred processing the essay. Invalid word length threshold: Word length threshold must be a positive whole number greater than 0, for example: 1, 2, 3, 4, 5, ... 12, ....</td>
		<td>PASS</td>
	</tr>

</tbody>
</table>
