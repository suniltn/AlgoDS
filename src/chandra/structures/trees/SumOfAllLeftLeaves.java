package com.chandra.structures.trees;

public class SumOfAllLeftLeaves {
	
	public static boolean isLeaf(Node node) {
		if (node == null) return false;
		if (node.left == null && node.right == null) return true;
		else return false;
	}
	
	public static int leftLeavesSum(Node root) {
		int sum = 0;
		if (root != null) {
			if (isLeaf(root.left))
				sum += root.left.data;
			else
				sum += leftLeavesSum(root.left);
			sum += leftLeavesSum(root.right);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(10);
		root.left.right = new Node(12);
		root.left.right.left = new Node(6);
		root.right.right = new Node(8);
		root.right.right.left = new Node(5);
		
		System.out.println("Sum of left leaves: " + leftLeavesSum(root));
	}
	
}
