package com.chandra.structures.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	int V;
	LinkedList<Integer> adj[];
	
	public BFS(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i=0;i<V;i++)
			adj[i] = new LinkedList<>();
	}
	
	private void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public void bfs(int start) {
		// Mark all the vertices as not visited(By default
        // set as false)
		boolean visited[] = new boolean[V];
		
		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();
		// Mark the current node as visited and enqueue it
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			start = queue.poll();
			System.out.println(start + " ");
			
			// Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
			/*Iterator<Integer> iterator = adj[start].listIterator();
			while(iterator.hasNext()) {
				int next = iterator.next();
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}*/
			//or
			for (Integer v : adj[start]) {
				if (!visited[v]) {
					queue.add(v);
					visited[v] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFS g = new BFS(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfs(2);
	}
	
}


