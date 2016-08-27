package practice.dev.problemsolving.whatfix.packageproblem;

public class CountPathsIn2DMatrix {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };
		System.out.println(countPathsIn2DMatrix(grid, 0, 0, 3, 3));
	}

	private static int countPathsIn2DMatrix(int[][] grid, int current_x,
			int current_y, int end_x, int end_y) {

		if (current_x < 0 || current_x > 3 || current_y < 0 || current_y > 3) {
			return 0;
		}

		if (grid[current_x][current_y] == 1) {
			return 0;
		}

		if (current_x == end_x && current_y == end_y) {
			return 1;
		}

		grid[current_x][current_y] = 1;

		int result = 0;

		result += countPathsIn2DMatrix(grid, current_x + 1, current_y, end_x,
				end_y);
		result += countPathsIn2DMatrix(grid, current_x, current_y + 1, end_x,
				end_y);
		result += countPathsIn2DMatrix(grid, current_x - 1, current_y, end_x,
				end_y);
		result += countPathsIn2DMatrix(grid, current_x, current_y - 1, end_x,
				end_y);

		grid[current_x][current_y] = 0;

		return result;
	}
}
