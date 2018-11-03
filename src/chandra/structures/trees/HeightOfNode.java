package com.chandra.structures.trees;

public class HeightOfNode {
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
	
	public static int nodeHeight(Node root, Node x, int height) {
		if (root == null) return 0;
		if (root == x) return height;
		
		int level = nodeHeight(root.left, x, height+1);
		if (level != 0) return level;
		
		return nodeHeight(root.right, x, height+1);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);		
		Node x = new Node(25);
		root.left.right = x;
		root.left.right.left = new Node(35);		
		
		System.out.println("Height of the Node " + x.data + " is : " +  nodeHeight(root,x,1));
	}
}
 