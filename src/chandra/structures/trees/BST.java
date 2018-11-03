package com.chandra.structures.trees;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private static Node root;
	public BST() {
		root = null;
	}
	
	public boolean find(int toFind) {
		if (root == null) return false;
		
		Node current = root;
		while (current != null) {
			if (toFind == current.data) return true;
			if (toFind < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	
	public void insert(int toInsert) {
		Node newNode = new Node(toInsert);
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while(true) {
			parent = current;
			if (toInsert < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public boolean delete(int toDelete) {
		if (root == null) return false;
		
		boolean isLeftTree = false;
		Node current = root;
		Node parent = null;
		
		while (toDelete != current.data) {
			parent = current;
			if (toDelete < current.data) {
				isLeftTree = true;
				current = current.left;
			} else {
				isLeftTree = false;
				current = current.right;
			}
			if (current == null) return false;
		}
		
		// if i'm here means I have found the node to be deleted
		// case 1. No children
		if (current.left == null && current.right == null) {
			if (current == root) root = null;
			if (isLeftTree) parent.left = null;
			else parent.right = null;
		}
		// case 2. One Child
		else if (current.right == null) {
			if (current == root) root = root.left;
			if (isLeftTree) parent.left = current.left;
			else parent.right = current.left;
		} else if (current.left == null) {
			if (current == root) root = root.right;
			if (isLeftTree) parent.left = current.right;
			else parent.right = current.right;
		}
		// case 3: Two Children
		else if (current.left != null && current.right != null) {
			Node successor = getSuccessor(current);
			if (current == root) root = successor;
			else if (isLeftTree)
				parent.left = successor;
			else
				parent.right = successor;
			
			successor.left = current.left;
		}
		
		return true;
		
	}
	
	private Node getSuccessor(Node node) {
		Node successor = null;
		Node successorParent = null;
		Node current = node.right;
		
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
		if (successor.right != null) {
			successorParent.left = successor.right;
			successor.right = node.right;
		}
		
		return successor;
	}
	
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	public static void main(String arg[]){
		BST b = new BST();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}

}
