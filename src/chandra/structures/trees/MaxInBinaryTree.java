package com.chandra.structures.trees;

public class MaxInBinaryTree {

	public static int getMax(int a, int b, int c) {
		return a>b ? (a>c?a:c) : (b>c?b:c);
	}
	public static int findMax(Node root) {
		if (root == null) return 0;
		
		return getMax(root.data, findMax(root.left), findMax(root.right));
			
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(findMax(root));
	}
}

