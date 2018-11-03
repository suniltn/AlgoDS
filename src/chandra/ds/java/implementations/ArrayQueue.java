package com.chandra.ds.java.implementations;

public class ArrayQueue implements IArray {
	private int[] arr;
	private int size, len, front, rear;
	
	public ArrayQueue(int n) {
		size = n;
		arr = new int[size];
		len = 0;
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return front == -1;
	}
	
	public boolean isFull() {
		return front == 0 && rear == size-1;
	}
	
	public int getSize() {
		return len;
	}

	@Override
	public void insert(int item) {
		if (isFull())
			throw new IndexOutOfBoundsException("Overflow Exception");
		if(rear == -1) {
			front = rear = 0;
			arr[rear] = item; 
		} else {
			arr[++rear] = item;
		}
		len++;
	}

	@Override
	public int remove() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Underflow Exception");
		else {
			len--;
			int element = arr[front];
			if (front == rear)
				front = rear = -1;
			else
				front++;
			return element;
		}
	}
	
	public void enqueue(int item) {
		insert(item);
	}
	
	public int dequeue() {
		return remove();
	}
	
	public void display() {
		System.out.print("Queue : ");
		if (isEmpty())
			System.out.print("Empty\n");
		for (int i=front; i<=rear;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		queue.enqueue(10);
		queue.display();
		queue.enqueue(20);
		queue.display();
		queue.enqueue(30);
		queue.display();
		queue.dequeue();
		queue.display();
		queue.dequeue();
		queue.display();
		queue.dequeue();
		queue.display();
	}
}
