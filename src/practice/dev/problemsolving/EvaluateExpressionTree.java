package practice.dev.problemsolving;

public class EvaluateExpressionTree {

    public static void main(String[] args) {

        Node root= new Node("+");
        root.left= new Node("*");
        root.right= new Node("-");
        root.left.left= new Node("5");
        root.left.right= new Node("4");
        root.right.left= new Node("100");
        root.right.right= new Node("20");
        System.out.print("\n\nInput is -> ");
        inorder(root);
        int result= evaluate(root);
        System.out.println("\n\nResult is -> " + result);
    }

    // Utility function to do inorder traversal
    private static void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }

    private static boolean isNo(String no) {
        try {
            Integer.parseInt(no);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }

    }

    private static int evaluate(Node root) {
        if(root== null)
            return 0;
        int left= evaluate(root.left);
        int right= evaluate(root.right);

        if(!isNo(root.data)) {
            return getResult(left, right, root.data);
        }
        return Integer.parseInt(root.data);
    }

    private static int getResult(int left, int right, String data) {

        switch(data) {
            case "+":
                return left+right;
            case "-":
                return left-right;
            case "*":
                return left*right;
            case "/":
                return left/right;
            case "%":
                return left%right;
            default:
                throw new RuntimeException("Invalid expression");

        }
    }

    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data= data;
        }
    }

}
