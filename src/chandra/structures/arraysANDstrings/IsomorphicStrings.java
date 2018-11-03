package com.chandra.structures.arraysANDstrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) return false;
		
		Map<Character, Character> map = new HashMap<>();
		
		for (int i=0;i<s.length();i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			if (map.containsKey(c1)) {
				if (map.get(c1) != c2)
					return false;
			} else {
				if (map.containsKey(c2)) return false;
				
				map.put(c1, c2);
			}
		}
		
		return true;
				
	}
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
	}
}
