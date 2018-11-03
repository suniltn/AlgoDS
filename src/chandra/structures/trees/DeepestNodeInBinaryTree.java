package com.chandra.structures.trees;

public class DeepestNodeInBinaryTree {
	
	static int deepLevel = 0;
	static Node deepNode = null;
	
	public static void findDeepNode(Node root, int level) {
		if (root != null) {
			findDeepNode(root.left, ++level);
			if (level > deepLevel) {
				deepLevel = level;
				deepNode = root;
			}
			findDeepNode(root.right, level);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		findDeepNode(root, 0);
		System.out.println("Deep Level : " + deepLevel + " & Deep Node : " + deepNode.data);
	}
}
