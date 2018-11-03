package com.chandra.structures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
	public static void inorderRecursive(Node root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.data + " ");
			inorderRecursive(root.right);
		}
	}

	public static void postOrderRecursive(Node root) {
		if (root != null) {
			postOrderRecursive(root.right);
			postOrderRecursive(root.left);
			System.out.print(root.data + " ");
		}
	}

	public static void preOrderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	
	public static void preOrderIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			while(root != null) {
				System.out.print(root.data + " ");
				stack.push(root);
				root = root.left;
			}
			
			if (stack.isEmpty()) return;
			
			root = stack.pop();
			root = root.right;
		}
	}
	
	public static void inorderIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			if (stack.isEmpty()) return;
			
			root = stack.pop();
			System.out.print(root.data + " ");
			root = root.right;
		}
	}
	
	public static void postOrderIterative(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			if (root.right != null) s1.push(root.right);
			if (root.left != null) s1.push(root.left);
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}
	
	public static void BFSOrLevelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int levelSize = 0;
		while(!queue.isEmpty()) {
			levelSize = queue.size();
			while (levelSize>0) {
				Node node = (Node)queue.poll();
				System.out.print(node.data + " ");
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
				levelSize--;
			}
			System.out.println();
		}
	}
	
	public static void DFSTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node top = stack.pop();
			if (top.right != null)stack.push(top.right);
			if(top.left!= null) stack.push(top.left);
			System.out.println(" " + top.data);
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
		System.out.print("PreOrder Recursive : ");
		preOrderRecursive(root);
		System.out.print("\nInOrder Recursive : ");
		inorderRecursive(root);
		System.out.print("\nPostOrder Recursive : ");
		postOrderRecursive(root);
		System.out.print("\nPreOrder Iterative : ");
		preOrderIterative(root);
		System.out.print("\nInOrder Iterative : ");
		inorderIterative(root);
		System.out.print("\nPostOrder Iterative : ");
		postOrderIterative(root);
		System.out.println("\nBFS or Level Order : ");
		BFSOrLevelOrderTraversal(root);
		System.out.println("\nDFS : ");
		DFSTraversal(root);
	}
}
