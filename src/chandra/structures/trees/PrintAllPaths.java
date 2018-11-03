package com.chandra.structures.trees;

public class PrintAllPaths {
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
	public static void printPaths(Node root, int[] path, int pathLen) {
		if (root == null) return;
		
		path[pathLen++] = root.data;
		
		if (root.left == null && root.right==null)
			printArray(path, pathLen);
		else {
			printPaths(root.left, path, pathLen);
			printPaths(root.right, path, pathLen);
		}
		
	}
	
	public static void printArray(int[] path, int pathLen) {
		for(int i=0;i<pathLen;i++){
			System.out.print(path[i]+ "");
		}
		System.out.println();
	}
	
	public static void findPaths(Node root, String path) {
		if (root != null) {
			path += " " + root.data;
			if (root.left == null && root.right == null) {
				System.out.println("Path : " + path);
				return;
			}
			findPaths(root.left, path);
			findPaths(root.right, path);
		}
	}
	
	public static void main(String[] arg){
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		root.left.left = new Node (4);
		root.left.left.left = new Node (7);
		root.right.left = new Node (6);
		root.right.left.left = new Node (8);
		root.right.left.right = new Node (9);
		int [] path = new int [100];
		printPaths(root, path, 0);
		findPaths(root, " ");
	}
}
