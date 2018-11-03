package com.chandra.structures.trees;

public class SortedArrayToBST {
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
	
	public static Node sortedArrayToBST(int[] array, int begin, int end) {
		if (begin > end) return null;
		
		int mid = begin + (end-begin)/2;
		Node root = new Node(array[mid]);
		root.left = sortedArrayToBST(array, begin, mid-1);
		root.right = sortedArrayToBST(array, mid+1, end);
		return root;
	}
	
	public static void preorder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25};
		preorder(sortedArrayToBST(array, 0, array.length-1));
	}
	
}
