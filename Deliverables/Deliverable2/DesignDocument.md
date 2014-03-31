# Design Document – Team 11
## 1 Introduction
The name of this product is Average Sentence Length. The purpose of this program is to calculate the average length of sentences in an essay submitted by a student. The program will have options to allow the user to designate the minimum word length and what constitutes the ending of a sentence. 

## 2 Design Considerations
The following issues will be considered for the program:
<ul>
	<li>1. The program needs to run on multiple operating systems without errors.</li>
	<li>2. The inputs in the command line when running the program need to be parsed correctly by the program.</li>
	<li>3. The program needs rugged error control for non technical users.</li>
	<li>4. Only simple text essay files will be used for the input files.</li>
</ul>

### 2.1 Assumptions
<ul>
	<li>The first assumption is that using Java will enable the program to run on any operating system. </li>
	<li> The second assumption is that the input file is a simple text file. </li>
	<li>The third assumption is that the users could have very low technical skills. </li>
	<li>The fourth assumption is that the text file only includes an essay, meaning it is comprised of normal sentences in an expected pattern.</li>
</ul>
### 2.2 Constraints
The main constraints on the system are having to input from and output to a command line. The main constraint caused by this limit is that error messages are required to have the user type the correct command and outputting is restricted to the formatting of a command window.


### 2.3 System Environment
The program should be usable on any personal computer with a standard operating system including Windows, iOS, or Linux. The input file must be in a .txt format and in standard essay format.

## 3 Architectural Design
The high level design is a simple input/output system as this is simply a command line program with an input and an output. 

### 3.1 Overview
Input - Gets the file name and arguments.
Process - Calculates the average sentence length in the file.
Output - Outputs the calculation to the command window.

### 3.2 Rationale
It does not make sense to have any type of complicated or complex architectural system for this program and most high level designs do not fit this system.

### 3.3 Conceptual (or Logical) View
The system starts with an input from the command line containing the file name and the options requested. It passes this information to a method that counts the average length of a sentence. This information is then passed back to the command line on the output side of the system.

#### 4 Low Level Design
1. Subsection one includes a command line read and parse system to get the correct file name and options from the user.
2. The next subsection includes an input file reader to access the file to read the essay into the program.
3. The last subsection will calculate the average sentence length based on either the default options or the options from the user and output the results to the command window.

### 4.1 Class Diagram
There is only one main class with a few methods to do the calculations. No other classes are required for this program.

### 4.2 Sequence Diagram
![](http://i.imgur.com/EpMiIDT.png)
### 4.3 Component Diagram
The system only interacts with one outside element which is the text file and this does not require a diagram.

## 5 User Interface Design
This is a command line program that limits the User interface to the input command that runs the program, error messages if the initial command is incorrect, and an output to the command line simply containing the results of the program. 

