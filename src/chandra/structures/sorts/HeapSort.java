package com.chandra.structures.sorts;

import java.util.Arrays;

public class HeapSort {

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void heapify(int[] array, int index, int heapsize) {
		// heapify is nothing is find largest element among parent, left, & right child and then swap parent
		// with largest child and bubble down the heapify
		int largest = index;
		int left = 2 * index + 1;
		int right = 2* index + 2;
		
		if (left < heapsize && array[left] > array[largest])
			largest = left;
		if (right < heapsize && array[right] > array[largest])
			largest = right;
		
		if (index != largest) {
			swap(array, largest, index);
			heapify(array, largest, heapsize);
		}
	}
	public void buildMaxHeap(int[] array, int heapsize) {
		// Start with first internal node
		// first internal node can be identified using last index of array i.e (lastIndex-1)/2
		// we heapify for every internal node
		int lastIndex = array.length - 1;
		int internal = (lastIndex - 1) / 2;
		for (int i=internal;i>=0;i--) {
			heapify(array, i, heapsize);
		}
	}
	
	public void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(" " + arr[i]);			
		}
		System.out.println("");
	}
	
	public void sort(int[] array) {
		if (array == null || array.length < 2)
			return;
		
		// build max heap 
		buildMaxHeap(array, array.length);
		int heapsize = array.length;
		// after building the max heap now perform the sorting of elements by moving the largest
		// element to the end of the array and performing heapify on rest of the elements. Since 
		// the last element is already in sorted position.
		// looking at the heap tree always the root element is max hence swap with last position of element
		// then perform heapify on rest of the elements in array to perform similar operations till you 
		//reach the first element of array
		
		System.out.println("Max Heap : ");
		display(array);
		
		for (int i = array.length - 1; i>0; i--) {
			swap(array, 0, i);
			heapsize = heapsize - 1;
			heapify(array, 0, heapsize);
		}
		
	}
	public static void main(String[] args) {
		int[] array = {3,2,1,7,8,4,10,16,12};
		HeapSort heap = new HeapSort();
		System.out.println("Original Array : " + Arrays.toString(array));
		heap.sort(array);
		System.out.println("Sorted Array : " + Arrays.toString(array));
	}
}
