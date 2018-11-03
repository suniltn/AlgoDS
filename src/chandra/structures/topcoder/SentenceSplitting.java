package com.chandra.structures.topcoder;

/**
Problem Statement
You have a sentence written entirely in a single row. You would like to split it into several rows by replacing some of the spaces with "new row" indicators. Your goal is to minimize the width of the longest row in the resulting text ("new row" indicators do not count towards the width of a row). You may replace at most K spaces.

You will be given a sentence and an K. Split the sentence using the procedure described above and return the width of the longest row.

Definition
Class: SentenceSplitting
Method: split
Parameters: String, int
Returns: int
Method signature: int split(String sentence, int K)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- sentence will contain between 1 and 50 characters, inclusive.
- sentence will consist of only letters ('a'-'z', 'A'-'Z') and spaces (' ').
- Each space character in sentence will be between two letters.
- K will be between 1 and 50, inclusive.
Examples
0)
"This is a test sentence"
1
Returns: 13
You should split the sentence between the words "a" and "test".
1)
"TheOnlyWord"
37
Returns: 11
2)
"One veeeeeeeeeeeeeeeeeeery long word"
2
Returns: 22
3)
"Each tournament round is an elimination round"
3
Returns: 15

*/
public class SentenceSplitting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
