package practice.dev.problemsolving;

/**
 * Anti-clockwise In-place rotate square matrix by 90 degrees
 * 
 * Refer -> http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * 
 * How to do without extra space?
Below are some important observations.

First row of source –> First column of destination, elements filled in opposite order

Second row of source –> Second column of destination, elements filled in opposite order

so … on

Last row of source –> Last column of destination, elements filled in opposite order.

An N x N matrix will have floor(N/2) square cycles. For example, a 4 X 4 matrix will have 2 cycles. 
The first cycle is formed by its 1st row, last column, last row and 1st column. 
The second cycle is formed by 2nd row, second-last column, second-last row and 2nd column.

The idea is for each square cycle, we swap the elements involved with the corresponding cell 
in the matrix in anti-clockwise direction i.e. from top to left, left to bottom, 
bottom to right and from right to top one at a time. 
We use nothing but a temporary variable to achieve this.

 * @author dev
 *
 */
public class MatrixAntiClockwise90DegreeInPlaceRotation {

	// An Inplace function to rotate a N x N matrix
	// by 90 degrees in anti-clockwise direction
	void rotateMatrix(int mat[][], int N) {
		// Consider all squares one by one
		for (int x = 0; x < N / 2; x++) {
			// Consider elements in group of 4 in
			// current square
			for (int y = x; y < N - x - 1; y++) {
				// store current cell in temp variable
				int temp = mat[x][y];

				// move values from right to top
				mat[x][y] = mat[y][N - 1 - x];

				// move values from bottom to right
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

				// move values from left to bottom
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

				// assign temp to left
				mat[N - 1 - y][x] = temp;
			}
		}
	}
}
