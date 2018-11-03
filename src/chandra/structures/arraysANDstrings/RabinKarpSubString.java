package com.chandra.structures.arraysANDstrings;

/**
 * 
 * * Rabin Karp algorithm for substring matching.
 *
 * Time complexity in worst case O(n^2)(depends on hash function)
 * Space complexity O(1)
 *
 * References
 * https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm

 * If hash function chosen is bad enough that it generates same hash for each and every pattern in string
 * in which case the worst case time complexity is O(mn) 
 *
 *m = length of pattern
 *
 *Applications include :1.  Finding plagiarism -
 *Steps 1. Generate Hash of all the documents
 *Steps 2. Take documents who hash matches and then continue matching the content of the document with each other
 *
 *2. When you have multiple patterns of the same length, just generate hash of each patterns and store it
 *then compare the hash generated from substrings of text and compare
 */

public class RabinKarpSubString {

	private static final int PRIME = 101;
	
	public int patternSearch(char[] text, char[] pattern) {
		
		int n = text.length;
		int m = pattern.length;
		
		long textHash = createHash(text, m-1);
		long patHash = createHash(pattern, m-1);
		
		/**
		 * we will generate hash of different text pattern based on provided pattern length. We go till
		 * the last possible pattern is possible from given text and that is determined by
		 * textLength - patternLength + 1
		 */
		for (int i=1;i<=n-m+1;i++) {
			if (textHash == patHash && checkEquality(text, i-1, i+m-2, pattern, 0, m-1))
				return i-1;
			// it's good to check if i is still in range like i<n-m+1
			textHash = recalculateHash(text, i-1, i+m-1, textHash, m);
		}
		
		return n;	// just for nice formatting out returning length of string, if not will return -1
		
	}
	
	
	/**
	 * 
	 * the way hash is generated is 
	 * sum of previous hash + ASCII value of character multiplied by power of (prime number to position of char in str)
	 * since it's happening in a loop we are finding hash to every single character and adding hence we need to
	 * sum previous hash with new char hash value
	 * 
	 * 
	 * hash = firstChar*pow(prime,0) + secondChar*pow(prime,1)+thirdChar*pow(prime,2) etc
	 */
	private long createHash(char[] str, int end) {
		long hash = 0;
		for (int i=0;i<=end;i++) {
			hash += str[i]*Math.pow(PRIME, i);
		}
		return hash;
	}
	
	private boolean checkEquality(char[] text, int textStart, int textEnd, char[] pattern, int patStart, int patEnd) {
		if (textEnd - textStart != patEnd - patStart)
			return false;
		
		while (textStart <= textEnd && patStart <= patEnd) {
			if(text[textStart] != pattern[patStart])
				return false;
			textStart++; 
			patStart++;
		}
		return true;
	}
	
	/**
	 * 
	 * Rolling Hash Steps
	 *1. X = oldHash - value(OldChar) => removing firstChar from hash
	 *2. X = X/prime => reducing the expression to like first half of next pattern chars
	 *3. newhash = X + pow(prime, m-1) * value(newChar) => include the new char and generate hash
	 */
	private long recalculateHash(char[] text, int oldIndex, int newIndex, long oldHash, int patLength) {
		long newHash = oldHash - text[oldIndex];
		newHash = newHash/PRIME;
		newHash += text[newIndex]*Math.pow(PRIME, patLength-1);
		return newHash;
		
	}
	
	public static void main(String[] args) {
		RabinKarpSubString rks = new RabinKarpSubString();
		//String txt = "abacadabrabracabracadabrabrabracad";
		//String pattern = "abracadabra";
		//String txt = "abc";
		//String pattern = "bc";
		String txt = "ggccgggccctgtgaccacagtccacatcacaccaggacacagaggaagggccgggccctgtgaccacagtccacatcacaccaggacacagaggaagggccgggcctcatgaccacagt";
		String pattern = "gtccacatcaca";
		
		long startTime = System.nanoTime();
		int result = rks.patternSearch(txt.toCharArray(), pattern.toCharArray());
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
