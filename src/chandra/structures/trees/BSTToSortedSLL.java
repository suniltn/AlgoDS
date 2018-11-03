package com.chandra.structures.trees;

public class BSTToSortedSLL {
	static class LN {
		int data;
		LN next;
		
		public LN(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public static LN head;
	public static LN temp = null;
	
	public static void convertToSLL(Node root) {
		if (root == null) return;
		
		convertToSLL(root.left);
		LN newNode = new LN(root.data);
		if (temp == null) {
			head = newNode;
			temp = head;
		} else {
			temp.next = newNode;
			temp = temp.next;
		}
		
		convertToSLL(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(30);
		root.left = new Node(15);
		root.right = new Node(35);
		root.left.left = new Node(10);
		root.left.right = new Node(18);
		root.right.left = new Node(32);
		root.right.right = new Node(40);
		convertToSLL(root);
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
