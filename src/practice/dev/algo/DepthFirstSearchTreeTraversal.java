package practice.dev.algo;

import java.util.Stack;

public class DepthFirstSearchTreeTraversal {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if (x.right != null)
				s.add(x.right);
			if (x.left != null)
				s.add(x.left);
			System.out.print(" " + x.data);
		}
	}

	public static void main(String args[]) {
		Node root = new DepthFirstSearchTreeTraversal().new Node(1);
		root.left = new DepthFirstSearchTreeTraversal().new Node(2);
		root.left.left = new DepthFirstSearchTreeTraversal().new Node(4);
		root.left.right = new DepthFirstSearchTreeTraversal().new Node(5);
		root.right = new DepthFirstSearchTreeTraversal().new Node(3);
		root.right.left = new DepthFirstSearchTreeTraversal().new Node(6);
		root.right.right = new DepthFirstSearchTreeTraversal().new Node(7);

		DepthFirstSearchTreeTraversal b = new DepthFirstSearchTreeTraversal();
		System.out.println("Depth-First-Search : ");
		b.DFS(root);
	}
}
