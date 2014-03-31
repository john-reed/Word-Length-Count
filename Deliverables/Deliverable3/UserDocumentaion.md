# User Documentaion

<ul>
<li>
Version 1.0 Final Draft
</li>
<li>
Version 1.1 Added documentation for invalid delimiter defect.
</li>
</ul>

<ul>
<li>
This program is executed as: 'java AverageSentenceLength &lt;filename&gt; -d "&lt;comma separated list of sentence delimiters&gt;" -l &lt;integer&gt;'
</li>
<li>
Supported sentence delimiters are '.' (period), '?' (question mark), '!' (exclamation mark), ',' (comma), ';' (semi-colon), and ':' (colon).
</li>
<li>
Word length threshold must be a positive whole number greater than 0, i.e. 1, 2, 3, 4, 5, ... 12, ....
</li>
<li>
An example execution could be: 'java AverageSentenceLength my_essay.txt -d ".,?,!" -l 5'
</li>
<li>
Both the sentence delimiter and word length threshold arguments are optional.
</li>
<li>
If a sentence delimiter argument is not supplied, then the default sentence delimiters of '.' (period), '?' (question mark), and '!' (exclamation mark) are used.
</li>
<li>
If a word length threshold argument is not supplied then a default value of 3 is used.
</li>
<li>
For example 'java AverageSentenceLength my_essay.txt' is the same as 'java AverageSentenceLength my_essay.txt -d ".?!" -l 3'
</li>
</ul>
