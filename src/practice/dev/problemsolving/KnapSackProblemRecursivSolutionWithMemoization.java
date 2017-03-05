package practice.dev.problemsolving;

import java.util.Arrays;

public class KnapSackProblemRecursivSolutionWithMemoization {
	int[] v = { 7, 2, 1, 6, 12 };// vertices
	int[] w = { 3, 1, 2, 4, 6 };// weight set
	int capacity = 10;
	int n = v.length;// Global Variable as v[1..n] or w[1..n]
	Integer[][] solarr = new Integer[capacity][n];

	public static void main(String[] args) {

	}

	/*
	 * c : Capacity for containing solution i : Index of the first undecided
	 * object
	 */
	int ks(int c, int i) {

		if (i > n) {
			solarr[c][i] = 0;
			return solarr[c][i];
		}

		for (int j : solarr[c]) {
			java.util.List<Integer> ar = Arrays.asList(j);
		}

		if (c < w[i]) {// if true then ignore the present index and recursive
						// get solution from next index
			if (solarr[c][i + 1] == null) {
				return solarr[c][i + 1] = ks(c, (i + 1));
			}
		}

		if (solarr[c][i + 1] == null) {
			solarr[c][i + 1] = ks(c, (i + 1));
		}
		if (solarr[(c - w[i])][i + 1] == null) {
			solarr[(c - w[i])][i + 1] = ks((c), (i + 1));
		}
		return Math.max(solarr[c][i + 1], (v[i] + solarr[(c - w[i])][i + 1]));

	}
}
