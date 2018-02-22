package practice.dev.problemsolving;

import java.util.LinkedList;

class MyLinkedList extends LinkedList<Integer> {
}

class Graph {
	int V;
	MyLinkedList[] lists;

	public Graph(int V) {
		this.V = V;
		this.lists = new MyLinkedList[V];

		for (int i = 0; i < V; i++)
			lists[i] = new MyLinkedList();
	}

	void addEdge(int u, int v) {
		lists[u].add(v);
	}

	void printGraph() {
		int i = 0;
		for (MyLinkedList l : lists) {
			System.out.print(i++ + " : ");
			for (Integer val : l)
				System.out.print(val + " ");
			System.out.println();
		}
	}

	void topologicalSortUtil(int u, boolean[] visited, LinkedList<Integer> res) {
		visited[u] = true;

		for (Integer v : lists[u]) {
			if (!visited[v])
				topologicalSortUtil(v, visited, res);
		}

		res.addFirst(u);
	}

	LinkedList<Integer> topologicalSort() {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> res = new LinkedList<Integer>();

		for (int i = 0; i < V; i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, res);
		}

		return res;
	}
}

class SortedDictionaryOfAnAlienLanguageFindOrderOfCharactersApproach2 {

	static void printOrder(String[] dict, int alpha) {
		int n = dict.length;

		Graph g = new Graph(alpha);

		for (int i = 0; i < n - 1; i++) {
			String s1 = dict[i], s2 = dict[i + 1];
			int l = Math.min(s1.length(), s2.length());

			for (int j = 0; j < l; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					g.addEdge(s1.charAt(j) - 'a', s2.charAt(j) - 'a');
					break;
				}
			}
		}

		LinkedList<Integer> res = g.topologicalSort();

		for (Integer i : res)
			System.out.print((char) (i + 'a') + " ");
		System.out.println();

	}

	static void printDictionary(String[] arr) {
		for (String s : arr)
			System.out.print("'" + s + "' ");
		System.out.println();
	}

	public static void main(String[] args) {
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };

		printDictionary(dict);

		System.out.println("\nOrder:");
		printOrder(dict, 4);
	}
}
