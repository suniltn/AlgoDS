package com.chandra.structures.trees;

public class BSTToCircularDLL {
	
	static Node head;
	static Node prev=null;
	
	public static void convertCircularDLL(Node root) {
		if (root == null) return;
		
		convertCircularDLL(root.left);
		root.left = prev;
		
		if (prev == null)
			head = root;
		else {
			prev.right = root;
		}
		Node right = root.right;
		
		head.left = root;
		root.right = head;
		prev = root;
		convertCircularDLL(right);
	}
}
