package practice.dev.problemsolving;

import java.util.Stack;

/**
 *
 * Definition:
 * Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node corresponds to operand
 *
 * Logic:
 * Construction of Expression Tree from the given Postfix expression input:
 * Now For constructing expression tree we use a stack. We loop through input expression and do following for every character.
 * 1) If character is operand push that into stack
 * 2) If character is operator pop two values from stack make them its child and push current node again.
 * At the end only element of stack will be root of expression tree.
 *
 * Java program for expression tree
 *
 */
public class ExpressionTreeFromPostfixExpression {

    class Node {

        char value;
        Node left, right;

        Node(char item) {
            value = item;
            left = right = null;
        }
    }

    // A utility function to check if 'c'
    // is an operator

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    // Utility function to do inorder traversal
    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }

    // Returns root of constructed tree for given
    // postfix expression
    Node constructTree(char postfix[]) {
        Stack<Node> st = new Stack();
        Node t, t1, t2;

        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {

            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                st.push(t);
            } else // operator
            {
                t = new Node(postfix[i]);

                // Pop two top nodes
                // Store top
                t1 = st.pop();	 // Remove top
                t2 = st.pop();

                // make them children
                t.right = t1; //First Topmost in the stack goes to right of the tree
                t.left = t2; //Second Topmost goes to left of the tree

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            }
        }

        // only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }

    public static void main(String args[]) {

        ExpressionTreeFromPostfixExpression et = new ExpressionTreeFromPostfixExpression();
        //String postfix = "ab+ef*g*-";
        String postfix = "84*3-2+6/";
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);

    }
}

