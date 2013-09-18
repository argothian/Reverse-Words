9/16/2013
Coding practice from google code jam.

Link to the problem description:
https://code.google.com/codejam/contest/351101/dashboard#s=p1


Brief description:
Reverse the sentence in reverse word order. First line indicates the number of the inputs. Result must be numbered with test cases, sample input, output:

Input 			Output 
3
this is a test		Case #1: test a is this
foobar			Case #2: foobar
all your base		Case #3: base your all


Approach:
Read each line by using scanner which automatically break the words by space, store each word in stack. When write the result to a file poping the stack give the reverse words.


There are currently two implementation:
ReverseWord:
The program first read the file and creates an array of stack string. After reading and putting all the words into the stack array, run a for loop to pop the stack and write to an output file.

Producer Consumer Pattern:
Implement multithreading, divide the process into two threads. Producer read and push the word onto a stack, the consumer pop the stack and write to a file. The stack is put into a queue that is share by the two threads.


Result:
Using the producer consumer pattern doesn't decrease the time. Maybe by creating a process thread in between the reader and writer would decrease the time, if the process takes a lot of works.