package practice.dev.algo;

/**
 * 
 * @author dev
 *
 * 
 *         Input: Inorder and pos­torder traversals
 * 
 *         Approach:
 * 
 *         int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
 * 
 *         int[] pos­tOrder = { 4, 5, 2, 6, 7, 3, 1 };
 * 
 *         Last ele­ment in the pos­torder [] will be the root of the tree, here
 *         it is 1. Now the search ele­ment 1 in inorder[], say you find it at
 *         posi­tion i, once you find it, make note of ele­ments which are left
 *         to i (this will con­struct the left­sub­tree) and ele­ments which are
 *         right to i ( this will con­struct the rightSubtree). Sup­pose in
 *         pre­vi­ous step, there are X num­ber of ele­ments which are left of
 *         ‘i’ (which will con­struct the left­sub­tree), take first X ele­ments
 *         from the pos­torder[] tra­ver­sal, this will be the post order
 *         tra­ver­sal for ele­ments which are left to i. sim­i­larly if there
 *         are Y num­ber of ele­ments which are right of ‘i’ (which will
 *         con­struct the right­sub­tree), take next Y ele­ments, after X
 *         ele­ments from the pos­torder[] tra­ver­sal, this will be the post
 *         order tra­ver­sal for ele­ments which are right to i From pre­vi­ous
 *         two steps con­struct the left and right sub­tree and link it to
 *         root.left and root.right respectively. See the pic­ture for bet­ter
 *         explanation.
 */
public class MakeTreeFromInorderAndPostorder {

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

	public static int pIndex = 0;

	public Node makeBTree(int[] inOrder, int[] postOrder, int iStart, int iEnd,
			int postStart, int postEnd) {
		if (iStart > iEnd || postStart > postEnd) {
			return null;
		}

		int rootValue = postOrder[postEnd];
		Node root = new Node(rootValue);
		pIndex++;

		if (iStart == iEnd) {
			return root;
		}
		int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
		root.left = makeBTree(inOrder, postOrder, iStart, index - 1, postStart,
				postStart + index - (iStart + 1));
		root.right = makeBTree(inOrder, postOrder, index + 1, iEnd, postStart
				+ index - iStart, postEnd - 1);
		// }
		return root;
	}

	public int getInorderIndex(int[] inOrder, int start, int end, int data) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public void printINORDER(Node root) {
		if (root != null) {
			printINORDER(root.left);
			System.out.print("" + root.data);
			printINORDER(root.right);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };
		MakeTreeFromInorderAndPostorder i = new MakeTreeFromInorderAndPostorder();
		Node x = i.makeBTree(inOrder, postOrder, 0, inOrder.length - 1, 0,
				postOrder.length - 1);
		i.printINORDER(x);

	}
}
