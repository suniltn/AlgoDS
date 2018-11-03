package com.chandra.structures.trees;

import java.util.LinkedList;

public class LevelOrderPrint {
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static void levelOrder(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		if (root == null) return;
		int level = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			level = queue.size();
			while (level > 0) {
				Node node = queue.remove();
				System.out.print(node.data + " ");
				if (node.left!= null) queue.add(node.left);
				if (node.right!= null) queue.add(node.right);
				level--;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		
		System.out.println(" Output by Better Approach : ");
		levelOrder(root);
	}
}
