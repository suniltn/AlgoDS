package com.chandra.structures.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubStringWithStringConcatenation {
	
	/**
	 * 
	 * Maybe this is the so called window technique. 
	 * The window was moved right by the while(){} loop. 
	 * Since substring() is actually expensive in Java, 
	 * each time I store the substring in a variable to avoid repeatedly 
	 * calling the substring() function.
	 * More specifically, there are three cases that the window changes:
	 * 
	 * 1.The substring at the right of the window is not in words dictionary, 
	 * then we move the whole window to the right side of this substring and set 
	 * the window back to an empty window.
	 * 
	 * 2.The substring at the right of window is a candidate word and not used out by 
	 * the current window, then we add this substring into window. 
	 * The window's right boundary extends. Now if the window is a valid solution, 
	 * add the start index of window to result and cut off the head word of the window 
	 * for further checking, the window's left boundary shrinks.
	 * 
	 * 3.The substring at the right of window is a candidate word and 
	 * is used out by the current window. Then we cut off the head word of the window, 
	 * the window's left boundary shrinks (This would be done repeatedly by the while loop 
	 * until the substring is not used out by the current window and could be added into the window).


	 */
	
	
	
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0)
        	return res;
        
        int sLen = s.length();
        int numOfWords = words.length;
        int wordLen = words[0].length();
        int patternLen = numOfWords * wordLen;
        
        HashMap<String, Integer> wordsDict = new HashMap<>();
        for (String word : words)
        	wordsDict.put(word, wordsDict.containsKey(word) ? wordsDict.get(word)+1 : 1);
        
        HashMap<String, Integer> curDict = new HashMap<>();
        for (int i=0;i<wordLen;i++) {
        	int j=i, k=i;//k is at the head of the window and j is the last.
        	int addedCount = 0; // //to indicate whether we add index to res.
        	
        	//make sure the remaining length is enough.
        	while (k <= sLen - patternLen && j+wordLen <= sLen) {
        		String subWord = s.substring(j, j+wordLen);
        		// case 1: when subword is not part of words dictionary
        		if (!wordsDict.containsKey(subWord)) {
        			addedCount = 0;
        			curDict.clear();
        			j += wordLen;
        			k = j;
        			continue;
        		}
        		// case 2 : when subWord is part of words dictionary and is not present in window or
        		// if it is the valid candidate which is not being used earlier
        		if (!curDict.containsKey(subWord) || curDict.get(subWord) != wordsDict.get(subWord)) {
        				if (!curDict.containsKey(subWord)) curDict.put(subWord, 1);
        				else curDict.put(subWord, curDict.get(subWord)+1);
        				addedCount++;
        				// words in current window matches with pattern
        				if (addedCount == numOfWords) {
        					res.add(k);
        					String preHead = s.substring(k, k+wordLen);
        					k += wordLen;
        					addedCount--;
        					if (curDict.get(preHead) == 1) curDict.remove(preHead);
        					else curDict.put(preHead, curDict.get(preHead) - 1);
        				}
        				
        				j += wordLen;
        		} 
        		// case 3: next subword is a valid candidate but it's already being used
        		else {
        			String preHead = s.substring(k, k+wordLen);
        			k += wordLen;
        			addedCount--;
        			if (curDict.get(preHead) == 1) curDict.remove(preHead);
        			else curDict.put(preHead, curDict.get(preHead) - 1);
        			
        		}
        	}
        	
        	curDict.clear();
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "barfoofoofoobarman";
		String s1 = "wordgoodgoodgoodbestword";
		String[] words1 = {"word","good","best","good"};
		String[] words = {"foo", "bar"};
		System.out.println(findSubstring(s1, words1));
	}
	
}
