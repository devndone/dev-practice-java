package practice.dev.problemsolving;

/**
 * Find an index in an array such that its prefix sum equals its suffix sum.
 * From Codility: A zero-indexed array A consisting of N integers is given. An
 * equilibrium index of this array is any integer P such that 0 ≤ P < N and the
 * sum of elements of lower indices is equal to the sum of elements of higher
 * indices, i.e. A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 * Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or
 * if P = N−1.
 * 
 * For example, consider the following array A consisting of N = 8 elements:
 * 
 * A[0] = -1 A[1] = 3 A[2] = -4 A[3] = 5 A[4] = 1 A[5] = -6 A[6] = 2 A[7] = 1 P
 * = 1 is an equilibrium index of this array, because:
 * 
 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7] P = 3 is an equilibrium
 * index of this array, because:
 * 
 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7] P = 7 is also an
 * equilibrium index, because:
 * 
 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0 and there are no elements
 * with indices greater than 7.
 * 
 * P = 8 is not an equilibrium index, because it does not fulfill the condition
 * 0 ≤ P < N.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A consisting of N integers, returns any of
 * its equilibrium indices. The function should return −1 if no equilibrium
 * index exists.
 * 
 * For example, given array A shown above, the function may return 1, 3 or 7, as
 * explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author dev
 *
 */
public class EquilibriumIndexFinder {

	public int solution(int[] A) {
		int res = -1;
		if (A == null || A.length < 1) {
			return res;
		}
		this.getEquiIndex(A, 0, A[0], 0, res);
		return res;
	}

	public int solution1(int[] A, int N) {
		// return 3 for [3,2,-5,1]
		int sum_prefix = 0;
		int sum_suffix = 0;
		int i, j;
		for (i = 0; i < N; i++) {
			// Check if it is the equilibrium point
			sum_prefix = 0;
			for (j = 0; j < i; j++) {
				sum_prefix += A[j];
			}
			sum_suffix = 0;
			for (j = i + 1; j < N; j++) {
				sum_suffix += A[j];
				// Compute suffix sum
			}
			if (sum_prefix == sum_suffix)
				return i;
		}
		return -1;
	}

	private void getEquiIndex(int[] in, int i, int sumTill, int sumOther, int res) {
		if (i < 0 || i >= in.length) {
			return;
		}
		if (sumTill == sumOther) {
			res = i;
			return;
		}
		++i;
		sumTill += in[i];
		sumOther -= in[i];
		getEquiIndex(in, i, sumTill, sumOther, res);
		--i;
		sumTill -= in[i];
		sumOther += in[i];
		return;
	}
}
