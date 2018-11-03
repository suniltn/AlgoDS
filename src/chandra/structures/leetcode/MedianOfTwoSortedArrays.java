package com.chandra.structures.leetcode;


public class MedianOfTwoSortedArrays {

		double singlArray(int[] A, int left, int right) {
			int mid = (left + right + 1)/2;
			int size = right - left + 1;
			
			return size % 2 == 0 ? (A[mid-1] + A[mid])/2.0 : A[mid];
			
		}
		
		double baseCase1(int med, int[] C, int left, int right) {
			int size = right - left + 1;
			if (size == 1)
			    return (med+C[0])/2.0;
			int mid = (left + right + 1) / 2;
			if (size % 2 == 0) {
			    int a = C[mid - 1], b = C[mid];
			    if (med <= a)
			      return a;
			    else if (med <= b)
			      return med;
			    else /* med > b */
			      return b;
			 } else {
			    int a = C[mid - 1], b = C[mid], c = C[mid + 1];
			    if (med <= a)
			      return (a+b) / 2.0;
			    else if (med <= c)
			      return (med+b) / 2.0;
			    else /* med > c */
			      return (b+c) / 2.0;
			  }
		}
		
		//http://articles.leetcode.com/-of-two-sorted-arrays#comment-674
		double baseCase2(int med1, int med2, int C[], int left, int right) {
			int size = right - left + 1;
			int mid = (left + right + 1) / 2;
			if (size % 2 == 0) {
				int a = (mid - 2) >= left ? C[mid-2] : Integer.MIN_VALUE;
				int b = C[mid - 1];
				int c = C[mid];
				int d = (mid + 1) <= right ? C[mid+1] : Integer.MAX_VALUE;
				System.out.println(med1 +" "+med2+" "+a+" "+b+" "+c+" "+d);
				if (med2 <= b) return (b+Math.max(a, med2)) / 2.0;
				if (med1 <= b) return (b + Math.min(c, med2)) / 2.0;
				if (med1 >= c) return (c + Math.min(d, med1)) / 2.0;
				if (med2 >= c) return (c + Math.max(b, med1)) / 2.0;
				return (med1+med2)/2.0;
			} else {
				int a = C[mid-1], b = C[mid], c = C[mid+1];
				if (med1 >= b) return Math.min(med1, c);
				if (med2 <= b) return Math.max(a, med2);
				else return b;
			}
		}
		
		/**
		 	Key idea here is to identify where the median lies in two arrays by discards the elements 
		 	from arrays that are not required
		 */
		double median(int[] A, int aLeft, int aRight, int[] B, int bLeft, int bRight) {
			int aSize=aRight-aLeft+1;
			int bSize=bRight-bLeft+1;
			System.out.println("aLeft:" + aLeft + " aRight:" + aRight + " bLeft:"+bLeft+" bRight:"+bRight);
			
			if (aSize == 0) return singlArray(B, bLeft, bRight);
			else if (bSize == 0) return singlArray(A, aLeft, aRight);
			else if (aSize == 1) return baseCase1(A[aLeft], B, bLeft, bRight);
			else if (bSize == 1) return baseCase1(B[bLeft], A, aLeft, aRight);
			else if (aSize == 2) return baseCase2(A[aLeft], A[aRight], B, bLeft, bRight);
			else if (bSize == 2) return baseCase2(B[bLeft], B[bRight], A, aLeft, aRight);
			else {
				int aMid = (aLeft+aRight+1)/2;
				int bMid = (bLeft+bRight+1)/2;
				System.out.println("aMid:"+aMid+" bMid:"+bMid);
				int k; // k tells us how many elements needs to be discarded
				if (A[aMid] <= B[bMid]) {
					System.out.println("Less Than");
					k = (aSize % 2 == 0) ? Math.min(aMid - aLeft - 1, bRight - bMid) : Math.min(aMid - aLeft, bRight-bMid);
					assert(k>0);
					System.out.println("k=" + k);
					return median(A, aLeft+k, aRight, B, bLeft, bRight-k);
 				} else { // A[aMid] > B[aMid]
 					System.out.println("Greater than");
					k = (bSize % 2 == 0) ? Math.min(aRight-aMid, bMid-bLeft-1) : Math.min(aRight - aMid, bMid-bLeft);
					assert(k>0);
					System.out.println("k=" + k);
					return median(A, aLeft, aRight-k, B, bLeft+k, bRight);
				}
			}
		}
		
		
		
		public double findSortedArrays(int[] A, int[] B) {
			return median(A, 0, A.length-1, B, 0, B.length-1);
		}
		
		
		public static void main(String[] aRightgs) {
			int a[] = { 1,3,5,7,9 };
			int b[] = { 2,4,6,8,10};
			MedianOfTwoSortedArrays med = new MedianOfTwoSortedArrays();
			
			//System.out.println(findSortedaRightrays(a, a.length, b, b.length));
			System.out.println(med.findSortedArrays(a, b));
		}
		
	
}
