package com.chandra.structures.lists;

public class SingleLinkedList<E> {

	private Node<E> head;
	
	public SingleLinkedList() {
		head = null;
	}
	
	public void insert(E data) {
		if (head == null) {
			head = new Node<>(data);
			return;
		}
		
		
		Node<E> newNode = new Node<>(data, head);
		head = newNode;
	}
	
	public void reverse() {
		if (head == null || head.getNext() == null)
			return;
		
		Node<E> prev = null;
		Node<E> current = null;
		Node<E> nextNode = head;
		while (nextNode != null) {
			prev = current;
			current = nextNode;
			nextNode = nextNode.getNext();
			current.setNext(prev);
		}
		head = current;
	}
	
	public void printList() {
		if (head == null)
			return;
		
		Node<E> current = head;
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> singleList = new SingleLinkedList<>();
		singleList.insert(10);
		singleList.insert(20);
		singleList.insert(30);
		singleList.insert(40);
		singleList.insert(50);
		singleList.printList();
		System.out.println("After Reverse");
		singleList.reverse();
		singleList.printList();
	}
}
