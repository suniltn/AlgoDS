package com.chandra.ds.java.implementations;

public class ArrayStack implements IArray {
	
	private int[] arr;
	private int top, size, len;
	
	public ArrayStack(int n) {
		size = n;
		top = -1;
		len = 0;
		arr = new int[size];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == size-1;
	}
	
	public int getSize() {
		return len;
	}
	
	public int peek() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Underflow Exception");
		
		return arr[top];
	}
	
	public void push(int element) {
		if (isFull())
			throw new IndexOutOfBoundsException("Overflow Exception");
		arr[++top] = element;
		len++;
	}
	
	public int pop() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Underflow Exception");
		len--;
		return arr[top--];
	}
	
	public void display() {
		System.out.print("Stack : ");
		if (isEmpty())
			System.out.print("Empty\n");
		for (int i=top;i>=0;i--)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	@Override
	public void insert(int item) {
		push(item);
		
	}

	@Override
	public int remove() {
		return pop();
	}
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(3);
		stack.push(10);
		stack.display();
		stack.push(20);
		stack.display();
		stack.push(30);
		stack.display();
		System.out.println("Peeked Value : "+ stack.peek());
		System.out.println("Popped Value : " + stack.pop());
		stack.display();
		System.out.println("Popped Value : " + stack.pop());
		stack.display();
		System.out.println("Popped Value : " + stack.pop());
		stack.display();
		System.out.println("Popped Value : " + stack.pop());
		stack.display();
	}

	
}
