package com.chandra.structures.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	
	// Simple BFS without queue
	public static List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        
        list.add("");
        for (int i=0;i<digits.length();i++) {
        	char c = digits.charAt(i);
        	String chars = letters[c - '0'];
        	int size = list.size();
        	int k =0;
        	while (k<size) {
        		String tmp = list.remove(0);
        		for (int j=0;j<chars.length();j++) {
        			list.add(tmp + chars.charAt(j));
        		}
        		k++;
        	}
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("234").toString());
	}
}
