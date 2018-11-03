package com.chandra.structures.dynamic;

import java.util.Arrays;

public class LongestCommonSubstring {

	// first we need to determine the 2D array with all common characters
	
	private int[][] lcs(String str1, String str2) {
		char[] text1 = str1.toCharArray();
		char[] text2 = str2.toCharArray();
		
		int n = text1.length;
		int m = text2.length;
		
		int[][] L = new int[n+1][m+1];
		
		for (int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if (text1[i-1] == text2[j-1])			// align the match
					L[i][j] = 1 + L[i-1][j-1];
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}
		
		return L;
	}
	
	//this function returns the longest common substring with the help of longest common subsequence 2D
	// array filling function.
	// We then reverse construct the string start from right most element in 2D which has the longest
	// common subsequence count
	public char[] longestCommonSubstring(String str1, String str2) {
		StringBuilder builder = new StringBuilder();
		
		int i = str1.length();
		int j = str2.length();
		
		int[][] L = lcs(str1, str2);
		
		while (L[i][j] > 0) {
			if (str1.charAt(i-1) == str2.charAt(j-1)) { // if there's a match
				builder.append(str1.charAt(i-1));
				i--;
				j--;
			} else if (L[i-1][j] >= L[i][j-1])
				i--;
			else
				j--;
		}
		
		return builder.reverse().toString().toCharArray();
	}
	
	public static int lcs_1(String s1, String s2) {
		int[][] lcs = new int[s1.length()+1][s2.length()+1];
		
		int result = Integer.MIN_VALUE;
		for (int i=1;i<=s1.length();i++) {
			for (int j=1;j<=s2.length();j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs[i][j] = 1+lcs[i-1][j-1];
					result = Math.max(result, lcs[i][j]);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String str1 = "chandra";
        String str2 = "chaitra";
        LongestCommonSubstring sstring = new LongestCommonSubstring();
        System.out.println(Arrays.toString(sstring.longestCommonSubstring(str1, str2)));
        System.out.println(lcs_1(str1, str2));
	}

}
