package com.chandra.structures.trees;

import java.util.Stack;

public class PreOrderToBST {
	
	/**
	Method 2 ( O(n) time complexity )
	The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}. 
	The first node will definitely be in range, so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}. 
	If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree. To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
	*/
	// A recursive function to construct BST from pre[]. preIndex is used
    // to keep track of index in pre[].
	public static int preIndex = 0;
	public static Node constructBSTRec2(int[] preOrder, int min, int max, int size) {
		// Base Case
		if (preIndex >= size) return null;
		
		Node root = null;
		// If current element of pre[] is in range, then
        // only it is part of current subtree
		if (preOrder[preIndex] > min && preOrder[preIndex] < max) {
			root = new Node(preOrder[preIndex++]);
			if (preIndex < size) {
				root.left = constructBSTRec2(preOrder, min, root.data, size);
				root.right = constructBSTRec2(preOrder, root.data, max, size);
			}
		}
		return root;
	}
	
	/**
	Method 1 ( O(n^2) time complexity )
	The first element of preorder traversal is always root. We first construct the root. Then we find the index of first element which is greater than root. Let the index be ‘i’. The values between root and ‘i’ will be part of left subtree, and the values between ‘i+1′ and ‘n-1′ will be part of right subtree. Divide given pre[] at index “i” and recur for left and right sub-trees.
	For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element greater than 10, we find 40. So we know the structure of BST is as following.

	             10
	           /    \
	          /      \
	  {5, 1, 7}       {40, 50}
	We recursively follow above steps for subarrays {5, 1, 7} and {40, 50}, and get the complete tree.
	*/
	public static Node constructBSTRec1(int[] preOrder, int low, int high, int size) {
		//Base case
		if (preIndex >= size || low > high) return null;
		
		// The first node in preorder traversal is root. So take the node at
        // preIndex from pre[] and make it root, and increment preIndex
		Node root = new Node(preOrder[preIndex++]);
		
		// If the current subarry has only one element, no need to recur
		if (low == high) return root;
		
		// Search for the first element greater than root
		int i;
        for (i = low; i <= high; ++i) {
            if (preOrder[i] > root.data) {
                break;
            }
        }
		root.left = constructBSTRec1(preOrder, preIndex, i-1,size);
		root.right = constructBSTRec1(preOrder, i, high, size);
		return root;
	}
	
	public static Node constructBSTIterative(int[] preOrder) {
		if (preOrder == null) return null;
		
		Node root = new Node(preOrder[0]);
		if (preOrder.length == 1) return root;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		for (int i=1;i<preOrder.length;i++) {
			Node ptr = null;
			
			// Keep popping until you find a element which is greater than element that's being processed and the last element popped (i.e less than our current element in process) will be our candidate to go right
			while(!stack.isEmpty() && preOrder[i] > stack.peek().data)
				ptr = stack.pop();
			
			// if there are no elements less than current processing element hence insert to left of top element stored in stack
			if (ptr == null) {
				stack.peek().left = new Node(preOrder[i]);
				stack.push(stack.peek().left);
			} else {
				
				ptr.right = new Node(preOrder[i]);
				stack.push(ptr.right);
			}
		}
		return root;
		
	}
	
	public static void displayTree(Node root) {
		if (root != null) {
			displayTree(root.left);
			System.out.print(" " + root.data);
			displayTree(root.right);
		}
	}
	
	public static void main(String[] args) {
		int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
		//displayTree(constructBSTRec(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE, preOrder.length));
		//displayTree(constructBSTRec1(preOrder, 0, preOrder.length-1, preOrder.length));
		displayTree(constructBSTIterative(preOrder));
	}
}
