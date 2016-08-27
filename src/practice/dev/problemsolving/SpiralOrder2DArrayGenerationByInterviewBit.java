package practice.dev.problemsolving;

import java.util.ArrayList;

public class SpiralOrder2DArrayGenerationByInterviewBit {
	public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int rows, cols;
		int row, col;

		rows = cols = A;
		int num = 1;
		int max = A * A;

		for (int i = 0; i < rows; i++) {
			res.add(new ArrayList<>());
			for (int j = 0; j < rows; j++) {
				res.get(i).add(0);
			}
		}

		row = col = 0;
		int dir = 0;
		int layer = 0;

		res.get(0).set(0, 1);

		for (int step = 2; step <= A * A; step++) {

			switch (dir) {

			// Go right
			case 0:
				if (col == cols - layer - 1) {
					row++;
					dir = 1;
				} else {
					col++;
				}

				break;

			// Go down
			case 1:

				if (row == rows - layer - 1) {
					dir = 2;
					col--;
				} else {
					row++;
				}

				break;

			// Go left
			case 2:

				if (col == layer) {
					row--;
					dir = 3;
				} else {
					col--;
				}

				break;

			// Go up
			case 3:

				if (row == layer + 1) {
					dir = 0;
					col++;
					layer++;
				} else {
					row--;
				}

				break;

			}

			res.get(row).set(col, step);

		}

		return res;

	}
}
