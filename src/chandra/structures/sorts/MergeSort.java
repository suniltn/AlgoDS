package com.chandra.structures.sorts;

import java.util.Arrays;

public class MergeSort {

	
	private void sortedMerge(int[] array, int low, int high) {
		int mid = (low+high)/2;
		int[] temp = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int r=0;
		
		while (i<= mid && j <= high) {
			if (array[i] <= array[j])
				temp[r++] = array[i++];
			else
				temp[r++] = array[j++];
		}
		
		while (i<=mid)
			temp[r++] = array[i++];
		
		while (j <= high) temp[r++] = array[j++];
		
		i = low;
		for (int k=0;k<temp.length;)
			array[i++] = temp[k++];
					
	}
	public void sort(int[] array, int low, int high) {
		if (low >= high) return;
		
		int mid = (low+high)/2;
		sort(array, low, mid);
		sort(array, mid+1, high);
		sortedMerge(array, low, high);
	}
	public static void main(String[] args) {
		int[] array = {11,19,0,-1,5,6,16,-3,6,0,14,18,7,21,18,-6,-8};
		MergeSort merge = new MergeSort();
		System.out.println("Original Array : " + Arrays.toString(array));
		merge.sort(array, 0, array.length-1);
		System.out.println("Sorted Array : " + Arrays.toString(array));
	}
}
