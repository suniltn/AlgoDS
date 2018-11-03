package com.chandra.structures.arraysANDstrings;


/**
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 * 
 * @author cgopalai
 * 
 * Tags : Sub String Matching
 *
 */
public class KMPSubString {
	
	
	/**
	 *  building a partial table is straight forward
	 * 	1. create an array of pattern length and always first value in array will be zero
	 *  2. Now initialize two indexes candidate(cnd)=0 and pos=1
	 *  3. Loop till the length of pattern using pos
	 *  4. compare value at pos and cnd in pattern and if mataches
	 *  	a. update array[pos] = cnd +1 (candidate index value + 1)
	 *  	b. move both cnd and pos
	 *  (what's happening here is that there's a suffix match for this prefix at position (cnd+1), that's
	 *  the value we are storing in array)
	 *  5. if values at pos and cnd in pattern doesn't match, then simply
	 *  	a. check if cnd value == 0 or not, if it's zero then move pos to next char in pat
	 *  	b. if not then retrieve value stored at cnd-1 index from array and assign it to cnd and 
	 *  	comparing with pos and cnd chars in pattern  
	 *  		- what's happening here is that there was a previous match of certain characters hence we skip
	 *  		- comparing those chars and start comparing from characters that weren't matched, this will be used later
	 *   
	 */
	
	private int[] buildPartialMatchTable(char[] pattern) {
		int[] partialMatchTable = new int[pattern.length]; // by default, all overlaps are zero

		
		
		int pos = 1;
		int cnd = 0;
		
		while(pos < pattern.length) {			// compute partialMatchTable[pos] during this pass, if nonzero
			if (pattern[pos] == pattern[cnd]) { 
				partialMatchTable[pos] = cnd + 1;
				cnd++;
				pos++;
			} else {
				if (cnd != 0) {
					cnd = partialMatchTable[cnd-1];
				} else {
					partialMatchTable[pos] = cnd;
					pos++;
				}
			}
		}
		return partialMatchTable;
	}
	
	/**
	 * 
	 * In KMP we will make use of precomputed table of pattern which tells how many mataches are there in pattern 
	 * which we use to skip comparing those many characters from string using the value stored at the index in table
	 * 
	 * Let's start by comparing char by char in both str and pat
	 * if match occurs then just move to next char in both str and pat by incrementing strIndex and patIndex
	 * if no match then there are two cases to be checked
	 * case a) if patIndex is pointing to beginning of the pat - then just increment strIndex
	 * case b) if patIndex is somewhere in the middle then retrieve the value of previous patindex from precomputed table
	 * and assign it to patIndex and continue the comparision
	 * 
	 *  once we reach the end of pat length or str length, loops exits.
	 *  
	 *  Check if loop exited because patIndex reached at the end of pattern, if yes then return the difference
	 *  of textIndex - patIndex which gives the starting index of substring in str
	 */
	public int patternSearch(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		if (m == 0) return 0;
		int[] table = buildPartialMatchTable(pattern);
		int textIndex = 0;
		int patternIndex = 0;
		while (textIndex< n && patternIndex < n) {
			if (text[textIndex] == pattern[patternIndex]) {
				if (patternIndex == m-1) return textIndex-m+1;
				textIndex++; patternIndex++;
			} else {
				if (patternIndex != 0) {
					patternIndex = table[patternIndex-1];
				} else {
					textIndex++;
				}
			}
		}
		return text.length;
	}
	
	public static void main(String[] args) {
		String txt = "ggccgggccctgtgaccacagtccacatcacaccaggacacagaggaagggccgggccctgtgaccacagtccacatcacaccaggacacagaggaagggccgggcctcatgaccacagt";
		String pattern = "gtccacatcaca";
		KMPSubString kmp = new KMPSubString();
		
		long startTime = System.nanoTime();
		int result = kmp.patternSearch(txt.toCharArray(), pattern.toCharArray());
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
