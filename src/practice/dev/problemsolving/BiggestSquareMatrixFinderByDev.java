package practice.dev.problemsolving;

import java.lang.*;

public class BiggestSquareMatrixFinderByDev {

    private static int count = 0;
    private static int cacheCount = 0;
    private static int cacheCountIter = 0;

    public static void main(String [] args) {
        boolean[][] matrix = {
                {true, false, true, true, false},
                {false, true, true, true, true},
                {true, true, true, true, false}
        };

        int max = findBiggestMatrix(matrix);
        int maxCache = findBiggestMatrixWithCache(matrix);
        int maxCacheIter = findBiggestMatrixWithCacheAndBottomUpIteration(matrix);
        System.out.println("\nBiggest Matrix Length is " + max + "\n Iteration Count is " + count);
        System.out.println("\nBiggest Matrix Length with Cache is " + maxCache + "\n Iteration Count is " + cacheCount);
        System.out.println("\nBiggest Matrix Length with Cache [Bottom Up] is " + maxCacheIter + "\n Iteration Count is " + cacheCountIter);

    }

    public static int findBiggestMatrix(boolean[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                max = Math.max(max, findBiggestMatrix(matrix, i, j));
            }
        }
        return max;
    }

    public static int findBiggestMatrix(boolean[][] matrix, int startRowIndex, int startColumnIndex) {
        if(startRowIndex == matrix.length || startColumnIndex == matrix[0].length) {
            return 0;
        }
        if(!matrix[startRowIndex][startColumnIndex]) {
            return 0;
        }
        ++count;
        return 1 + Math.min(Math.min(
                    findBiggestMatrix(matrix, startRowIndex + 1, startColumnIndex),
                    findBiggestMatrix(matrix, startRowIndex, startColumnIndex + 1)),
                findBiggestMatrix(matrix, startRowIndex + 1, startColumnIndex + 1)
            );
    }

    public static int findBiggestMatrixWithCache(boolean[][] matrix) {
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                max = Math.max(max, findBiggestMatrix(matrix, cache, i, j));
            }
        }
        return max;
    }

    public static int findBiggestMatrix(boolean[][] matrix, int[][] cache, int startRowIndex, int startColumnIndex) {
        if(startRowIndex == matrix.length || startColumnIndex == matrix[0].length) {
            return 0;
        }
        if(!matrix[startRowIndex][startColumnIndex]) {
            return 0;
        }
        if(cache[startRowIndex][startColumnIndex] != 0) {
            return cache[startRowIndex][startColumnIndex];
        }
        ++cacheCount;
        cache[startRowIndex][startColumnIndex] = 1 + Math.min(Math.min(
                findBiggestMatrix(matrix, startRowIndex + 1, startColumnIndex),
                findBiggestMatrix(matrix, startRowIndex, startColumnIndex + 1)),
                findBiggestMatrix(matrix, startRowIndex + 1, startColumnIndex + 1)
        );
        return cache[startRowIndex][startColumnIndex];
    }

    public static int findBiggestMatrixWithCacheAndBottomUpIteration(boolean[][] matrix) {
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];

        //Either use below for loop
        /*for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length ; ++j) {
                ++cacheCountIter;
                if(i == 0 || j == 0) {
                    cache[i][j] = matrix[i][j] ? 1 : 0;
                } else if(matrix[i][j]) {
                    cache[i][j] = 1 + Math.min(Math.min(cache[i-1][j], cache[i][j-1]), cache[i-1][j-1]);
                }
                max = Math.max(max, cache[i][j]);
            }
        }*/
        //Or use below for loop
        for(int i = matrix.length - 1; i >= 0; --i) {
            for(int j = matrix[0].length - 1; j >= 0; --j) {
                ++cacheCountIter;
                if(i == (matrix.length - 1) || j == (matrix[0].length - 1)) {
                    cache[i][j] = matrix[i][j] ? 1 : 0;
                } else if(matrix[i][j]) {
                    cache[i][j] = 1 + Math.min(Math.min(cache[i+1][j], cache[i][j+1]), cache[i+1][j+1]);
                }
                max = Math.max(max, cache[i][j]);
            }
        }
        //both above for loop are same

        return max;
    }
}
