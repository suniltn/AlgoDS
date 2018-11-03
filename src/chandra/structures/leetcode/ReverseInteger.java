package com.chandra.structures.leetcode;

public class ReverseInteger {
	public static int reverse(int x) {
        if (x == 0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;

        boolean neg = false;
        if(x<0) {
        	x = 0 -x;
        	neg = true;
        }
        
        long rev = 0;
        while(x != 0) {
        	rev = rev * 10 + x %10;
            x=x/10;
        }
        rev = rev > Integer.MAX_VALUE ? 0 : (int)rev;
        if (neg)
        	rev = 0 -rev;
        
        return (int)rev;
        
    }
	
	public static void main(String[] args) {
				
		System.out.println(reverse(-1563847412));
	}
}
