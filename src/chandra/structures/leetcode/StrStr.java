package com.chandra.structures.leetcode;

public class StrStr {
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (haystack.equals(needle) || ("").equals(needle)) return 0;
		if (haystack.length() < needle.length() || ("").equals(haystack)) return -1;
		
		
		int n = haystack.length();
		int m = needle.length();
		
		for (int i=0;i<=(n-m);i++) {
			int j=0, backupI = i;
			while (j < m) {
				if (haystack.charAt(backupI) != needle.charAt(j))
					break;
				else {
					j++;
					backupI++;
				}
			}
			if (j == m) return i;
		}
		return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(strStr("c", ""));
	}
}
