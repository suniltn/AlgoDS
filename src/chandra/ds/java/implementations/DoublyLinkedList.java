package com.chandra.ds.java.implementations;

public class DoublyLinkedList {
	private DNode head;
	private DNode tail;
	private int size;
	
	public DoublyLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtHead(int value) {
		DNode node = new DNode(value);
		if (head == null) {
			head = tail = node;
		} else {
			node.right = head;
			head.left = node;
			head = node;
		}
		size++;
	}
	
	public void insertAtTail(int value) {
		DNode node = new DNode(value);
		if (tail == null) {
			head = tail = node;
		} else {
			tail.right = node;
			node.left = tail;
			tail = node;
		}
		size++;
	}
	
	public void insertAtPos(int value, int pos) {
		DNode node = new DNode(value);
		if 
	}
	
	public int deleteAtHead() {
		
	}
	
	public int deleteAtTail() {
		
	}
	
	public int deleteAtPos(int pos) {
		
	}
	
}

class DNode {
	public int data;
	public DNode left;
	public DNode right;
	
	public DNode(int data) {
		this(data, null, null);
	}
	
	public DNode(int data, DNode left, DNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
