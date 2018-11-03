package com.chandra.structures.trees;

public class PrintAllPathsSumEqualToNumber {
	public static void hasPath(Node root, int sum, String path) {
		if (root != null) {
			if (root.data > sum) return;
			
			path += " " + root.data;
			sum = sum - root.data;
			if (sum == 0) {
				System.out.println(path);
				return;
			}
			
			hasPath(root.left, sum, path);
			hasPath(root.right, sum, path);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		hasPath(root, 10, " ");
	}
}
