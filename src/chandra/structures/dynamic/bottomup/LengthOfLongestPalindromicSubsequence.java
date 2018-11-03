package com.chandra.structures.dynamic.bottomup;

public class LengthOfLongestPalindromicSubsequence {
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
		System.out.println("Length of Longest Palindrome Subsequence : " + lps(s));
	}
}
