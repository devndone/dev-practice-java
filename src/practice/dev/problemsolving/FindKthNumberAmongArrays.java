package practice.dev.problemsolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthNumberAmongArrays {

    //2 Unsorted Arrays
    //3rd highest element from the merged arrays
    public static Integer findKthHighest() {

        Integer result = Integer.MIN_VALUE;

        Integer[] in1 = {45, 78, -999, 4, -1};
        Integer[] in2 = {100, 88, 5, 8, 1, -4};
        int cache = 3;

        //Collections.sort();

        //minHeap = 3 which mean minHeap[0] has 3rd highest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cache, (Integer o1, Integer o2) -> {
            return o2.compareTo(o1);
        });

        for(Integer i: in1) {
            minHeap.add(i);
        }
        for(Integer i: in2) {
            minHeap.add(i);
        }

        while(cache != 0) {
            result = minHeap.poll();
            --cache;
        }
        return result;

    }

    // Function to find the K'th smallest element in the
    // array using max-heap
    public static int findKthSmallest(List<Integer> A, int k)
    {
        // create a max-heap using PriorityQueue class and
        // insert first k elements of the array into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(A.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < A.size(); i++)
        {
            // if current element is less than the root of the heap
            if (A.get(i) < pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(A.get(i));
            }
        }

        // return the root of max-heap
        return pq.peek();
    }

    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;

        System.out.println("K'th smallest element in the array is " +
                findKthSmallest(A, k));

        System.out.println(findKthHighest());
    }

//    //
//    class MergeSort {
//        private Integer[] source;
//        private Integer[] temp;
//        MergeSort(Integer[] input) {
//            this.source = input;
//        }
//        public void sort() {
//            this.sort(0, this.source.length-1);
//        }
//        private void sort(int start, int end) {
//            int mid = start+(end-start)/2;
//            sort(start, mid);
//            sort(mid+1, end);
//            merge(start, mid, end);
//        }
//        public void merge(int start, int mid, int end) {
//
//        }
//    }
}

