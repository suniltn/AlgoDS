package com.chandra.structures.arraysANDstrings;

public class StringPermutationCheck {
	public static boolean isPermute(String s, String t) {
		
		if (s == null || t == null || s.length() != t.length()) return false;
		
		int sChecker = 0;
		int tChecker = 0;
		
		for (int i=0;i<s.length();i++) {
			sChecker |= 1 << (s.charAt(i) - 'a');
			tChecker |= 1 << (t.charAt(i) - 'a');
		}
		
		if (sChecker != tChecker) return false;
		return true;
	}
	
	public static void main(String[] args) {
		String s = "abcdef";
		String t = "bcafed";
		
		System.out.println(isPermute(s, t));
	}
}
