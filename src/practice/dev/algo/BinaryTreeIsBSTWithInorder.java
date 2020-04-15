package practice.dev.algo;

/**
 *
 * @author dev
 *
 *
 *         A program to check if a binary tree is BST or not :
 *
 *         A binary search tree (BST) is a node based binary tree data structure
 *         which has the following properties. • The left subtree of a node
 *         contains only nodes with keys less than the node’s key. • The right
 *         subtree of a node contains only nodes with keys greater than the
 *         node’s key. • Both the left and right subtrees must also be binary
 *         search trees
 */

// Java implementation to check if given Binary tree
// is a BST or not

public class BinaryTreeIsBSTWithInorder {

	/*
	 * Class containing left and right child of current node and key value
	 */
	class Node {

		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	// Root of the Binary Tree
	Node root;

	boolean isBST() {
		return isBST(root);
	}

	/*
	 * returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST(Node node) {

		if (node == null) {
			return true;
		}
		Node prev = null;
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		// if (root != null) {
		if (!isBST(node.left))
			return false;

		// allows only distinct values node
		if (prev != null && node.data <= prev.data)
			return false;
		prev = node;
		if (!isBST(node.right))
			return false;
		// }
		return true;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTreeIsBSTWithInorder tree = new BinaryTreeIsBSTWithInorder();
		tree.root = new BinaryTreeIsBSTWithInorder().new Node(4);
		tree.root.left = new BinaryTreeIsBSTWithInorder().new Node(2);
		tree.root.right = new BinaryTreeIsBSTWithInorder().new Node(5);
		tree.root.left.left = new BinaryTreeIsBSTWithInorder().new Node(1);
		tree.root.left.right = new BinaryTreeIsBSTWithInorder().new Node(3);

		if (tree.isBST(tree.root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
