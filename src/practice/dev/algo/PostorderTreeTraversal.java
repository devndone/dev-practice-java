package practice.dev.algo;

import java.util.Stack;

public class PostorderTreeTraversal {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void postorderRecursive(Node root) {
		if (root != null) {
			postorderRecursive(root.left);
			postorderRecursive(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void postorderIteration(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		// push the root node into first stack.
		s1.push(root);
		while (!s1.isEmpty()) {
			// take out the root and insert into second stack.
			Node temp = s1.pop();
			s2.push(temp);
			// now we have the root, push the left and right child of root into
			// the first stack.
			if (temp.left != null) {
				s1.push(temp.left);
			}
			if (temp.right != null) {
				s1.push(temp.right);
			}
		}
		// once the all node are traversed, take out the nodes from second stack
		// and print it.
		System.out.println("Postorder Traversal: ");
		while (!s2.isEmpty()) {
			System.out.print(s2.pop());
		}
	}

	public static void main(String[] args) {
		Node root = new PostorderTreeTraversal().new Node(1);
		root.left = new PostorderTreeTraversal().new Node(2);
		root.right = new PostorderTreeTraversal().new Node(3);
		root.left.left = new PostorderTreeTraversal().new Node(4);
		root.left.right = new PostorderTreeTraversal().new Node(5);
		root.right.left = new PostorderTreeTraversal().new Node(6);
		root.right.right = new PostorderTreeTraversal().new Node(7);

		PostorderTreeTraversal i = new PostorderTreeTraversal();
		i.postorderRecursive(root);
		System.out.println();
		i.postorderIteration(root);
	}

}
