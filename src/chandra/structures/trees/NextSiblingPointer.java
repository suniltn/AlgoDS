package com.chandra.structures.trees;

public class NextSiblingPointer {
	static class Node {
		int data;
		Node left;
		Node right;
		Node nextSibling;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public Node provideSiblings(Node root) {
		if (root != null) {
			if (root.left != null) {
				root.left.nextSibling = root.right;
			}
			
			if (root.right != null) {
				if (root.nextSibling != null) {
					root.right.nextSibling = root.nextSibling.left;
				}
			}
			
			provideSiblings(root.left);
			provideSiblings(root.right);
			return root;
		}
		return null;
	}
	
	public void printLevel(Node n) {
		while (n != null) {
			System.out.print(" " + n.data);
			n = n.nextSibling;
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
		NextSiblingPointer i = new NextSiblingPointer();
		Node x = i.provideSiblings(root);
		i.printLevel(x);
		System.out.println("");
		i.printLevel(x.left);
		System.out.println("");
		i.printLevel(x.left.left);
	}
}
