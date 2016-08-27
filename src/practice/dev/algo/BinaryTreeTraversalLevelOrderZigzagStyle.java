package practice.dev.algo;

import java.util.Stack;

import practice.dev.algo.BinarySearchTree.BinaryNode;

public class BinaryTreeTraversalLevelOrderZigzagStyle {
	
	private BinaryNode<Integer> root;
	
	public BinaryTreeTraversalLevelOrderZigzagStyle(BinaryNode<Integer> binaryNode) {
		this.root = binaryNode;
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        final int NUMS = 100;
        final int GAP  =   37;
        int numberOfNodeElements = 0;
        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            t.insert( i );
            ++numberOfNodeElements;
        }
        System.out.println( "Total number of Node Elements in tree is " + numberOfNodeElements);
        
		BinaryTreeTraversalLevelOrderZigzagStyle bt = new BinaryTreeTraversalLevelOrderZigzagStyle(t.getRoot());
		bt.zigzagTraverse();
	}

	public void zigzagTraverse() {
		
		if(root == null) {
			return;
		}
		
		Stack<BinarySearchTree.BinaryNode<Integer>> currentLevel = new Stack<>();
		Stack<BinarySearchTree.BinaryNode<Integer>> nextLevel = new Stack<>();
		Stack<BinarySearchTree.BinaryNode<Integer>> stackTemp;
		BinarySearchTree.BinaryNode<Integer> temp;
		boolean left2right = true;
		
		currentLevel.push(root);
		while(!currentLevel.isEmpty()) {
			temp = currentLevel.pop();
			if(temp != null) {
				System.out.println(temp.element.toString());
				if(left2right) {
					//System.out.println("Right side");
					//System.out.println(temp.right.element.toString());
					//System.out.println(temp.left.element.toString());
					nextLevel.push(temp.right);
					nextLevel.push(temp.left);
				} else {
					//System.out.println("Left side");
					//System.out.println(temp.left.element.toString());
					//System.out.println(temp.right.element.toString());
					nextLevel.push(temp.left);
					nextLevel.push(temp.right);
				}
				if(currentLevel.isEmpty()) {
					System.out.println("Current Level is Empty");
					//swap stacks
					stackTemp = currentLevel;
					currentLevel = nextLevel;
					nextLevel = stackTemp;
					
					//raise level direction change signal now
					left2right = !left2right;
				}
			}
		}
	}
}
