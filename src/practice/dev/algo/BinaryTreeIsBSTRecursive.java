package practice.dev.algo;

//Java implementation to check if given Binary tree
//is a BST or not

public class BinaryTreeIsBSTRecursive {

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

	/*
	 * can give min and max value according to your code or can write a function
	 * to find min and max value of tree.
	 */

	int INT_MIN = 1;
	int INT_MAX = 5;

	boolean isBST() {
		return isBST(root);
	}

	/*
	 * returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST(Node node) {
		return (isBSTUtil(node, INT_MIN, INT_MAX));
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		return (isBSTUtil(node.left, min, node.data - 1) && // Allow only
															// distinct values
		isBSTUtil(node.right, node.data + 1, max)); // Allow only distinct
													// values

	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTreeIsBSTRecursive tree = new BinaryTreeIsBSTRecursive();
		tree.root = new BinaryTreeIsBSTRecursive().new Node(4);
		tree.root.left = new BinaryTreeIsBSTRecursive().new Node(2);
		tree.root.right = new BinaryTreeIsBSTRecursive().new Node(5);
		tree.root.left.left = new BinaryTreeIsBSTRecursive().new Node(1);
		tree.root.left.right = new BinaryTreeIsBSTRecursive().new Node(3);

		if (tree.isBST(tree.root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
