package com.chandra.structures.dynamic.topdown;

public class LengthOfLongestPalindromicSubsequence {
	
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
	
	public static void main(String[] args) {
		String s = "GEEKSFORGEEKS";
		System.out.println("Length of Longest Palindrome Subsequence : " + findPalindrome(s, 0, s.length()-1));
	}
}
