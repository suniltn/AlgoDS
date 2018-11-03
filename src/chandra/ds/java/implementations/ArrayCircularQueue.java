package com.chandra.ds.java.implementations;

//http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/8-List/array-queue2.html
public class ArrayCircularQueue implements IArray {
	private int enqueueHere, dequeueHere, size, len;
	private int[] arr;
	
	public ArrayCircularQueue(int n) {
		size = n;
		len = 0;
		enqueueHere = dequeueHere = 0;
		arr = new int[size];
	}

	@Override
	public boolean isEmpty() {
		return enqueueHere == dequeueHere;
	}

	@Override
	public boolean isFull() {
		return dequeueHere == (enqueueHere+1) % size;
	}

	@Override
	public int getSize() {
		return len;
	}

	@Override
	public void insert(int item) {
		if (isFull())
			throw new IndexOutOfBoundsException("Overflow Exception");
		
		arr[enqueueHere] = item;
		enqueueHere = (enqueueHere+1)%size;
		len++;
	}

	@Override
	public int remove() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Underflow Exception");
		int item = arr[dequeueHere];
		dequeueHere = (dequeueHere+1) % size;
		len--;
		return item;
	}
	
	public static void main(String[] args) {
		ArrayCircularQueue acq = new ArrayCircularQueue(5);
		acq.insert(00);
		acq.insert(10);
		acq.insert(20);
		acq.insert(30);
		//acq.insert(40);
		//acq.insert(50);
		acq.remove();
		acq.insert(50);
		System.out.println(acq.getSize());
	}
	
}
