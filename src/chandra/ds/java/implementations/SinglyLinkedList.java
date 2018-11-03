package com.chandra.ds.java.implementations;

public class SinglyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public SinglyLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtStart(int val) {
		
		Node newNode = new Node(val);
		size++;
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	public void insertAtEnd(int val) {
		Node newNode = new Node(val);
		size++;
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	public void insertAtPos(int val, int pos) {
		if (pos > size+1)
			throw new IndexOutOfBoundsException("Invalid Position");
		
		Node newNode = new Node(val);
		Node current = head;
		pos = pos-1;
		for(int i=1;i<size;i++) {
			if (i == pos) {
				Node temp = current.getNext();
				newNode.setNext(temp);
				current.setNext(newNode);
				break;
			}
			current = current.getNext();
		}
		size++;
	}
	
	public int deleteAtStart() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("List is empty");
		
		int temp = head.getData();
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();
		
		size--;
		return temp;
	}
	
	public int deleteAtEnd() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("List is empty");
		
		int temp = tail.getData();
		if (head == tail)
			head = tail = null;
		else {
			Node current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
		size--;
		return temp;
			
	}
	
	public int deleteAtPos(int pos) {
		if (pos > size || isEmpty())
			throw new IndexOutOfBoundsException("Invalid Position");
		
		if(pos == 1) return deleteAtStart();
		if (pos == size) return deleteAtEnd();
		
		Node start = head.getNext();
		Node prev = head;
		int deletedItem = Integer.MIN_VALUE;
		for(int i=2;i<size;i++) {
			if (i == pos) {
				deletedItem = start.getData();
				prev.setNext(start.getNext());
				size--;
			} else {
				prev = start;
				start = start.getNext();
			}
		}
		return deletedItem;
	}
	
	public void display() {
		System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }    
        if (head.getNext() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        Node ptr = head;
        System.out.print(head.getData()+ "->");
        ptr = head.getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtStart(5);
		sll.display();
		sll.insertAtStart(7);
		sll.display();
		sll.insertAtEnd(4);
		sll.display();
		sll.insertAtEnd(2);
		sll.display();
		sll.insertAtStart(9);
		sll.display();
		sll.insertAtPos(3, 3);
		sll.display();
		sll.insertAtPos(2, 2);
		sll.display();
		System.out.println(sll.getSize());
		sll.deleteAtPos(1);
		sll.display();
		sll.deleteAtPos(sll.getSize());
		sll.display();
		System.out.println(sll.getSize());
		System.out.println(sll.deleteAtPos(2));
		sll.display();
		System.out.println(sll.deleteAtPos(2));
		sll.display();
		System.out.println(sll.deleteAtPos(2));
		sll.display();
		System.out.println(sll.deleteAtPos(2));
		sll.display();
		System.out.println(sll.deleteAtPos(1));
		sll.display();
		
	}
}

class Node {
	private int data;
	private Node next;
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(int data) {
		this(data, null);
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}