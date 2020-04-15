package practice.dev.problemsolving;

import java.io.*;
import java.util.*;

/**
 * Pairs with Specific Difference
 * Given an array arr of distinct integers and a nonnegative integer k,
 * write a function findPairsWithGivenDifference that returns
 * an array of all pairs [x,y] in arr, such that x - y = k.
 * If no such pairs exist, return an empty array.
 *
 * Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
 *
 * Examples:
 *
 * input:  arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 *
 * input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.integer arr
 *
 * 0 ≤ arr.length ≤ 100
 * [input]integer k
 *
 * k ≥ 0
 * [output] array.array.integer
 */
public class PairsWithGivenDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        int[][] res = new int[arr.length][2];
        int h = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                //if(i != j) {
                if(arr[j] - arr[i] == k) {
                    res[h] = new int[]{arr[j], arr[i]};
                    h++;
                } else if(arr[i] - arr[j] == k) {
                    res[h] = new int[]{arr[i], arr[j]};
                    h++;
                }
                //}
            }
        }
        int[][] res1 = new int[h][2];
        for(int i = 0; i < h; i++) {
            res1[i] = res[i];
        }
        return res1;
    }

    public static void main(String[] args) {

    }

}
