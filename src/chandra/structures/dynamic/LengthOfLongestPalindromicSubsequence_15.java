package com.chandra.structures.dynamic;


/// http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
public class LengthOfLongestPalindromicSubsequence_15 {
	// Top Down - Optimal Substructure 
	
	public static int findPalindrome(String A, int i, int j){
		
		// Base Case 1: If there is only 1 character
		if (i == j) return 1;
		
		// Base Case 2: If there are only 2 characters and both are same
		if (A.charAt(i) == A.charAt(j) && i+1 == j) return 2;
		
		// If the first and last characters match
		if (A.charAt(i) == A.charAt(j))
			return 2 + findPalindrome(A, i+1, j-1);
		
		// If the first and last characters do not match
		return Math.max(findPalindrome(A, i, j-1), findPalindrome(A, i+1, j));
	}
	
	// Bottom Up - Overlapping Subproblems
	public static int lps(String A) {
		int len = A.length();
		
		int[][] lps = new int[len][len];
		
		// Strings of length 1 are palindrome of lentgh 1
		for (int i=0;i<len;i++)
			lps[i][i] = 1;
		
		// Build the table. Note that the lower diagonal values of table are
	    // useless and not filled in the process.
		for (int sublen=2;sublen<=len;sublen++) {
			for (int i=0;i<len-sublen+1;i++) {
				int j = i+sublen-1;
				// if there are only two characters and both are same
				if (A.charAt(i) == A.charAt(j) && sublen == 2)
					lps[i][j] = 2;
				
				// if first and last character matches then add 2 to previous subproblem
				else if (A.charAt(i) == A.charAt(j))
					lps[i][j] = 2 + lps[i+1][j-1];
				
				else
					lps[i][j] = Math.max(lps[i][j-1], lps[i+1][j]);
			}
		}
		
		return lps[0][len-1];
	}
	
	public static void main(String[] args) {
		String s = "GEEKSFORGEEKS";
		long startTime = System.currentTimeMillis();
		System.out.println("Top Down - LPS : " + findPalindrome(s, 0, s.length()-1));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Top Down - Time Taken(ms): " + elapsedTime);
		startTime = System.currentTimeMillis();
		System.out.println("Bottwom Up - LPS : "+ lps(s));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Bottom Up- Time Taken(ms): " + elapsedTime);
	}
	
}
