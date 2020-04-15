package practice.dev.algo;

import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreeVerticalView {

    HashMap<Integer, LinkedList<Integer>> hm = new HashMap<>();
    int minhd, maxhd;

    // Tree node
    static class Node {
        int key;
        Node left;
        Node right;

        // Constructor
        Node(int data) {
            key = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        BinaryTreeVerticalView vv = new BinaryTreeVerticalView();
        vv.verticalView(root, 0);
        vv.printMap();
    }

    private void printMap() {
        for (int i = minhd; i <= maxhd; i++) {
            System.out.print(hm.get(i));
            System.out.println();
        }
    }

    public void verticalView(Node root, int hd) {
        if (root == null)
            return;
        if (hm.containsKey(hd))
            hm.get(hd).add(root.key);
        else {
            if (hd < minhd)
                minhd = hd;
            if (hd > maxhd)
                maxhd = hd;
            LinkedList<Integer> ll = new LinkedList();
            ll.add(root.key);
            hm.put(hd, ll);

        }
        verticalView(root.left, hd - 1);
        verticalView(root.right, hd + 1);
    }
}
