package com.chandra.structures.trees;

public class BSTToSortedDLL {

	public static Node head;
	public static Node prev = null;
	
	
	// Inorder traversal with in-place conversion
	public static void convertDLL(Node root) {
		if (root == null) return;
		
		convertDLL(root.left);
		if (prev == null) {
			head = root;
			prev = head;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		convertDLL(root.right);
	}
	
	
	
	public static void main(String[] args) {
		Node root = new Node(30);
		root.left = new Node(15);
		root.right = new Node(35);
		root.left.left = new Node(10);
		root.left.right = new Node(18);
		root.right.left = new Node(32);
		root.right.right = new Node(40);
		convertDLL(root);
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.right;
		}
	}
	
}
