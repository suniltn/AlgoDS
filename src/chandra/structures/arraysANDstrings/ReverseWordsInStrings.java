package com.chandra.structures.arraysANDstrings;

public class ReverseWordsInStrings {
	public static String reverseWords(char[] s) {
		int i = 0;
		// Below for loop reverses all words in place except last word since there's no trailing white space
		for (int j=0;j<s.length;j++) {
			if (s[j] == ' ') {
				reverse(s, i, j-1);
				i=j+1;
			}
		}
		// this reverse is just to reverse the last word
		reverse(s, i, s.length-1);
		
		// now reverse the entire string which will get back to string with words reversed instead of
		// letters
		reverse(s, 0, s.length-1);
		return String.valueOf(s);
	}
	
	private static void reverse(char[] s, int i, int j) {
		while(i<j) {
			char temp = s[i];
			s[i]=s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		String str = " ";
		
		System.out.println(reverseWords(str.toCharArray()));
	}
}
