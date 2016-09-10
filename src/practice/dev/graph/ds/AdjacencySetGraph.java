package practice.dev.graph.ds;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph<T extends Comparable<T>> implements Graph<T> {
	
	private List<Node<T>> vertexList = new ArrayList<>();
	private GraphType graphType = GraphType.DIRECTED;
	private int numVertices = 0;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AdjacencySetGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		this.graphType = graphType;
		Node<T> temp = null;
		for(int i = 0; i < numVertices; i++) {
			temp = new Node(i);
			this.vertexList.add(temp);
		}
	}
	
	@Override
	public List<T> getAdjacentVertices(T v) {
		if((int)v >= this.numVertices || (int)v < 0) {
			throw new IllegalArgumentException("Vertes is not valid: " + v);
		}
		
		return this.vertexList.get((int)v).getAdjacentVertices();
	}

	@Override
	public void addEdge(T v1, T v2) {
		if((int)v1 >= this.numVertices || (int)v1 < 0 || (int)v2 >= this.numVertices || (int)v2 < 0) {
			throw new IllegalArgumentException("Vertex is not valid: " + v1 + ", " + v2);
		}
		
		this.vertexList.get((int)v1).addEdge(v2);
		if(this.graphType == GraphType.UNDIRECTED) {
			this.vertexList.get((int)v2).addEdge(v2);
		}
	}

}
