package com.chandra.structures.arraysANDstrings;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KthElementInArray {
	public static int findKthLargestElement(int[] array, int k) {
		// Priority queue uses min heap
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int item : array) {
			queue.add(item);
			
			//if (queue.size() > k)
			//	queue.poll();
		}
		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("After polling for size : " + queue.size());
		while (queue.size() != k)
			System.out.println(queue.poll());
			
		
		return queue.peek();
	}
	
	public static int findKthSmallestElement(int[] array, int k) {
		// Priority queue uses min heap
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int item : array) {
			queue.add(item);
			
			//if (queue.size() > k)
			//	queue.poll();
		}
		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		while (k != 1) {
			System.out.println(queue.poll());
			k--;
		}
			
		
		return queue.peek();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		//findKthLargestElement(arr, 2);
		System.out.println("Smallest Element : " + findKthSmallestElement(arr, 2));
	}
}
