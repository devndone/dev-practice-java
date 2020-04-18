package practice.dev.ds;

import java.util.*;

public class FindBinaryTreeKDistantNodesByKaushik {

    public List<Integer> kDistantNodes(BinaryNode root, BinaryNode node, int k) {
        if (root == null || node == null || k < 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        kDistant(root, node, k, result);
        for (Integer i: result) {
            System.out.println("Kousik " + i);
        }
        return result;
    }

    private int kDistant(BinaryNode root, BinaryNode node, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        }

        if (root.getData()== node.getData()) {
            // Find all the nodes in both left & right sub tree
            findInSubTree(node, k, result);
            return 1;
        }

        int left = kDistant(root.getLeft(), node, k, result);
        int right = kDistant(root.getRight(), node, k, result);

        if (left == k || right == k) {
            result.add(root.getData());
        } else if (left > 0 && left < k) {
            findInSubTree(root.getRight(), k - left - 1, result);
        } else if (right > 0 && right < k) {
            findInSubTree(root.getLeft(), k - right - 1, result);
        }

        return left < 0 && right < 0 ? -1 : Math.max(left, right) + 1;
    }

    private void findInSubTree(BinaryNode root, int k, List<Integer> result) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            result.add(root.getData());
            return;
        }

        findInSubTree(root.getLeft(), k - 1, result);
        findInSubTree(root.getRight(), k - 1, result);
    }
}
