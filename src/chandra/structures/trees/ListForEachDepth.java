package com.chandra.structures.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListForEachDepth {
	
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
	
	static class ListNode {
		int data;
		ListNode next;
		public ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static ArrayList<ListNode> list = new ArrayList<>();
	
	public static void levelOrder(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		if (root == null) return;
		int level = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			ListNode head = null;
			ListNode current = null;
			level = queue.size();
			while (level > 0) {
				Node node = queue.remove();
				ListNode ln = new ListNode(node.data);
				if (head == null) {
					head = ln;
					current = ln;
				} else {
					current.next = new ListNode(node.data);
					current = current.next;
				}
				if (node.left!= null) queue.add(node.left);
				if (node.right!= null) queue.add(node.right);
				level--;
			}
			list.add(head);
		}
		display();
	}
	
	public static void display() {
		Iterator<ListNode> it = list.listIterator();
		while(it.hasNext()) {
			ListNode head = it.next();
			while (head != null) {
				System.out.print("->" + head.data);
				head = head.next;
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
		levelOrder(root);
	}
}
