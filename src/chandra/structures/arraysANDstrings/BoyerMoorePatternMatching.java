package com.chandra.structures.arraysANDstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author cgopalai
 * 
 * Reads in two strings, the pattern and the input text, and
 *  searches for the pattern in the input text using the
 *  bad-character rule part of the Boyer-Moore algorithm.
 *  (does not implement the strong good suffix rule)
 *
 */


/**
 *  The <tt>BoyerMoore</tt> class finds the first occurrence of a pattern string
 *  in a text string.
 *  <p>
 *  This implementation uses the Boyer-Moore algorithm (with the bad-character
 *  rule, but not the strong good suffix rule).
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/53substring">Section 5.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */

public class BoyerMoorePatternMatching {
	private int[] right;
	
	/**
	 * Constructor sets up the right array assuming it's unicode characters length and set -1 to each element
	 * array
	 */
	public BoyerMoorePatternMatching() {
		int unicodeLenght = 256;
		right = new int[256];
		
		for (int i=0;i<unicodeLenght;i++)
			right[i] = -1;
	}
	
	/**
	 * This function updates the right array for each and every char in pattern along with the position of it's
	 * occurance.
	 */
	
	private void badCharacters(char[] pattern) {
		for (int i=0;i<pattern.length;i++)
			right[pattern[i]] = i;
	}
	
	/**
	 * 
	 * This search method starts comparing the pattern with text from right side of pattern. Whenever a char 
	 * mismatch happens then it takes the char from text and checks for it's corresponding occurance value in
	 * right array computed in badCharacters functions. That value is subtracted from position of same char in 
	 * pattern. Taking a max of 1 or computed value will be the skip length for comparison which is used by
	 * main for loop to skip comparison and reset skip to zero and continue until match is found.
	 */
	private int search(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		
		if (m == 0) return 0; // trivial search for empty string
		
		//badCharacters(pattern);
		
		
		int skip;
		for (int i=0;i<=(n-m);i+=skip) {
			skip=0;
			
			int j;
			for (j=m-1;j>=0;j--) {
				if (pattern[j] != text[i+j]) {
					skip = Math.max(1, j - right[text[i+j]]);
					break;
				}
			}
			if (skip==0) return i;
		}
		return n;
	}
	
	private int search1(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		
		if (m == 0) return 0; 							// trivial search for empty string
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i=0;i<n;i++)
			map.put(text[i], -1); 						// set −1 as default for all text characters
		for (int i=0;i<m;i++)
			map.put(pattern[i], i);  					// rightmost occurrence in pattern is last
		
		// start with the end of the pattern aligned at index m−1 of the text
		int i = m-1;  									// an index into the text
		int k = m-1;  									// an index into the pattern
		while (i<n) {
			if (text[i] == pattern[k]) {				// a matching character
				if (k==0) return i;						// entire pattern has been found
				i--;									// otherwise, examine previous
				k--;									// characters of text/pattern
			} else {
				// this line needs more understanding
				i += m - Math.min(k, 1 + map.get(text[i])); // case analysis for jump step
				k = m-1;									// restart at end of pattern
			}
		}
		return -1;											// pattern was never found
		
	}
	
	public static void main(String[] args) {
		String txt = "abacadabrabracabracadabrabrabracad";
		String pattern = "abracadabra";
		
		BoyerMoorePatternMatching bms = new BoyerMoorePatternMatching();
		
		long startTime = System.nanoTime();
		int result = bms.search1(txt.toCharArray(), pattern.toCharArray());
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Total Elapsed Time : " + duration);
		System.out.println("text:    " + txt);
		System.out.print("pattern: ");
		for (int i=0;i<result;i++)
			System.out.print(" ");
		System.out.println(pattern);
	}
}
