package practice.dev.problemsolving;

import java.util.Arrays;

/**
 * Problem:
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 *
 * Method:
 *
 * Use first row and col to mark the positions of the zeros in the matrix.
 * If there are any zeros in the first row and col, have flag for looking out for this
 * Process the "inner elements" first, that is, elements that are not in the first row or first col.
 * After the right inner elements are zeroed out, check if there were any zeros in the first row or first col, if so, then zero out the first row or first col.
 * Executing code in this order is important to not "wash" away marked positions on the first row and first col.
 * Time: O(m*n), have to traverse through all the elements in the matrix. Space: O(1).
 */
public class SetMatrixZeroes {

    public static void main(String [] args) {
        int[][] inmat = {
                                {1, 1, 1},
                                {1, 0, 1},
                                {1, 1, 1}
                        };
        /*int[][] inmat = {
                                {0, 1, 2, 0},
                                {3, 4, 5, 2},
                                {1, 3, 1, 5}
                        };*/
        System.out.println("Input: ");
        for (int i = 0; i < inmat.length; i++) {
            System.out.println();
            System.out.print("{ ");
            for (int j = 0; j < inmat[0].length; j++) {
                System.out.print(inmat[i][j] + " ");
            }
            System.out.print("}");
        }

        SetMatrixZeroes smz = new SetMatrixZeroes();
        smz.setZeroes(inmat);

        System.out.println();
        System.out.println();
        System.out.println("Output: ");
        for (int i = 0; i < inmat.length; i++) {
            System.out.println();
            System.out.print("{ ");
            for (int j = 0; j < inmat[0].length; j++) {
                System.out.print(inmat[i][j] + " ");
            }
            System.out.print("}");
        }
    }

    public void setZeroes(int[][] matrix) {

        //check for edge cases
        if(matrix == null || matrix.length == 0){
            return;
        }

        boolean rowOneZero = false;
        boolean colOneZero = false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    if(i==0){
                        rowOneZero = true;
                    }
                    if(j==0){
                        colOneZero = true;
                    }
                    //mark the first row
                    matrix[0][j] = 0;
                    //mark the first col
                    matrix[i][0] = 0;
                }
            }
        }

        //process the first row, zero the appropriate col's
        //exclude processing the first col
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                setColZeroes(matrix,j);
            }
        }

        //process the first col, zero the appropriate row's
        //exclude processing the first row
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                setRowZeroes(matrix,i);
            }
        }

        //process the first row, if it had any zeros
        if(rowOneZero){
            setRowZeroes(matrix,0);
        }

        //process the first col, if it had any zeros
        if(colOneZero){
            setColZeroes(matrix,0);
        }

    }

    public void setColZeroes(int[][] matrix,int col){
        for(int i=0;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
    }

    public void setRowZeroes(int[][] matrix, int row){
        for(int j=0;j<matrix[0].length;j++){
            matrix[row][j] = 0;
        }
    }

}

