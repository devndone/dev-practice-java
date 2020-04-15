package practice.dev.problemsolving;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BstKthSmallestElement {

    /**
     * Definition for binary tree
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    //Faulty: Not covering all test cases
    public int kthsmallestByDev(TreeNode A, int B) {
        TreeNode root = A;
        int result = Integer.MIN_VALUE;
        int nodeVal = Integer.MIN_VALUE;
        if(root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tempNode = stack.poll();
            nodeVal = tempNode.val;
            if(B > 0 && nodeVal > result) {
                System.out.print(nodeVal + " ");
                result = nodeVal;
                --B;
            } else {
                break;
            }
            if(stack.size() == 0) {
                break;
            }
            if(tempNode.right != null) {
                stack.push(tempNode.right);
            }
        }
        return result;
    }

    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode n = root;
        while(n != null){
            nodes.push(n);
            n = n.left;
        }

        while(!nodes.isEmpty()){
            n = nodes.pop();
            k--;
            if(k == 0){
                return n.val;
            }
            if(n.right != null){
                n = n.right;
                while(n != null){
                    nodes.push(n);
                    n = n.left;
                }
            }

        }
        return -1;
    }
}
