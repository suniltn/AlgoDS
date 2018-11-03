package com.chandra.structures.arraysANDstrings;

import java.util.HashSet;

public class StringPermutations {
	public static HashSet<String> getPermutations(String str) {
		HashSet<String> perms = new HashSet<>();
		
		// Base Condition
		if (str == null || str.length() == 0) { 
			perms.add(" ");
			return perms;
		}
		
		
		// General condition
		char first = str.charAt(0);
		String remaining = str.substring(1);
		HashSet<String> words = getPermutations(remaining);
		System.out.println("First : " + first);
		// Permuting happens here
		for (String word : words) {
			System.out.print("Word : " + word);
			for (int i=0;i<word.length();i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i);
				perms.add(prefix + first + suffix);
				System.out.println(prefix + " " + first + " " + suffix);
			}
		}
		
		return perms;
	}
	
	public static HashSet<String> getPems(String[] array, int start, int end) {
		HashSet<String> perms = new HashSet<>();
		
		// Base condition
		if (array == null || end-start == 0) {
			perms.add(" ");
			return perms;
		}
		
		//General condition
		String first = array[start];
		HashSet<String> words = getPems(array, start+1, end);
		for (String word : words) {
			
			
		}
		
		return perms;
	}

	public static void main(String[] args) {
		String str = "abc";
		HashSet<String> perms = getPermutations(str);
		System.out.println("Result");
		for (String word : perms) {
			System.out.println(word);
		}
	}
}
