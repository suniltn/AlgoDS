package com.chandra.structures.trees;

public class ConstructBTUsingInOrderAndLevelOrder {
/**	
	Let us consider the above example.

	in[] = {4, 8, 10, 12, 14, 20, 22};
	level[] = {20, 8, 22, 4, 12, 10, 14};

	In a Levelorder sequence, the first element is the root of the tree. So we know ’20’ is root for given sequences. By searching ’20’ in Inorder sequence, 
	we can find out all elements on left side of ‘20’ are in left subtree and elements on right are in right subtree. So we know below structure now.

	             20
	           /    \
	          /      \ 
	 {4,8,10,12,14}  {22}   
	Let us call {4,8,10,12,14} as left subarray in Inorder traversal and {22} as right subarray in Inorder traversal.
	In level order traversal, keys of left and right subtrees are not consecutive. So we extract all nodes from level order traversal which are in left subarray of Inorder traversal. 
	To construct the left subtree of root, we recur for the extracted elements from level order traversal and left subarray of inorder traversal. In the above example, we recur for following two arrays.
	// Recur for following arrays to construct the left subtree
	In[]    = {4, 8, 10, 12, 14}
	level[] = {8, 4, 12, 10, 14} 
	Similarly, we recur for following two arrays and construct the right subtree.

	// Recur for following arrays to construct the right subtree
	In[]    = {22}
	level[] = {22} 

*/	
	public static Node constructBTUtil(int[] inorder, int[] levelorder, int iStart, int iEnd) {
		// Base case
		if(iStart > iEnd) return null;
		
		// first element of level order is always the root element
		int rootVal = levelorder[0];
		Node root = new Node(rootVal);
		
		//if there's only one element in inorder
		if (iStart == iEnd) return root;
		
		//find the index of root element in inorder array, elements to left are left subtree and elements to right are right substree
		int index = findIndex(inorder, rootVal, iStart, iEnd);
		
		//In level order traversal, keys of left and right subtrees are not consecutive. So we extract all nodes from level order traversal which are in left subarray of Inorder traversal.
		// For this we create two new arrays one for left and one for right
		int[] newLeftLevel = newLevelOrder(inorder, levelorder, iStart, index-1); // new inorder elements of left subtree will be elements towards left of root element index
		int[] newRightLevel = newLevelOrder(inorder, levelorder, index+1, iEnd); // new inorder elements of right subtree will be elements towards right of root element index
		
		// now recursively build the left and right subtrees
		root.left = constructBTUtil(inorder, newLeftLevel, iStart, index-1); //// new inorder elements of left subtree will be elements towards left of root element index
		root.right = constructBTUtil(inorder, newRightLevel, index+1, iEnd); // new inorder elements of right subtree will be elements towards right of root element index
		
		return root;
		
	}
	
	public static int[] newLevelOrder(int[] inorder, int[] levelorder, int iStart, int iEnd) {
		int[] newLevel = new int[iEnd-iStart+1]; // array to start new level order elements and size will be equal to inorder elements size
		int x=0;
		
		// check every element from level order against the shortned inorder elements and if it matches then store the element to newLevel array
		// for this we use findindex method we defined to check if it's present or not, if present then add element to newLevel array if not go to next element
		for (int i=0;i<levelorder.length;i++) {
			if (findIndex(inorder, levelorder[i], iStart, iEnd) != -1)
				newLevel[x++] = levelorder[i];
		}
		return newLevel;
	}
	
	public static int findIndex(int[] inorder, int value, int start, int end) {
		int x=-1;
		for (int i=start;i<=end;i++)
			if (inorder[i] == value) x=i;
		return x;
	}
	
	public static Node constructBT(int[] inorder, int[] levelorder) {
		return constructBTUtil(inorder, levelorder, 0, inorder.length-1);
	}
	
	public static void printINORDER(Node root) {
		if (root != null) {
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}
	
	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] levelorder = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("inorder traversal of constructed tree : ");
		printINORDER(constructBT(inorder, levelorder));
		
	}
}
