package com.chandra.structures.trees;

import java.util.Arrays;

public class BinaryMinAndMaxHeap {
	
	public void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	public void heapify(int[] arr, int heapSize, int internalIndex, boolean minOrMax) {
		int left = 2*internalIndex+1;
		int right = 2*internalIndex+2;
		
		int toSwap = internalIndex;
		// minOrMax = true then building min heap
		// minOrMax = false then building max heap
		if (minOrMax) {
			if (left<heapSize && arr[left] < arr[toSwap])
				toSwap = left;
			if (right<heapSize && arr[right] < arr[toSwap])
				toSwap = right;
		} else {
			if (left<heapSize && arr[left] > arr[toSwap])
				toSwap = left;
			if (right<heapSize && arr[right] > arr[toSwap])
				toSwap = right;
		}
		
		if (toSwap != internalIndex) {
			swap(arr, internalIndex, toSwap);
			heapify(arr, heapSize, toSwap, minOrMax);
		}
	}
	
	public void buildHeap(int[] arr, int heapSize, boolean minOrMax) {
		if (arr == null || arr.length < 2) return;
		
		int lastIndex = arr.length - 1;
		int lastInternal = (lastIndex - 1)/2; 
		while (lastInternal >= 0)
			heapify(arr, heapSize, lastInternal--, minOrMax);
	}
	
	public void heapSort(int[] arr, boolean minOrMaxHeap) {
		int heapSize = arr.length;
		// sorting is done by swapping the last element to 0th element since that will root and then bubble down till element before last
		// and repeat this process till 0th index
		for (int i = arr.length-1;i>0; i--) {
			swap(arr, 0, i);
			heapSize--;
			heapify(arr, heapSize, 0, minOrMaxHeap);
		}
		System.out.println("After Sorting : ");
		display(arr);
	}
	
	public int extractElement(int[] arr, int heapSize, boolean minOrMaxheap) {
		int value = arr[0];
		arr[0] = arr[heapSize-1];
		heapSize--;
		heapify(arr, heapSize, 0, minOrMaxheap);
		return value;
	}
	
	public void display(int[] arr){
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int arr [] = {3,2,1,7,8,4,10,16,12};
		
		BinaryMinAndMaxHeap heap = new BinaryMinAndMaxHeap();
		System.out.print("Original Array : ");
		heap.display(arr);
		
		
		// true - min heap
		// false - max heap
		boolean minOrMaxHeap = false;
		
		
		heap.buildHeap(arr, arr.length, minOrMaxHeap);

		if (minOrMaxHeap)
			System.out.print("\nMin-Heap : ");
		else
			System.out.print("\nMax-Heap : ");
		heap.display(arr);
		
		//heap.heapSort(arr, minOrMaxHeap);
		
		System.out.println("Extracted Elements : ");
		for (int i=arr.length;i>0;i--)
			System.out.println(heap.extractElement(arr, i, minOrMaxHeap));

		
		
		
		//Original Array :   3  2  1  7  8  4  10  16  12
		//Min-Heap :  1 3 2 7 8 4 10 16 12
		//Extract Min :  1  2  7  10  4  8  12  16  3
	}

}
