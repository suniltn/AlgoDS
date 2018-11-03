package com.chandra.structures.leetcode;

public class LongestSubstringWithoutRepeat {
	public static String find(String s){
	    if (s.length() < 2){
	        return s;
	    }
	    char A = 'a';
	    char Z = 'z';
	    //store the last index a character appear
	    int[] lastIndex = new int[Z - A + 1];
	    for (int i = 0; i < lastIndex.length; i++){
	        lastIndex[i] = -1;
	    }
	     
	    //lengthSubString[i] is the longest substring without repeating characters ending at s[i] 
	    int[] lengthSubString = new int[s.length()];
	    lengthSubString[0] = 1;
	    lastIndex[s.charAt(0)-A] = 0;
	    for (int i = 1; i < s.length(); i++){
	        int indexLastAppear = lastIndex[s.charAt(i) - A]; 
	        if(indexLastAppear < i - lengthSubString[i-1]){
	            //char never appear before in the longest substring without repeating characters ending at s[i-1]
	            lengthSubString[i]= lengthSubString[i-1] + 1;
	        } else{
	            lengthSubString[i] = i - indexLastAppear;
	        	//lengthSubString[i] = lengthSubString[indexLastAppear];
	        }
	        //update indexLastAppear
	        lastIndex[s.charAt(i) - A] = i;
	    }
	     
	    int maxLength = Integer.MIN_VALUE;
	    int index = 0;
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < lengthSubString.length; i++){ 
	    	sb.append(lengthSubString[i]);
	    	if (lengthSubString[i] > maxLength){
	            maxLength = lengthSubString[i];
	            index = i;
	        }
	    }
	    return s.substring(index - maxLength + 1, index + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(find("ababcdabcdb"));
	}
}
