package practice.dev.graph.algo;

import java.util.List;

import practice.dev.graph.ds.Graph;

public class GraphDepthFirstTraversal {

	/*
	 * It's similar to the post order tree traversal
	 * A vertex gets processed after all its adjacent vertex gets processed
	 */
	public static <T extends Comparable<T>> void traverse(Graph<T> graph, int[] visited, T currentVertex) {
		if(visited[(Integer) currentVertex] == 1) {
			return;
		}
		visited[(Integer)currentVertex] = 1;
		
		List<T> adjacentVertices = graph.getAdjacentVertices(currentVertex);
		for(T vertex : adjacentVertices) {
			traverse(graph, visited, vertex);
		}
		
		System.out.println(currentVertex + "->");
	}
	
}
