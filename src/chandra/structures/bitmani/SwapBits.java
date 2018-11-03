package com.chandra.structures.bitmani;

public class SwapBits {
	// since bits can be either 0 or 1. Instead of swapping just flip the bits if they differ if not just
	// return
	
	public static long swapBits(long x, int i, int j) {
		// Extract i-th and j-th bits and see if they differ
		if (((x>>>i)&1) != ((x>>>j)&1)) {
			// i-th and j-th bits differ. We will swap them by flipping their values
			// Select the bits to flip with bitMask. Since x^1 = 0 when x = 1 and 1
			// when x = 0, we can perform the flip XOR
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		return x;
	}
	
	public static void main(String[] args) {
		//i/p: 73 = 01001001 (8-bit integer)
		//o/p: 11 = 00001011 (8-bit integer)
		
		System.out.println(swapBits(73, 1, 6));
		
	}
}
