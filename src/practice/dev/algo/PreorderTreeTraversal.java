package practice.dev.algo;

import java.util.Stack;

public class PreorderTreeTraversal {
	
	public void preorderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRecursive(root.left);
			preorderRecursive(root.right);
		}
	}

	public void preorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// First print the root node and then add left node
			while (root != null) {
				System.out.print(root.data + " ");
				s.push(root);
				root = root.left;
			}
			// check if Stack is emtpy, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack and go right to the tree
			root = s.pop();
			root = root.right;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		PreorderTreeTraversal i = new PreorderTreeTraversal();
		i.preorderRecursive(root);
		System.out.println();
		i.preorderIteration(root);
	}

}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}
