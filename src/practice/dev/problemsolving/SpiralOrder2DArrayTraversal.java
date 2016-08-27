package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder2DArrayTraversal {

	public static void main(String[] args) {
		List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ai = new ArrayList<Integer>();
		ai.add(1);
		ai.add(2);
		ai.add(3);// [1, 2, 3]
		a.add(ai);
		ai = new ArrayList<Integer>();
		ai.add(4);
		ai.add(5);
		ai.add(6);// [4, 5, 6]
		a.add(ai);
		ai = new ArrayList<Integer>();
		ai.add(7);
		ai.add(8);
		ai.add(9);// [7, 8, 9]
		a.add(ai);
		System.out.println("Input : \n" + a.toString());
		System.out.println("Output :\n"
				+ SpiralOrder2DArrayTraversal.spiralOrder(a).toString());// [1,
																			// 2,
																			// 4,
																			// 6,
																			// 5,
																			// 3]
	}

	public static ArrayList<Integer> spiralOrder(
			final List<ArrayList<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int t = 0, b = (a.size() - 1), l = 0, r = (a.get(0).size() - 1), dir = 0;
		while (t <= b && l <= r) {
			if (dir == 0) {
				for (int i = l; i <= r; i++) {
					result.add(a.get(t).get(i));
				}
				t++;
			} else if (dir == 1) {
				for (int i = t; i <= b; i++) {
					result.add(a.get(i).get(r));
				}
				r--;
			} else if (dir == 2) {
				for (int i = r; i >= l; i--) {
					result.add(a.get(b).get(i));
				}
				b--;
			} else if (dir == 3) {
				for (int i = b; i >= t; i--) {
					result.add(a.get(i).get(l));
				}
				l++;
			}
			dir = (dir + 1) % 4;
		}
		return result;
	}

	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> spiralOrderFromInterviewbitSolution(
			final List<ArrayList<Integer>> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// Populate result;
		int m, n;

		m = A.size();
		n = A.get(0).size();

		if (m == 0)
			return result;

		int len;
		int dir = 0; // right
		int row, col, layer;
		row = col = layer = 0;

		result.add(A.get(0).get(0));

		for (int step = 1; step < m * n; step++) {

			switch (dir) {

			// Go right
			case 0:

				if (col == n - layer - 1) {
					dir = 1;
					row++;
				} else {
					col++;
				}

				break;

			// Go down
			case 1:

				if (row == m - layer - 1) {
					dir = 2;
					col--;
				} else {
					row++;
				}

				break;

			// Go left
			case 2:

				if (col == layer) {
					dir = 3;
					row--;
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

			// System.out.println(row + " " + col);
			result.add(A.get(row).get(col));

		}

		return result;
	}

}
