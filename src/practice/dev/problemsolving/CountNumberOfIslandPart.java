package practice.dev.problemsolving;

/**
 * refer great detail description here:
 * http://javabypatel.blogspot.in/2016/08/find-number-of-islands-using-dfs.html
 * 
 * @author dev
 *
 */
public class CountNumberOfIslandPart {
	public static void main(String[] args) {

		int[][] island = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println(countIsland(island));

		// If required, change '*' back to 1 in matrix.
	}

	public static int countIsland(int[][] island) {
		int count = 0;
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[i].length; j++) {

				if (island[i][j] == 1) {
					markAllNeighours(i, j, island);
					count++;
				}
			}
		}
		return count;
	}

	public static void markAllNeighours(int row, int col, int[][] island) {

		island[row][col] = '*';

		// Right
		if (col + 1 < island[col].length && island[row][col + 1] == 1)
			markAllNeighours(row, col + 1, island);

		// Bottom Right diagonal
		if (row + 1 < island.length && col + 1 < island[col].length && island[row + 1][col + 1] == 1)
			markAllNeighours(row + 1, col + 1, island);

		// Bottom
		if (row + 1 < island.length && island[row + 1][col] == 1)
			markAllNeighours(row + 1, col, island);

		// Bottom Left diagonal
		if (row + 1 < island.length && col - 1 >= 0 && island[row + 1][col - 1] == 1)
			markAllNeighours(row + 1, col - 1, island);

		// Left
		if (col - 1 >= 0 && island[row][col - 1] == 1)
			markAllNeighours(row, col - 1, island);

		// Top Left diagonal
		if (row - 1 >= 0 && col - 1 >= 0 && island[row - 1][col - 1] == 1)
			markAllNeighours(row - 1, col - 1, island);

		// Top
		if (row - 1 >= 0 && island[row - 1][col] == 1)
			markAllNeighours(row - 1, col, island);

		// Top Right diagonal
		if (row - 1 >= 0 && col + 1 < island[col].length && island[row - 1][col + 1] == 1)
			markAllNeighours(row - 1, col + 1, island);
	}
}