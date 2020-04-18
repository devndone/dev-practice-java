package practice.dev.ds;

/**
 * Class containing left and right child of current node and key value
 */
public class BinaryNode {

    int data;
    BinaryNode left, right;

    public BinaryNode(int item) {
        data = item;
        left = right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
