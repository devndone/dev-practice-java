package practice.dev.ds;

/**
 * Courtesy: ALLAN RIORDAN BOLL'S BLOG 
 * http://allanrbo.blogspot.in/2016/03/segment-tree-implementation-in-java.html
 * Concept Details: http://allanrbo.blogspot.in/2016/03/segment-tree-implementation-in-java.html
 * 
 * A segment tree is a tree data structure that allows aggregation queries and updates over array intervals in logarithmic time. As I see it, there are three major use cases for segment trees:

1. Static segment trees: This is probably the most common use case. 
We preprocess an array of N elements to construct a segment tree in O(N). 
Now, we can query aggregates over any arbitrary range/segment of the array in O(log N).
2. Segment tree with point updates: This allows us to update array values, 
one at a time in O(log N), while still maintaining the segment tree structure. 
Queries over any arbitrary range still occurs in O(log N).
3. Segment tree with range updates: This allows us to update a range of array elements at once in O(N) in the worst case, 
however problem specific optimizations and lazy propagation typically give huge improvements. 
Queries over any arbitrary range still occurs in O(log N).

 * @author dev
 *
 */
public class SegmentTreeNode {
	
	public int aggregateValue;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public int origLowIndex;
    public int origHighIndex;

    public static void main(String[] args) {
        //                    0  1  2  3  4  5  6  7  8   9  10
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        SegmentTreeNode r = buildSegmentTree(a, 0, a.length-1);
        System.out.println(r.aggregateValue);

        System.out.println(getAggregateValue(r, 1, 3).aggregateValue);
        System.out.println(getAggregateValue(r, 4, 7).aggregateValue);

        update(r, 2, 10);
        System.out.println(r.aggregateValue);

        System.out.println(getAggregateValue(r, 4, 7).aggregateValue);
        System.out.println(getAggregateValue(r, 1, 3).aggregateValue);
    }
    
    public static SegmentTreeNode buildSegmentTree(int[] a, int low, int high) {
        SegmentTreeNode n = new SegmentTreeNode();
        n.origLowIndex = low;
        n.origHighIndex = high;

        if(low == high) {
            n.aggregateValue = a[low];
            return n;
        }

        int mid = (high - low)/2 + low;

        n.left = buildSegmentTree(a, low, mid);
        n.right = buildSegmentTree(a, mid+1, high);

        // This segment tree is for summation. Could also be min, max, or any other associative func.
        n.aggregateValue = n.left.aggregateValue + n.right.aggregateValue;

        return n;
    }

    public static SegmentTreeNode getAggregateValue(SegmentTreeNode n, int low, int high) {
        if(n.origLowIndex == low && n.origHighIndex == high) {
            return n;
        }

        // The interval is fully contained within the left node
        if(low >= n.left.origLowIndex && high <=  n.left.origHighIndex) {
            return getAggregateValue(n.left, low, high);
        }

        // The interval is fully contained within the right node
        if(low >= n.right.origLowIndex && high <=  n.right.origHighIndex) {
            return getAggregateValue(n.right, low, high);
        }

        // Split into queries on the left subtree and the right subtree
        SegmentTreeNode leftResult = getAggregateValue(n.left, low, n.left.origHighIndex);
        SegmentTreeNode rightResult = getAggregateValue(n.right, n.right.origLowIndex, high);
        SegmentTreeNode result = new SegmentTreeNode();
        result.origLowIndex = low;
        result.origHighIndex  = high;

        // This segment tree is for summation. Could also be min, max, or any other associative func.
        result.aggregateValue = leftResult.aggregateValue + rightResult.aggregateValue;

        return result;
    }

    public static void update(SegmentTreeNode n, int index, int val) {
        if(n.origLowIndex == index && n.origHighIndex == index) {
            n.aggregateValue = val;
            return;
        }

        if(n.left.origLowIndex <= index && index <= n.left.origHighIndex) {
            update(n.left, index, val);
        } else {
            update(n.right, index, val);
        }

        // This segment tree is for summation. Could also be min, max, or any other associative func.
        n.aggregateValue = n.left.aggregateValue + n.right.aggregateValue;
    }
    
}