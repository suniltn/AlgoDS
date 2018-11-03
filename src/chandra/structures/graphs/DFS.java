package com.chandra.structures.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	int V;
	LinkedList<Integer> adj[];
	
	public DFS(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i=0;i<V;i++)
			adj[i] = new LinkedList<>();
	}
	
	private void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	// The function to do DFS traversal. It uses recursive DFSUtil()
	void dfs(int start) {
		// Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        dfsUtil(start, visited);
	}
	
	//this function is used for DFS traversal even though if a vertex is not reachable
	void dfs() {
		// Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        for (int i=0;i<V;i++)
        	if (visited[i] == false)
        		dfsUtil(i, visited);
	}
	
	// A function used by DFS
	void dfsUtil(int start, boolean[] visited) {
		visited[start] = true;
		System.out.println(start + " ");
		
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[start].listIterator();
		while(it.hasNext()) {
			int next = it.next();
			if (!visited[next]) {
				dfsUtil(next, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		DFS g = new DFS(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs();
	}
}
