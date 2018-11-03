package com.chandra.structures.dynamic;

/**
 * wildcard pattern matching with support for '?' and '*'
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * @author cgopalai
 * Reference : https://leetcode.com/problems/wildcard-matching/
 * 
 * Tags : Dynamic Programming
 */

/**
 * https://discuss.leetcode.com/topic/55218/java-dp-solution-ac-with-explanation
For i in s and j in p
1. If p.charAt(j-1) == '*'
	dp[i][j] = dp[i][j-1]   // * is empty
	       or  dp[i-1][j-1] // * is a single character 
	       or  dp[i-1][j]   // * spans multiple characters
2. If p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'
	dp[i][j] = dp[i-1][j-1]
*/			
public class WildCardMatching {
	
	// in this match function we are removing extra *'s from pattern
	public boolean isMatch(String s, String p) {
		char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        
        
        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        boolean isFirstOccurance = true;
        int overWriteIndex = 0;
        for (int i=0;i<pat.length;i++) {
            if (pat[i] == '*') {
                if (isFirstOccurance) {
                    pat[overWriteIndex++] = pat[i];
                    isFirstOccurance = false;
                }
                
            } else {
                pat[overWriteIndex++] = pat[i];
                isFirstOccurance = true;
            }
        }
    
    
        int strLength = str.length;
        int patLength = overWriteIndex;
    
        // Include one extra row and column to support null character
        boolean dp[][] = new boolean[strLength+1][patLength+1];
        dp[0][0] = true;
    
        // the only time second item in row 0 would be true if the first character in pattern is *
        if (patLength > 0 && pat[0] == '*') dp[0][1] = true;
    
        for (int i=1;i<=strLength;i++) {
            for (int j=1;j<=patLength;j++) {
            	// if string char and pattern char matches or if pattern char is ? then check for previous
            	// chars matching which can be retrieved from checking value of element diagonally above
            	// current index's
                if (str[i-1] == pat[j-1] || pat[j-1] == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if (pat[j-1] == '*')
                // if pattern char is *, then there are two cases, one with no char in str or with char in string
                	// hence we need to check value of left element of the current index or value of the element
                	// above the current index i.e char's before i.e if no element present for pat char in string
                	// char then check for previous chars matching value in element left of index i.
                	// If str char is present for pat char then check for value of element above the current index i
                	//
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
            }
        }
    
        // the right most or last element of 2D array will have final result
        return dp[strLength][patLength];
    
    }
	
	// in this match we are not removing any duplicate *'s from pattern
	public boolean isMatch1(String s, String p) {
		
		char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        
        int strLength = str.length;
        int patLength = pat.length;
    
        // Include one extra row and column to support null character
        boolean dp[][] = new boolean[strLength+1][patLength+1];
    
        // empty pattern can match with empty string
        dp[0][0] = true;
        
        // Only '*' can match with empty string
        for (int j=1;j<=patLength;j++) {
        	if (pat[j-1] == '*')
        		dp[0][j] = dp[0][j-1];
        }
        
        // fill the table in bottom-up fashion
        for (int i=1;i<=strLength;i++) {
        	for (int j=1;j<=patLength;j++) {
        		// Two cases if we see a '*'
                // a) We ignore ‘*’ character and move
                //    to next  character in the pattern,
                //     i.e., ‘*’ indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
        		if (pat[j-1] == '*') 
        			dp[i][j] = dp[i][j-1] || dp[i][j-1];
        		
        		// Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
        		else if (str[j-1] == pat[j-1] || pat[j-1] == '?')
        			dp[i][j] = dp[i-1][j-1];
        	}
        }
        
        return dp[strLength][patLength];
	}
	
	
	
	public static void main(String[] args) {
		WildCardMatching match = new WildCardMatching();
		System.out.println("Matched : " + match.isMatch("xbylmz", "x?y*z"));
		System.out.println("Matched : " + match.isMatch1("baaabab", "*a***ab"));
	}
}
