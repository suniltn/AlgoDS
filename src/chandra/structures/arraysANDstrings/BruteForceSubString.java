package com.chandra.structures.arraysANDstrings;

public class BruteForceSubString {
	
	public int search(String str, String pat) {
		int m = str.length();
		int n = pat.length();
		
		// we want move i pointer till last lenght of pattern in string
		for (int i=0;i<m-n;i++) {
			int j;
			for (j=0;j<n;j++) {
				// compare each char in pattern with char in string, if it doesn't match
				// just break the loop to move i pointer to next char string for pattern match
				if (str.charAt(i+j) != pat.charAt(j))
					break;
			}
			/*int j = 0;
			// the above for loop can be rewritten in while loop
			
			while (j<m && str.charAt(i+j) == pat.charAt(j))
					j++;
			
			*/
			
			// if j pointer reaches the end of the pattern that means there is a match found at position i
			// in string
			if (j == n) return i; // found
		}
		return m; // not found
	}
	
	public static void main(String[] args) {
		BruteForceSubString bfs = new BruteForceSubString();
		String txt = "ggccgggccctgtgaccacagtccacatcacaccaggacacagaggaagggccgggccctgtgaccacagtccacatcacaccaggacacagaggaagggccgggcctcatgaccacagt";
		String pattern = "gtccacatcaca";
		
		long startTime = System.nanoTime();
		int result = bfs.search(txt, pattern);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Total Elapsed Time : " + duration);
		System.out.println("text:    " + txt);
		System.out.print("pattern: ");
		for (int i=0;i<result;i++)
			System.out.print(" ");
		System.out.println(pattern);
	}
}
