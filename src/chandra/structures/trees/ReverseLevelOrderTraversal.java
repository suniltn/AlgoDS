package com.chandra.structures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

	public static void reverseOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = (Node) queue.poll();
			stack.push(node);
			
			if (node.right != null) queue.add(node.right);
			if (node.left != null) queue.add(node.left);
		}
		
		while (!stack.isEmpty())
			System.out.println(stack.pop().data + " ");
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		reverseOrder(root);
	}
}
