package practice.dev.ds;

import java.util.*;

public class PrintBinaryTreeKDistantNodesByVishnu {

    public void findDistanceFromGivenNode(BinaryNode root, BinaryNode destinationNode, int length) {
        Stack<BinaryNode> stack = new Stack<>();
        boolean status = findTheElementWithRoot(root, destinationNode, stack);
        System.out.println("Stack value ");
        int[] path = new int[length+1];
        int size = length;
        if (status){
            Set<BinaryNode> setOfSkipNodes = new HashSet<>();
            while ((stack.size() != 0) && (size-- >= 0)) {
                BinaryNode stackElement = stack.pop();
                print(stackElement, length, setOfSkipNodes, path, setOfSkipNodes.size());
                path[setOfSkipNodes.size()] = stackElement.getData();
                setOfSkipNodes.add(stackElement);
            }
        }
    }
    private void print(BinaryNode dataTree , int length, Set<BinaryNode> skipList, int[] path, int i) {
        if (dataTree == null) {
            return;
        }
        if (skipList.contains(dataTree)) {
            return;
        }
        path[i] = dataTree.getData();
        if (length == i) {
            print(path, path.length);
            return;
        }
        print(dataTree.getLeft(), length, skipList, path, i+1);
        print(dataTree.getRight(), length, skipList, path, i+1);
    }
    private boolean findTheElementWithRoot(BinaryNode root, BinaryNode destinationNode, Stack<BinaryNode> stack) {
        if (root == null ) return false;
        if (root.getData() == destinationNode.getData()) {
            stack.push(root);
            return true;
        }
        stack.push(root);
        if (root.getLeft() != null && findTheElementWithRoot(root.getLeft(), destinationNode, stack)) {
            return true;
        }
        if (root.getRight() != null && findTheElementWithRoot(root.getRight(), destinationNode, stack)) {
            return true;
        }
        stack.pop();
        return false;
    }

    private void print(int[] path, int p) {
        for (int i = 0; i < p; i++) {
            System.out.print(path[i] + "---");
        }
        System.out.println();
    }
}
