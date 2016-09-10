package practice.dev.graph.ds;

import java.util.List;

public interface Graph<T extends Comparable<T>> {
	
	enum GraphType {
		DIRECTED,
		UNDIRECTED
	}

	List<T> getAdjacentVertices(T v);
	void addEdge(T v1, T v2);

}
