package com.chandra.structures.sorts;

import java.util.Arrays;

public class QuickSort {
	
	private int split(int[] array, int low, int high) {
		//move elements around so that elements towards left of pivot are smaller and equal to pivot
		// elements on right are larger than pivot
		int pivot = low;
		int i = low + 1;
		int j = high;
		
		//we are choosing pivot always the first element in the array
		while (i <= j) {
			if (array[i] <= array[pivot]) {
				i++;
				continue;
			}
			
			if (array[j] > array[pivot]) {
				j--;
				continue;
			}
			swap(array, i++, j--);
		}
		
		if (array[pivot] > array[j] ) {
			swap(array, pivot, j);
			return j;
		}
		
		return pivot;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void sort(int[] array, int low, int high) {
		if (low >= high)
			return;
		
		int pivot = split(array, low, high);
		sort(array, low, pivot-1);
		sort(array, pivot+1, high);
	}
	
	public static void main(String[] args) {
		int[] array = {11,19,0,-1,5,6,16,-3,6,0,14,18,7,21,18,-6,-8};
		QuickSort quick = new QuickSort();
		System.out.println("Original Array : " + Arrays.toString(array));
		quick.sort(array, 0, array.length-1);
		System.out.println("Sorted Array : " + Arrays.toString(array));
	}
	
}
