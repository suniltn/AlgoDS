package com.chandra.structures.dynamic;

import java.util.HashMap;

//http://algorithms.tutorialhorizon.com/dynamic-programming-split-the-string-into-minimum-number-of-palindromes/
public class SplitPalindrome_18 {
	static HashMap<String, Integer> solutions = new HashMap<>();
	
	
	// Here we are using top-down approach in DP meaning we compute results for smaller problems and store the result for future use
	//Time Com­plex­ity will be num­ber of sub prob­lems so it will O(N2).
	public static int splitDP(String s) {
		
		// if string is empty or if it's a palindrome then we don't need to split the string to find a palindrome strings
		if (s == "" || isPalindrome(s))
			return 0;
		else {
			int cuts = Integer.MAX_VALUE;
			for (int i=1;i<s.length();++i) {
				int leftSolution = 0;
				int rightSolution = 0;
				String leftPart = s.substring(0, i);
				String rightPart = s.substring(i, s.length());
				if (solutions.containsKey(leftPart)) {
					// if the partial string is already a palindrome, get number of cuts requried to split the partial string to get palindrome which is already in the hashmap
					leftSolution = solutions.get(leftPart);
				} else {
					leftSolution = splitDP(leftPart);
					solutions.put(leftPart, leftSolution);
				}
				
				if (solutions.containsKey(rightPart)) {
					rightSolution = solutions.get(rightPart);
				} else {
					rightSolution = splitDP(rightPart);
					solutions.put(rightPart, rightSolution);
				}
				cuts = Math.min(1 + leftSolution + rightSolution, cuts);
				
			}
			return cuts;
		}
		
	}
	
	//Time Com­plex­ity: If there are n char­ac­ters in string then n-1 cuts can be made and for every cut we two options, whether cut or not. so time com­plex­ity will be 2(n-1).
	public static int splitRecursion(String x){
		if(x=="" || isPalindrome(x)){
//			System.out.println(x);
			return 0;
		}else{
			int cuts = Integer.MAX_VALUE;
			for (int i = 1; i <x.length() ; i++) {
				cuts  = Math.min(1+ splitRecursion(x.substring(0, i)) + splitRecursion(x.substring(i, x.length())),cuts);
			}
			return cuts;
		}
	}
	
	private static boolean isPalindrome(String s) {
		int n = s.length();
		for (int i=0;i<(n/2);++i) {
			if (s.charAt(i) != s.charAt(n-i-1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String a = "cdcdddcdadcdcdcd";
		long startTime = System.currentTimeMillis();
		System.out.println("Recursion- Cuts Required: " + splitRecursion(a));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Recursion- Time Taken(ms): " + elapsedTime);
		startTime = System.currentTimeMillis();
		System.out.println("Dynamic Programming- Cuts Required: "+ splitDP(a));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Dynamic Programming- Time Taken(ms): " + elapsedTime);
	}
}
