package practice.dev.graph.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node<T extends Comparable<T>> {

	private T vertex;
	private Set<T> adjacentVertices = new HashSet<>();
	
	public Node(T vertex) {
		this.vertex = vertex;
	}
	
	public T getVertex() {
		return this.vertex;
	}
	
	public void addEdge(T vertex) {
		this.adjacentVertices.add(vertex);
	}
	
	public List<T> getAdjacentVertices() {
		List<T> sortedList = new ArrayList<>(this.adjacentVertices);
		Collections.sort(sortedList);
		return sortedList;
	}

}
