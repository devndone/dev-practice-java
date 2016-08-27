package practice.dev.algo;

import java.util.Stack;

public class InorderTreeTraversal {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void inorderRecursive(Node root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.data + " ");
			inorderRecursive(root.right);
		}
	}

	public void inorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// Go to the left extreme insert all the elements to stack
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			// check if Stack is empty, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack , print it and add the nodes at
			// the right to the Stack
			root = s.pop();
			System.out.print(root.data + " ");
			root = root.right;
		}
	}

	public static void main(String[] args) {
		Node root = new InorderTreeTraversal().new Node(1);
		root.left = new InorderTreeTraversal().new Node(2);
		root.right = new InorderTreeTraversal().new Node(3);
		root.left.left = new InorderTreeTraversal().new Node(4);
		root.left.right = new InorderTreeTraversal().new Node(5);

		InorderTreeTraversal i = new InorderTreeTraversal();
		i.inorderRecursive(root);
		System.out.println();
		i.inorderIteration(root);
	}

}
