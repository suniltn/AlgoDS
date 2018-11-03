package com.chandra.structures.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
        	int size = nodes.size();
        	LinkedList<Integer> level = new LinkedList<>();
        	for (int i=0;i<size;i++) {
        		TreeNode node = nodes.poll();
        		level.add(node.val);
        		nodes.add(node.left);
        		nodes.add(node.right);
        	}
        	levelOrderList.add(level);
        }
        return levelOrderList;
    }
	
	public static void main(String[] args) {
		
	}
}



class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
