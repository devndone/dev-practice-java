package practice.dev.problemsolving;

public class MaxSumSubArray {

	void maxSumSubArray(int[] array, Integer start, Integer end, Integer maxSum) {
		int maxSumSoFar = -2147483648;
		int curSum = 0;
		int a = 0, b = 0, s = 0;
		for (int i = 0; i < array.length; i++) {
			curSum += array[i];
			if (curSum > maxSumSoFar) {
				maxSumSoFar = curSum;
				a = s;
				b = i;
			}
			if (curSum < 0) {
				curSum = 0;
				s = i + 1;
			}
		}
		start = a;
		end = b;
		maxSum = maxSumSoFar;
	}
}
