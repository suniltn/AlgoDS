package com.chandra.structures.trees;

public class BinaryTreeToDLL {
	private static class Node {
		int data;
	    Node left, right;
	  
	    public Node(int item) {
	        data = item;
	        left = right = null;
	    }
	    
	    public Node(int data, Node left, Node right) {
	        this.data = data;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	private Node root = null;
	
	public Node convertToDLL() {
		if (root == null)
			return null;
		
		root = convertToDLL(root);
		
		while (root.left != null)
			root = root.left;
		
		return root;
	}
	
	private Node convertToDLL(Node root) {
		//process left tree since after converting Binary Tree to DLL the DLL will be of inorder traversal
		// step 1: process left subtree
		if (root.left != null) {
			Node left = convertToDLL(root.left);
			// finding the predecssor(max element) of the root which is a right most element in the left subtree
			// since predecessor will be towards left of root in inorder traversal
			while (left.right != null)
				left = left.right;
			
			left.right = root;
			root.left = left;
		}
		
		// step2 : process right subtree
		if (root.right != null) {
			Node right = convertToDLL(root.right);
			// finding the successor(min element) of the root which is the left most element in the right subtree
			// since successor will be towards right of the root in inorder traversal 
			while (right.left != null)
				right = right.left;
			
			root.right = right;
			right.left = root;
		}
		
		return root;
	}
	
	void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
	
	/*
     * Create a sample tree
     *              	1
     *      	 2               3
     * 		4        5       6       7
     *  8       9
     */
    public void createSampleTree() {
        root = new Node(1, new Node(2, new Node(4, new Node(8), new Node(9)), new Node(5)), new Node(3, new Node(6), new Node(7)));       
    }
	
	public static void main(String[] args) {
		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		  
        tree.createSampleTree();
        
        Node root = tree.convertToDLL();
        tree.printList(root);
	}
}
