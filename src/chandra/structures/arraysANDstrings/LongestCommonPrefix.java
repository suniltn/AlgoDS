package com.chandra.structures.arraysANDstrings;

public class LongestCommonPrefix {
	/**
	Step1: Find the smallest string in the array of strings since longest common prefix cannot go
	beyond the smallest string in the array of strings
	Step2: Loop through all the array of strings checking for prefix in every string in the array.
	a) If a string doesn't contain the prefix then remove last character and check again till you find a
	prefix in the string 
	since this will be the longest common prefix for all strings
	*/
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        String prefix = strs[0];
        int minLen = strs[0].length();
        for(String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
                prefix = str;
                System.out.println(prefix); 
               
            }
        }
        
        for (String str : strs) {
            while (!prefix.equals(str.substring(0, prefix.length())) && !prefix.equals(""))
                prefix = prefix.substring(0, prefix.length()-1);
        }
        return prefix;
    }
	
	public static void main(String[] args) {
		String[] strs = {"c", "c"};
		System.out.println(longestCommonPrefix(strs));
	}
}
