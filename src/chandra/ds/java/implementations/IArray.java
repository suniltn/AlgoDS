package com.chandra.ds.java.implementations;

public interface IArray {
	boolean isEmpty();
	boolean isFull();
	int getSize();
	void insert(int item);
	int remove();
}
