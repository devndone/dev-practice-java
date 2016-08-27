package practice.dev.problemsolving;

/**
 * 
 * @author dev
 *
 
Backtracking — Search a Word In a Matrix


Objec­tive : Given a 2D matrix of char­ac­ters. Check whether the word exist in the matrix or not. If it exists then print its path. All move­ments are allowed (right, left, up, down and diagonally).

Approach: We will show the path as incre­ment counter
1. Cre­ate a solu­tion matrix of the same struc­ture as Matrix.
2. Try each cell a start­ing point.
3. Check cur­rent cell is not already used and char­ac­ter in it matches with the char­ac­ter in the word at index (starts will 0).
4. Check if index = length of the word, means we have found the word. return true and print the solu­tion matrix.
5. If above cri­te­ria matches, mark that cell with a num­ber When­ever any cell matches with the cri­te­ria, put a num­ber cor­re­spond­ing to it in solu­tion matrix. (start with 0 and keep incre­ment­ing it, it will show us the path for the word).
	5.1 Now try to solve rest of the prob­lem recur­sively by mak­ing index +1. Check all 8 direc­tions ( up, down, left right, diag­o­nally up-left, diag­o­nally up-right, diag­o­nally down-left, diag­o­nally down-right). Check the bound­ary con­di­tions as well
	5.2 If none of the 8 recur­sive calls return true, BACKTRACK and undo the changes ( put 0 to cor­re­spond­ing cell in solu­tion matrix) and return false.
6. Choose dif­fer­ent start­ing point.
7. If all the start­ing points tried and solu­tion not found, return false
8. See the code for bet­ter understanding.

Output:

 0 0 0 0 0
 0 1 0 5 0
 0 0 2 4 6
 0 0 0 3 7
 0 0 0 0 0
 
 */
public class WordSearchIn2DMatrix {
	
		public int[][] solution;
		int path = 1;
		static int howmanytimessearchiscalled = 0;

		// initialize the solution matrix in constructor.
		public WordSearchIn2DMatrix(int N) {
			solution = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solution[i][j] = 0;
				}
			}
		}

		public boolean searchWord(char[][] matrix, String word) {
			int N = matrix.length;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (search(matrix, word, i, j, 0, N)) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean search(char[][] matrix, String word, int row, int col,
				int index, int N) {
			++howmanytimessearchiscalled;
			//System.out.println(howmanytimessearchiscalled + ". " + matrix[row][col]);
			// check if current cell not already used or character in it is not equal to character in word

			if (solution[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
				return false;
			}

			if (index == word.length() - 1) {
				// word is found, return true
				solution[row][col] = path++;
				return true;
			}

			// mark the current cell as 1
			solution[row][col] = path++;		
			// check if cell is already used

			if (row + 1 < N && search(matrix, word, row + 1, col, index + 1, N)) { // go
																					// down
				return true;
			}
			if (row - 1 >= 0 && search(matrix, word, row - 1, col, index + 1, N)) { // go
																					// up
				return true;
			}
			if (col + 1 < N && search(matrix, word, row, col + 1, index + 1, N)) { // go
																					// right
				return true;
			}
			if (col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, N)) { // go
																					// left
				return true;
			}
			if (row - 1 >= 0 && col + 1 < N
					&& search(matrix, word, row - 1, col + 1, index + 1, N)) {
				// go diagonally up right
				return true;
			}
			if (row - 1 >= 0 && col - 1 >= 0
					&& search(matrix, word, row - 1, col - 1, index + 1, N)) {
				// go diagonally up left
				return true;
			}
			if (row + 1 < N && col - 1 >= 0
					&& search(matrix, word, row + 1, col - 1, index + 1, N)) {
				// go diagonally down left
				return true;
			}
			if (row + 1 < N && col + 1 < N
					&& search(matrix, word, row + 1, col + 1, index + 1, N)) {
				// go diagonally down right
				return true;
			}

			// if none of the option works out, BACKTRACK and return false
			solution[row][col] = 0;
			path--;
			return false;
		}

		public void print() {
			for (int i = 0; i < solution.length; i++) {
				for (int j = 0; j < solution.length; j++) {
					System.out.print(" " + solution[i][j]);
				}
				System.out.println();
			}
		}

		public static void main(String[] args) {
			char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
					{ 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
					{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };
			System.out.println("Input Matrix is ->>>>");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					System.out.print(" " + matrix[i][j]);
				}
				System.out.println();
			}
			System.out.println("Output Matrix is ->>>>");
			WordSearchIn2DMatrix w = new WordSearchIn2DMatrix(matrix.length);
			if (w.searchWord(matrix, "horizon")) {
				w.print();
			} else {
				System.out.println("NO PATH FOUND");
			}
			System.out.println("Search function is called total " + howmanytimessearchiscalled + " number of times");
		}

}
