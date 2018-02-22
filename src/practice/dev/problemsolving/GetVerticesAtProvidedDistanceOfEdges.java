package practice.dev.problemsolving;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetVerticesAtProvidedDistanceOfEdges {
	public static void main(String[] args) throws java.lang.Exception {

		// use the following code to fetch input from console
		String line;
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		line = inp.readLine();
		int numOfNodes = Integer.parseInt(line.substring(0, 1));
		int edgeDistance = Integer.parseInt(line.substring(1));
		//System.out.println("numOfNodes = " + numOfNodes);
		//System.out.println("edgeDistance = " + edgeDistance);
		Vertex root = null;
		Map<Integer, Vertex> m = new HashMap<>();
		for (int i = 1; i < numOfNodes; i++) {
			line = inp.readLine();
			//System.out.println("line.substring(0, 1) = " + line.substring(0, 1));
			//System.out.println("line.substring(1) = " + line.substring(1));
			Integer ndata = Integer.parseInt(line.substring(0, 1));
			Vertex v1 = m.get(ndata);
			if(v1 == null) {
				v1 = new Vertex(ndata);
				m.put(ndata, v1);
			}
			if (root == null) {
				root = v1;
			}
			ndata = Integer.parseInt(line.substring(1));
			Vertex v2 = m.get(ndata);
			if(v2 == null) {
				v2 = new Vertex(ndata);
				m.put(ndata, v2);
			}
			v1.adjVertices.add(v2);
		}
		List<Vertex> adjv = new ArrayList<>();
		getAdjNodes(root, edgeDistance, adjv);
		// Use the following code to print output
		System.out.println(adjv.size());
	}

	private static void getAdjNodes(Vertex root, Integer edgeDistance, List<Vertex> adjv) {
		if (root == null) {
			return;
		}
		if (edgeDistance == 1) {
			adjv.addAll(root.adjVertices);
			return;
		}
		for (Vertex v : root.adjVertices) {
			getAdjNodes(v, edgeDistance, adjv);
		}
		--edgeDistance;
	}

	static class Vertex {
		int data;
		List<Vertex> adjVertices;

		Vertex(int d) {
			this.data = d;
			this.adjVertices = new ArrayList<>();
		}
	}

}