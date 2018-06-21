package practice.dev.graph.algo;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import practice.dev.graph.ds.Graph;

public class GraphBreadthFirstTraversal {

	/*
	 * It's similar to the level order tree traversal
	 * A vertex gets processed first and all its adjacent vertex gets processed then
	 */
	public static <T extends Comparable<T>> void traverse(Graph<T> graph, int[] visited, T currentVertex) {
		Queue<T> queue = new PriorityQueue<>();
		queue.add(currentVertex);
		T vertex;
		while(!queue.isEmpty()) {
			vertex = queue.poll();
			if(visited[(Integer)vertex] == 1) {
				continue;
			}
			System.out.println(vertex + "->");
			visited[(Integer)vertex] = 1;
			List<T> adjacentVertices = graph.getAdjacentVertices(vertex);
			for(T v : adjacentVertices) {
				if(visited[(Integer)v] != 1) {
					queue.add(v);
				}
			}
		}
	}
	
}
