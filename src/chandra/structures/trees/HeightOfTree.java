package com.chandra.structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

	public static int treeHeightRecursive(Node root) {
		if (root != null)
			return 1+Math.max(treeHeightRecursive(root.left), treeHeightRecursive(root.right));
		else return 0;
	}
	
	public static int treeHeightIterative(Node root) {
		if (root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		queue.add(null);
		int height = 0;
		while (!queue.isEmpty()) {
			Node node = (Node) queue.poll();
			if (node == null) {
				if (!queue.isEmpty()) queue.add(null);
				height++;
			} else {
				
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
		}
		
		return height;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		//root.right.right.right = new Node(8);
		
		System.out.println(treeHeightRecursive(root));
		System.out.println(treeHeightIterative(root));
	}
}
