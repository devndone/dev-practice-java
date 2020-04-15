package practice.dev.algo;

/**
 * 
 * @author dev
 *
A binary tree is balanced when the depth (from the root) of the left and right sub trees of every node differs by 1 or less.
We can check whether a binary tree is balanced or not using recursion.
 *
 */
public class CheckBinaryTreeIsBalanced {
	
	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	/**
	 * 
	Polynomial time algorithm > 

	Take the root. Compute the height of its left and right sub tree.
	If the difference between height of the left and right sub tree is less than or equal to 1, return true.
	Otherwise, return false.
	Repeat these two steps for each node in the given binary tree.

	Worst case time complexity for skewed binary tree is O(n2).
	In that case, the height of the tree is θ(n) and at each level the height is computed which takes O(n)O(n) time.
	*
	*/
	public static boolean checkBinaryTreeIsBalancedOrderOfNSquare(Node root){

	     /* Base case - Empty tree is always balanced */
	     if(root == null)
	          return true;

	     /* Compute height of the left and right subtree and their difference */
	    int heightDifference = computeHeight(root.left) - computeHeight(root.right);

	    if(Math.abs(heightDifference)  <= 1)
	          return checkBinaryTreeIsBalancedOrderOfNSquare(root.left)  && 
	        		  checkBinaryTreeIsBalancedOrderOfNSquare(root.right);
	    else
	          return false;
	    
	 }

	public static int computeHeight(Node root){

	      /* Base case - Tree is empty */
	      if(root == null)
	           return 0;
	      /* Calculate recursively */
	      return Math.max(computeHeight(root.left), computeHeight(root.right)) + 1;
	 }

	/**
	 *  Linear time algorithm ->
		We can optimize the above algorithm and solve the problem in linear time. 
		Instead of computing the height at each level, 
		we can compute it in the same recursion.
		Time complexity = O(n).
	 * 
	 * @param root
	 * @return boolean
	 */
	public static boolean checkBinaryTreeIsBalancedOrderOfN(Node root){

	     if(computeAndCheckHeight(root) == -1)
	          return false;
	     else
	          return true;
	 }

	public static int computeAndCheckHeight(Node root){
	     /* Base case - Tree is empty */
	     if(root == null)
	          return 0;
	     /* Height of left subtree */
	     int leftSubTreeHeight = computeAndCheckHeight(root.left);
	     /* Left subtree is not balanced */
	     if(leftSubTreeHeight == -1)
	          return -1;  

	     /* Height of right subtree */
	     int rightSubTreeHeight = computeAndCheckHeight(root.right);
	     /* Right subtree is not balanced */
	     if(rightSubTreeHeight == -1)
	          return -1;

	     /* Difference in height */
	     int heightDifference = Math.abs(leftSubTreeHeight - rightSubTreeHeight);
	     /* Root node is not balanced */
	     if(heightDifference > 1)
	          return -1;
	     else
	          /* Height of the root node */
	          return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	 }
	
}
