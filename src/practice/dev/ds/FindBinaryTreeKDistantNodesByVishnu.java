package practice.dev.ds;

import java.util.*;

public class FindBinaryTreeKDistantNodesByVishnu {

    public void findDistanceFromGivenNode(BinaryNode root, BinaryNode destinationNode, int length) {
        Stack<BinaryNode> stack = new Stack<>();
        boolean status = findTheElementWithRoot(root, destinationNode, stack);
        int size = 0;
        if (status) {
            Set<BinaryNode> setOfSkipNodes = new HashSet<>();
            BinaryNode prev = null;
            while ((stack.size() != 0) && (size <= length)) {
                BinaryNode stackElement = stack.pop();
                print(stackElement, length, prev, size);
                prev = stackElement;
                size++;
            }
        }
    }

    private void print(BinaryNode dataTree , int length, BinaryNode skipNode, int i) {
        if (dataTree == null) {
            return;
        }
        if (dataTree == skipNode) {
            return;
        }
        if (length == i) {
            System.out.println(dataTree.getData() + "  ");
            return;
        }
        print(dataTree.getLeft(), length, skipNode, i+1);
        print(dataTree.getRight(), length, skipNode, i+1);
    }

    private boolean findTheElementWithRoot(BinaryNode root, BinaryNode destinationNode, Stack<BinaryNode> stack) {
        if (root == null ) return false;
        if (root.getData() == destinationNode.getData()) {
            stack.push(root);
            return true;
        }
        stack.push(root);
        if (findTheElementWithRoot(root.getLeft(), destinationNode, stack) ||
                findTheElementWithRoot(root.getRight(), destinationNode, stack)
        ) {
            return true;
        }
        stack.pop();
        return false;
    }
}
