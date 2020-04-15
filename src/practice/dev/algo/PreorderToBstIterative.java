package practice.dev.algo;

import java.util.List;
import java.util.Stack;

public class PreorderToBstIterative {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node constructTree(int[] preorder) {
		Stack<Node> s = new Stack<Node>();
		Node root = new Node(preorder[0]);
		s.add(root);
		for (int i = 1; i < preorder.length; i++) {
			Node x = null;
			while (!s.isEmpty() && preorder[i] > s.peek().data) {// pop out all
																	// the data
																	// till we
																	// get least
																	// data that
																	// is just
																	// greater
																	// than root
																	// data
				x = s.pop();
			}
			if (x != null) {
				x.right = new Node(preorder[i]);
				s.push(x.right);
			} else {
				s.peek().left = new Node(preorder[i]);
				s.push(s.peek().left);
			}
		}
		return root;
	}

	public Node constructTree(List<Integer> preorder) {
		Stack<Node> s = new Stack<Node>();
		Node root = new Node(preorder.get(0));
		s.add(root);
		for (int i = 1; i < preorder.size(); i++) {
			Node x = null;
			while (!s.isEmpty() && preorder.get(i) > s.peek().data) {
				x = s.pop();
			}
			if (x != null) {
				x.right = new Node(preorder.get(i));
				s.push(x.right);
			} else {
				s.peek().left = new Node(preorder.get(i));
				s.push(s.peek().left);
			}
		}
		return root;
	}

	public void displayTree(Node root) {
		if (root != null) {
			displayTree(root.left);
			System.out.print(" " + root.data);
			displayTree(root.right);
		}
	}

	public static void main(String args[]) {
		PreorderToBstIterative p = new PreorderToBstIterative();
		int[] preOrder = { 10, 5, 2, 7, 15, 12, 20 };
		Node root = p.constructTree(preOrder);
		System.out.println("Inorder Traversal of Constructed Tree : ");
		p.displayTree(root);
	}

}
