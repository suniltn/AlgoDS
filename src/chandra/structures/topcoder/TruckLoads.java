package com.chandra.structures.topcoder;

/**
Problem Statement
We have a pile of crates at our warehouse that we want to load onto trucks. Our plan is to divide the pile in half forming two smaller piles, then continuing dividing each of the small piles in half until we get piles that will fit on a truck. (Of course, when we divide an odd number of crates in "half", one of the resulting piles will have one more crate than the other.) Our problem is to determine how many trucks we will need to ship the crates.
Create a class Truckloads that contains a method numTrucks that is given numCrates (the number of crates at the warehouse) and loadSize (the maximum number of crates that will fit in a truck) and that returns the number of trucks required.

Definition
Class: Truckloads
Method: numTrucks
Parameters: int, int
Returns: int
Method signature: int numTrucks(int numCrates, int loadSize)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- numCrates will be between 2 and 10,000, inclusive.
- loadSize loadSize will be be between 1 and (numCrates - 1), inclusive.
Examples
0)
14
3
Returns: 6
After the first division we have two piles each with 7 crates. Each of these piles must be divided giving us 2 piles of 3 and 2 piles of 4. The piles with 4 crates must be further divided giving us 2 piles of 3 and 4 piles of 2. Each of these piles fits into a truck, so we need 6 trucks.
1)
15
1
Returns: 15
We will eventually end up with 15 piles, each with just 1 crate.
2)
1024
5
Returns: 256
1024 divides in half very nicely. We eventually end up with 256 piles, each containing 4 crates.

*/

public class TruckLoads {
	
	public int numTrucks(int numCrates, int loadSize) {
		if (numCrates <= loadSize) return 1;
		
		if (numCrates%2 == 0)
			return numTrucks(numCrates/2, loadSize) + numTrucks(numCrates/2, loadSize);
		else
			return 1 + numTrucks(numCrates/2, loadSize) + numTrucks(numCrates/2, loadSize);
	}
	
	public static void main(String[] args) {
		TruckLoads loads = new TruckLoads();
		System.out.println(loads.numTrucks(14, 3));
		System.out.println(loads.numTrucks(15, 1));
		System.out.println(loads.numTrucks(1024, 4));
	}
}

