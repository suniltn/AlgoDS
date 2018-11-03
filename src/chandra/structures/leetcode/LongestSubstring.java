package com.chandra.structures.leetcode;

import java.util.HashMap;

import java.util.HashSet;



public class LongestSubstring {


//https://leetcode.com/articles/longest-substring-without-repeating-characters/


// O(n)

public static int longestLength(String s) {

HashMap<Character, Integer> map = new HashMap<>();

int i=0,j=0;

int ans = 0;

int n = s.length();

while (j<n) {

if (map.containsKey(s.charAt(j))) {

// we have to move i to the element after duplicate element. But if i is already ahead of duplicate's next element

// then we can use current i position. It doesn't make sense to go back.

//hence we are taking max of duplicate element's next position and i position

i = Math.max(map.get(s.charAt(j)), i);

} 

// when the duplicate element is encountered then the substring till j(exclusive) from i is a substring with unique characters

// and we check with current longest substring length and update accordingly

ans = Math.max(ans, j-i+1);

// we always store next element's index as current element value in hashmap 

map.put(s.charAt(j), j+1);

j++;

}


return ans;

}


// O(2n)

public static int longestLength1(String s) {

HashSet<Character> set = new HashSet<>();


int i=0,j=0,ans=0;

int n = s.length();


// here in this logic we start traversing the characters and if it's not already present in set add it and compute the length of

// substring from i to j(excl) 

// if the character is present in the set then remove all the elements from set and start adding it from duplicate character

// the reason is we know that the characters till current duplicate characters are unique hence they were in set

while (i<n&&j<n) {

if (!set.contains(s.charAt(j))) {

set.add(s.charAt(j++));

ans = Math.max(ans, j-i);

} else {

set.remove(s.charAt(i++));

}

}

return ans;

}


public static void main(String[] args) {

System.out.println(longestLength1("an++--viaj"));

}

}


