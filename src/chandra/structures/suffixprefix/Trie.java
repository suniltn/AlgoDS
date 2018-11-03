package com.chandra.structures.suffixprefix;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}
	
	private final TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for (int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	public boolean search(String word) {
		TrieNode current = root;
		for (int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null)
				return false;
			current = node;
		}
		return current.endOfWord;
	}
	
	public void delete(String word) {
		delete(root, word, 0);
	}
	
	private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
	}
	
}
