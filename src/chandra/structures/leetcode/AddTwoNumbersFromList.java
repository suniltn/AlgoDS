package com.chandra.structures.leetcode;

public class AddTwoNumbersFromList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		int carry = 0;
		int v1, v2;
        while (l1 != null || l2 != null) {
        	if (l1 == null) v1= 0;
        	else {
        		v1 = l1.val;
        		l1 = l1.next;
        	}
        	
        	if (l2 == null) v2 = 0;
        	else {
        		v2 = l2.val;
        		l2 = l2.next;
        	}
        	
        	int s = v1 + v2 + carry;
        	carry = s/10;
        	
        	current.next = new ListNode(s%10);
        	current = current.next;
        }
        return result.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int value) {
		val = value;
	}
}


