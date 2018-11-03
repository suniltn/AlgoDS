package com.chandra.structures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class PrintDiffViews {

	public static TreeMap<Integer, Integer> ht = new TreeMap<>();
	
	public static void printBottomView(Node root) {
		if (root == null) return;
		int level = 0;
		
		Queue<QueuePack> queue = new LinkedList<>();
		queue.add(new QueuePack(level, root));
		
		while (!queue.isEmpty()) {
			QueuePack temp = queue.poll();
			Node node = temp.tnode;
			int lvl = temp.level;
			
			if (ht.containsKey(lvl)) {
				ht.remove(lvl);
			} 
			ht.put(lvl, node.data);
			
			if (node.left != null) queue.add(new QueuePack(lvl-1, node.left));
			if (node.right != null) queue.add(new QueuePack(lvl+1, node.right));
		}
		
		Set<Integer> keys = ht.keySet();
		
		for (Integer key : keys) {
			System.out.println(ht.get(key));
		}
	}
	
	public static void printTopView(Node root) {
		if (root == null) return;
		int level = 0;
		
		Queue<QueuePack> queue = new LinkedList<>();
		queue.add(new QueuePack(level, root));
		
		while (!queue.isEmpty()) {
			QueuePack temp = queue.poll();
			Node node = temp.tnode;
			int lvl = temp.level;
			
			if (!ht.containsKey(lvl)) {
				ht.put(lvl, node.data);
			} 
			if (node.left != null) queue.add(new QueuePack(lvl-1, node.left));
			if (node.right != null) queue.add(new QueuePack(lvl+1, node.right));
		}
		
		Set<Integer> keys = ht.keySet();
		
		for (Integer key : keys) {
			System.out.println(ht.get(key));
		}
	}

	static int max_level = 0;
	public static void printLeftView(Node root, int level) {
		if (root != null) {
			if (max_level<level) {
				System.out.println(root.data);
				max_level = level;
			}
			printLeftView(root.left, level+1);
			printLeftView(root.right, level+1);
		}
	}
	
	public static void printRightView(Node root, int level) {
		if (root != null) {
			if (max_level < level) {
				System.out.println(root.data);
				max_level = level;
			}
			printRightView(root.right, level+1);
			printRightView(root.left, level+1);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		//printBottomView(root);
		//printTopView(root);
		//printLeftView(root, 1);
		printRightView(root, 1);
	}
	
}

class QueuePack {
	int level;
	Node tnode;

	public QueuePack(int level, Node tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}
