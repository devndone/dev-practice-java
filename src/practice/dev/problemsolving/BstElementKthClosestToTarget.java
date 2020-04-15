package practice.dev.problemsolving;

import practice.dev.ds.BinaryHeap;

public class BstElementKthClosestToTarget {

    private Node root;

    public BstElementKthClosestToTarget(Node root) {
        this.root = root;
        int numItems = 10000;
        BinaryHeap h1 = new BinaryHeap();
        Integer[] items = new Integer[numItems - 1];

        int i = 37;
        int j;

        for (i = 37, j = 0; i != 0; i = (i + 37) % numItems, j++) {
            h1.insert(new Integer(i));
            items[j] = new Integer(i);
        }
    }

    public int findKthClose(int target) {
        int result = Integer.MIN_VALUE;

        return result;
    }
}
