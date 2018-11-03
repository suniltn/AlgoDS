package com.chandra.structures.trees;


//http://algorithms.tutorialhorizon.com/given-a-sorted-singly-linked-list-array-convert-it-into-a-balanced-binary-search-tree/
public class SortedSLLToBST {
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			next = null;
		}
	}
	static class BSTNode{
		int data;
		BSTNode left;
		BSTNode right;
		public BSTNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public static Node head = null;
	//http://articles.leetcode.com/convert-sorted-list-to-balanced-binary/
	//Bottom Up appraoch
	public static BSTNode LLToBST(int start, int end) {
		if (start > end) return null;
		
		int mid = start + (end-start)/2;
		BSTNode leftChild = LLToBST(start,mid-1);
		BSTNode root = new BSTNode(head.data);
		root.left = leftChild;
		head = head.next;
		root.right = LLToBST(mid+1,end);
		return root;
	}
	
	public static int getSize(){
		Node curr = head;
		int size =0;
		while(curr!=null){
			curr=curr.next;
			size++;
		}
		return size;
	}
	
	public static void inorder(BSTNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		Node tail = new Node(6);
		head.next.next.next.next.next = tail;

		BSTNode x = LLToBST(1,getSize()) ;
		System.out.print("Constructed BST is :");
		inorder(x);
	}
}
