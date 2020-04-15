package practice.dev.graph.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphIsATree {

    private List<Integer> vertices;
    private List<ArrayList<Integer>> adjacencyListOrEdges;

    public GraphIsATree(List<Integer> vertices, List<ArrayList<Integer>> adjacencyListOrEdges) {
        this.vertices = vertices;
        this.adjacencyListOrEdges = adjacencyListOrEdges;
    }

    public static void main(String[] args) {

    }

    /**
     * Validate NoCycle and NoDisconnectedVertex. Our approach is DFS
     */
    public boolean isTree() {

        Boolean[] visited = new Boolean[this.vertices.size()];

        // initiailize all with false
        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // Assumption and Approach: start from 0 as a root and visit all the nodes recursively
        if(hasCycle(0, visited, -1)) {
            return false;
        }

        // if any vertex is missing from the visit that means it's island and not part of the tree.
        // Hence Graph is not a tree
        for(Integer i : vertices) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int vIndex, Boolean[] visited, int parent) {
        boolean result = false;
        visited[vIndex] = true;
        Iterator<Integer> adjacentVertices = this.adjacencyListOrEdges.get(vIndex).iterator();
        while(adjacentVertices.hasNext()) {
            Integer temp = adjacentVertices.next();
            if(!visited[temp]) {
                if(hasCycle(temp, visited, vIndex)) {
                    result = true;
                    break;
                }
            } else if(temp != parent) {
                result = true;
                break;
            }
        }
        return result;
    }

}
