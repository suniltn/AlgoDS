package com.chandra.structures.arraysANDstrings;

import java.util.HashSet;

public class DuplicatesInArray {
	public static HashSet<Integer> findDuplicates(int[] arr) {
		HashSet<Integer> duplicates = new HashSet<>();
		int n = arr.length;
		for (int i=0;i<n;i++) {
			if (arr[Math.abs(arr[i])] > 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				duplicates.add(Math.abs(arr[i]));
			}
		}
		
		return duplicates;
	}
	
	public static void findDups(int[] arr) {
		HashSet<Integer> duplicates = new HashSet<>();
		
		int n = arr.length;
		
		for (int i=0;i<n;i++) {
			if (duplicates.add(Math.abs(arr[i])) == false) 
				System.out.println(Math.abs(arr[i]));
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {2, 4, 1, 2, 6, 1, 6, 3, 5};
		HashSet<Integer> duplicates = findDuplicates(array);
		for (int item : duplicates) {
			System.out.println(item);
		}
		
		findDups(array);
	}
}
