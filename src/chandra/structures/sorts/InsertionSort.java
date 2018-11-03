package com.chandra.structures.sorts;

import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] array) {
		if (array == null || array.length < 2)
			return;
		
		int size = array.length;
		for (int i=1;i<size;i++) {
			int temp = array[i];
			int j = i-1; // start comparing with previous sorted elements of subarray from right to left
			while (j >= 0 && temp < array[j]) {
				// comparing element to be inserted along with already inserted elements, if new element
				// is small then make room for it by moving the inserted elements to right until
				// we find a correct spot to insert
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {12, 35, 87, 26, 9, 28, 7};
		System.out.println("Before : " + Arrays.toString(array));
		sort(array);
		System.out.println("After : " + Arrays.toString(array));
	}
}
