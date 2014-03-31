# Requirements Document – Team 11

## Versions

<ul>
<li>
Version 1.0 Final Draft
</li>
<li>
Version 1.1 Fixed minor typos.
</li>
<li>
Version 1.2 Corrected a requirement.
</li>
</ul>

## 1 Introduction

The purpose of this project is to develop a software tool which tell the user the average number of words per sentence in an essay. The software is called <i>AverageSentenceLength</i>.  Its input is the path of a raw text file containing the essay to be analyzed.  It can also accept an optional list of characters used to demarcate sentence boundaries as well as the minimum number of letters a word must contain before it is counted to compute the average.  Defaults exist for both of these optional arguments.  The software will be simple, cross-platform, and user friendly.

## 2 User Requirements

### 2.1 Software Interfaces
The application will be written in Java to easily enable cross-platform use.  The application itself will have no dependencies beyond the 1.6 JDK for compilation and JRE 1.6 for execution.  Unit tests however will use the widely available open source unit testing framework Junit.  

### 2.2 User Interfaces
There will be no graphical user interface, this application will be used via a command line interface.  Parameters such as file path, sentence delimiters, and minimum word length in letters will be specified by users on the command line.  The file path is a required argument while sentence delimiters and the minimum word length in letters are optional.  

### 2.3 User Characteristics

Our client is a teacher at a local school who wants her students to write essays with shorter sentences.  She has asked us to write her an application that enables students to easily analyze their essays' sentence lengths by average number words per sentence.  She teaches six sections of forty-five students each for a total of 270 students.  Students can be technical or non-technical with varied educational backgrounds.  Therefore user documentation and friendly error and instructional messages from the application are required.

### 2.4 Assumptions and Dependencies

<ol>
<li>Users have a 1.6 or higher version JRE installed on their machines.</li>
<li>Users can open a command line interface on their machines and use it to execute Java.</li>
<li>Users can read and understand user friendly instructional and error messages from the application.</li>
<li>Users are able to provide the path of a valid raw text file to the application.</li>
<li>The raw text file to be processed contains at least one sentence with at least one word in it.</li>
<li>Users understand the English language.</li>
</ol>

### 2.5 System Requirements


<ol>
<li>The application must run on multiple platforms (Windows, OSX, Unix, etc).</li>
<li>The application must not depend on any Java libraries other than those in JRE 1.6.</li>
<li>It must be possible to compile the application's source using Javac without any arguments.</li>
<li>The program must be able to handle raw text files because that is the format that students submit their essays in.</li>
<li>Sentence delimiters must be configurable at run-time.</li>
<li>All possible sentence delimiters are limited to periods, question marks, exclamation points, semi-colons, commas, and colons.</li>
<li>If not specified at run-time, sentences are delimited by periods, question marks, and exclamation points.</li>
<li>The mimimum number of letters in a word to count it toward the average must be configurable at run-time.</li>
<li>The range of acceptable letter minimums for words is from zero to infinity.</li>
<li>If not specified at run-time, the letter minimum for words default is 3 or more letters.</li>
<li>Apostrophes and both n-dashes and m-dashes count as one letter.</li>
<li>The application must provide friendly instructional and error messages to the user.</li>
<li>The application need not account for periods in abbreviations, e.g. Dr., Mr., Ph.D. etc.</li>
<li>The application must ouput the average number of words that equal or exceed the letter minimum per sentence as specified by the default or optionally supplied delimiters rounded down to the nearest integer.</li>
</ol>


## 3 Functional Requirements

### 3.1 Non-Functional Requirements

#### 3.2.1 Software Quality Attributes

The application must display user-friendly error and instructional messages.  If an error occurs while processing an essay, the application must not simply fail but rather attempt to recover and display a useful, user-friendly message to the user.

Once the software has been developed, it should be tested in all environments (i.e. operating systems).  As this is a simple program with no external dependencies, no future support or code work is required after the system has been varified to work properly. 




