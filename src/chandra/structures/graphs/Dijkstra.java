package com.chandra.structures.graphs;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

}

class Graph {
	private final Map<String, Vertex> graph;
	
	public static class Edge {
		public final String v1, v2;
		public final int dist;
		public Edge(String v1, String v2, int dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}
	}
	
	public static class Vertex implements Comparable<Vertex> {
		public final String name;
		public int dist = Integer.MAX_VALUE;
		public Vertex previous = null;
		public final Map<Vertex, Integer> neighbours = new HashMap<>();
		
		public Vertex(String name) {
			this.name = name;
		}
		
		private void printPath() {
			if (this == this.previous) {
				System.out.printf("%s", this.name);
			} else if (this.previous == null) {
				System.out.printf("%s(unreached", this.name);
			} else {
				this.previous.printPath();
				System.out.printf(" -> %s(%d)", this.name, this.dist);
			}
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(dist, o.dist);
		}
	}
	
	public Graph(Edge[] edges) {
		graph = new HashMap<>(edges.length);
		
		//one pass to find all vertices
		for (Edge e : edges) {
			if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1))
		}
		if (!graph.containsKey(.v1))
	}
}
