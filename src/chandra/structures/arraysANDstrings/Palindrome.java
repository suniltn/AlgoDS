package com.chandra.structures.arraysANDstrings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * Reference : https://leetcode.com/problems/valid-palindrome/
 */

public class Palindrome {

	public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isAlphaNumeric(s.charAt(start)))
                start++;
            else if (!isAlphaNumeric(s.charAt(end)))
                end--;
            else {
                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--)))
                    return false;
            }
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
		Palindrome pali = new Palindrome();
		
		System.out.println(pali.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(pali.isPalindrome("race a car"));
	}
	
}
