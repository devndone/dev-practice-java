package practice.dev.algo;

public class PrintAllNodesAtKFromGivenNode {

    public void printAllNodes(Node root, int target, int distance) {
        int pathLength = Pathlength(root, target) - 1;
        Path(root, target, pathLength, distance);
    }

//    public int getLength(Node root, int data) {
//        if(root == null) {
//            return 0;
//        }
//        if(root.data == data) {
//            return 1;
//        }
//        int ll = getLength(root.left, data);
//        if(ll > 0) {
//            ll += 1;
//        }
//        ll = getLength(root.right, data);
//        if(ll > 0) {
//            ll += 1;
//        }
//        return ll;
//    }

    public void print(Node root, int target, Node prev, int distance,
                      boolean searchingDown) {
        if (root != null) {
            if (distance == 0 && root.data != target) {
                System.out.print(" " + root.data);
            }
            if (searchingDown) {
                print(root.left, target, prev, --distance, searchingDown);
                print(root.right, target, prev, distance, searchingDown);
            } else {
                if (root.left != prev) {
                    print(root.left, target, prev, --distance, searchingDown);
                }
                if (root.right != prev) {
                    print(root.right, target, prev, --distance, searchingDown);
                }
            }
        }
    }

    public Node Path(Node root, int target, int pathLength, int distance) {
        if (root == null)
            return null;
        Node x = null;
        if (root.data == target || (x = Path(root.left, target, pathLength - 1, distance)) != null
                || (x = Path(root.right, target, pathLength - 1, distance)) != null) {
            if (pathLength == 0) {
                print(root, target, x, distance - pathLength, true);
            } else {
                print(root, target, x, distance - pathLength, false);
            }

            return root;
        }
        return null;
    }

    public int Pathlength(Node root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
                    || (x = Pathlength(root.right, n1)) > 0) {
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(9);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.right.right = new Node(10);
        root.left.right.right.right.left = new Node(11);
        root.right.right = new Node(8);
        PrintAllNodesAtKFromGivenNode i = new PrintAllNodesAtKFromGivenNode();
        System.out.print("Nodes at distance '3' from Node '5' are : ");
        i.printAllNodes(root, 5, 3);
    }

//    static class Node {
//        int data;
//        practice.dev.algo.Node left;
//        practice.dev.algo.Node right;
//
//        public Node(int data) {
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
}
