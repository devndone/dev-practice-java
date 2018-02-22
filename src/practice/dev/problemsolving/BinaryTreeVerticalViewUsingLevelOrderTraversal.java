package practice.dev.problemsolving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalViewUsingLevelOrderTraversal {

	Node root;

	void verticaleOrder(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();

		TreeMap<Integer, LinkedList<Node>> distanceMap = new TreeMap<>();

		distanceQueue.add(0);
		queue.add(root);

		while (!queue.isEmpty()) {

			Node tempNode = queue.poll();
			int distance = distanceQueue.poll();

			if (distanceMap.get(distance) == null) {
				distanceMap.put(distance, new LinkedList<Node>());
			}

			distanceMap.get(distance).add(tempNode);

			if (tempNode.left != null) {
				distanceQueue.add(distance - 1);
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				distanceQueue.add(distance + 1);
				queue.add(tempNode.right);
			}
		}
		printVerticaleOrder(distanceMap);
	}

	void printVerticaleOrder(TreeMap<Integer, LinkedList<Node>> distanceMap) {
		for (int key : distanceMap.keySet()) {
			for (Node node : distanceMap.get(key))
				System.out.print(node.data + " ");
			System.out.println("");
		}

	}

	// Driver program to test the above functions
	public static void main(String args[]) {

		BinaryTreeVerticalViewUsingLevelOrderTraversal tree = new BinaryTreeVerticalViewUsingLevelOrderTraversal();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.left = new Node(10);
		tree.root.right.right.left.right = new Node(11);
		tree.root.right.right.left.right.right = new Node(12);

		System.out.println("vertical order traversal is :");
		tree.verticaleOrder(tree.root);
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}
