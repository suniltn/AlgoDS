package com.chandra.structures.trees;

public class ConstructBTUsingInOrderAndDFS {
	static int indexDFS = 0;

	//this is very similar to constructing BT using Inorder and level order
	// here you just need to keep global index for elements in dfs arrays, since first element in dfs is the root of the tree and elements to left of root are left subtree and to right are rightsubtree
	// recursively go through all the elements to construct the tree
	
	public static Node makeBTree(int[] inorder, int[] DFS, int iStart, int iEnd) {
		if (iStart > iEnd) {
			return null;
		}
		int rootVal = DFS[indexDFS];
		Node root = new Node(rootVal);
		indexDFS++;
		if (iStart == iEnd) {
			return root;
		}
		int index = findIndex(inorder, rootVal, iStart, iEnd);
		root.left = makeBTree(inorder, DFS, iStart, index - 1);
		root.right = makeBTree(inorder, DFS, index + 1, iEnd);

		return root;
	}

	public static int findIndex(int[] inorder, int value, int iStart, int iEnd) {
		int x = -1;
		for (int i = iStart; i <= iEnd; i++) {
			if (value == inorder[i]) {
				x = i;
			}
		}
		return x;
	}

	public static void printINORDER(Node root) {
		if (root != null) {
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}

	public static void main(String args[]) {
		int[] inOrder = { 8, 4, 2, 5, 1, 6, 3, 7, 9 };
		int[] DFS = { 1, 2, 4, 8, 5, 3, 6, 7, 9 };
		System.out.println("inorder traversal of constructed tree : ");
		printINORDER(makeBTree(inOrder, DFS, 0, inOrder.length - 1));
	}
}
