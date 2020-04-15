package practice.dev.algo;

/* importing the inbuilt java classes required for the program */
import java.util.Queue;
import java.util.LinkedList;

// Iterative Queue based Java program to do level order traversal
// of Binary Tree
public class BinaryTreeLevelOrderTraversalIteratively {

    /* Class to represent Tree node */
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    /* Class to print Level Order Traversal */
    class BinaryTree {

        Node root;

        /* Given a binary tree. Print its nodes in level order
        using array for implementing queue */
        void printLevelOrder() {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {

			/* poll() removes the present head.
			For more information on poll() visit
			http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                /*Enqueue left child */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                /*Enqueue right child */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
    }

    public static void main(String args[]) {
		/* creating a binary tree and entering
		the nodes */
        BinaryTree tree_level = new BinaryTreeLevelOrderTraversalIteratively().new BinaryTree();
        tree_level.root = new BinaryTreeLevelOrderTraversalIteratively().new Node(1);
        tree_level.root.left = new BinaryTreeLevelOrderTraversalIteratively().new Node(2);
        tree_level.root.right = new BinaryTreeLevelOrderTraversalIteratively().new Node(3);
        tree_level.root.left.left = new BinaryTreeLevelOrderTraversalIteratively().new Node(4);
        tree_level.root.left.right = new BinaryTreeLevelOrderTraversalIteratively().new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}