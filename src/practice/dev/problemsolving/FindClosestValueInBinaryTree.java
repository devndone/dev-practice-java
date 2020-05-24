package practice.dev.problemsolving;

public class FindClosestValueInBinaryTree {

    /**
     * O(n) time and space complexity
     * @param tree
     * @param target
     * @return
     */
    public static int findClosestValueInBst(BinaryTree tree, int target) {
        if (tree == null) {
            return -1;
        }
        int vLeft = findClosestValueInBst(tree.left, target);
        if (tree.value == target) {
            return tree.value;
        }
        int vRight = findClosestValueInBst(tree.right, target);
        int dLeft = Integer.MAX_VALUE, dRight = Integer.MAX_VALUE, dSelf = Math.abs(target - tree.value);
        if (vLeft != -1) {
            dLeft = Math.abs(target - vLeft);
        }
        if (vRight != -1) {
            dRight = Math.abs(target - vRight);
        }
        int res = tree.value;
        if (dLeft < dRight) {
            if (dLeft < dSelf) {
                res = vLeft;
            }
        } else {
            if (dRight < dSelf) {
                res = vRight;
            }
        }
        return res;
    }

    private static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
