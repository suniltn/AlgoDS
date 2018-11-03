package com.chandra.structures.trees;

public class SortedDLLToBST {

	// here head should be considered as root after convertion
	private ListNode head = null;
    private ListNode tail = null;
 
    private int getListLength() {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
    
    public void addToList(int data) {
        ListNode n = new ListNode(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            // Add to end of list
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
    }
    
    /**
     * We recursively traverse to the leaves and then create the tree upwards from the leaves to the root.
Step 1. Calculate the length of the linked list.
Step 2. Recursively create left sub tree from first half nodes.
Step 3. Make middle node as the root and node returned from previous call (Step 2) as left child of the root.
Step 4. Move head to next node.
Step 5. Recursively create the right sub tree from second half nodes.
Step 6. Return root.
     */
    //Bottom Up approach - meaning creating from leaves to root
    //Time complexity - O(n)
    // This is exactly similar to SLL to BST with only difference is we are not allocating space for new nodes here instead we are modifying the DLL pointers
    public void convertToBST() {
    	head = convertToBST(getListLength());
    }
    
    private ListNode convertToBST(int len) {
    	if (len == 0)
    		return null;
    	
    	ListNode left = convertToBST(len/2);
    	ListNode root = head;
    	root.prev = left;
    	head = head.next;
    	ListNode right = convertToBST(len - len/2 - 1);
    	root.next = right;
    	return root;
    	
    }
    
    public void printInorderOrderTraversal() {
        printInorderOrderTraversalHelper(head);
    }
 
    private void printInorderOrderTraversalHelper(ListNode root) {
        if (root == null) {
            return;
        }
 
        printInorderOrderTraversalHelper(root.prev);
        System.out.print(root.data + " ");
        printInorderOrderTraversalHelper(root.next);
    }
 
    
	public static void main(String[] args) {
		SortedDLLToBST dll = new SortedDLLToBST();
		for (int i = 1; i < 8; i++) {
            dll.addToList(i);
        }
		dll.convertToBST();
		dll.printInorderOrderTraversal();
	}

}

class ListNode {
    int data;
    ListNode prev;
    ListNode next;
 
    public ListNode(int data) {
        this.data = data;
    }
}
