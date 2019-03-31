package br.com.data.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

	static class Edge {
		int src, dest;
		
		Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}
	
	List<List<Integer>> adjacents = new ArrayList<>();
	
	public Graph(List<Edge> edges) {
		for (int i = 0; i < edges.size(); i++) {
			adjacents.add(i, new ArrayList<>());
		}
		
		for(Edge current : edges) {
			adjacents.get(current.src).add(current.dest);
		}
	}
	
	private static void printGraph(Graph graph) {
		int src = 0;
		int n = graph.adjacents.size();
		
		while (src < n){
			for (int dest : graph.adjacents.get(src))
				System.out.print("(" + src + " --> " + dest + ")\t");

			System.out.println();
			src++;
		}
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1), new Edge(1, 2),
				new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
				new Edge(4, 5), new Edge(5, 4)
				);
		Graph graph = new Graph(edges);
		printGraph(graph);
	}
}
