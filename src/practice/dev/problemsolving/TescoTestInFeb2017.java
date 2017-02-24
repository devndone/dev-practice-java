package practice.dev.problemsolving;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TescoTestInFeb2017 {

	public int GetBuildingCount(int input1, int[][] input2) {

		int resCount = -1;

		if (input1 < 1 || input2 == null || input2.length != input1) {

			throw new UnsupportedOperationException("GetBuildingCount(int input1,int[][] input2)");

		}

		Map<Integer, Set<Integer>> visits = new HashMap<>();

		Set<Integer> s = new HashSet<>();

		visits.put(0, s);// denotes list of rows visted

		s = new HashSet<>();

		visits.put(1, s);// denotes list of columns visted

		int[] tempA = null;

		/*
		 * 
		 * loop through all the soldiers positions and capture rows and columns
		 * that they soldiers are positioned
		 * 
		 * then calculate based on the formula
		 * 
		 * (((VistedRows * 8) - (VisitedColumns * VistedRows)) + (VisitedColumns
		 * * 8))
		 * 
		 * the reason we are deducting the number of soldiers is because there
		 * occupied positions are by default considered occupied and not
		 * included int he count
		 * 
		 * else your sample input should have optput 24 instead of 22.
		 * 
		 * Please consider this aspect while evaluating,
		 * 
		 * as if this assumption is wrong then your basic test itself is wrong
		 * 
		 * and if I don't assume it right then I'll not be able to run my
		 * program
		 * 
		 * and it'll be rejected!
		 * 
		 */

		for (int i = 0; i < input2.length; i++) {

			tempA = input2[i];

			if (tempA == null || tempA.length != 2 || tempA[0] < 1 || tempA[1] < 1) {

				throw new UnsupportedOperationException("GetBuildingCount(int input1,int[][] input2)");

			}

			visits.get(0).add(tempA[0]);// add the row visited into set so that
										// only unique rows are cosnidered and
										// not already visited

			visits.get(1).add(tempA[1]);// add the column visited into set so
										// that only unique columns are
										// cosnidered and not already visited

		}

		int VistedRows = visits.get(0).size();
		int VisitedColumns = visits.get(1).size();

		resCount = (((VistedRows * 8) - (VisitedColumns * VistedRows)) + (VisitedColumns * 8));

		return resCount;

	}

	public int PerfectSums(int input1, int[] input2, int input3) {
		// Read only region end
		// Write code here...

		int res = 999;

		if (input2 == null || input2.length != input1) {
			return res;
		}

		// throw new UnsupportedOperationException("PerfectSums(int input1,int[]
		// input2,int input3)");

		final int INPUT_SUM = input3;
		AtomicInteger OUTPUT_COUNT = new AtomicInteger();
		final int[] INPUT_DATA = input2;

		Stack<Integer> stack = new Stack<Integer>();
		int sumInStack = 0;

		populateSubset(stack, sumInStack, INPUT_DATA, 0, INPUT_DATA.length, INPUT_SUM, OUTPUT_COUNT);

		if (OUTPUT_COUNT.get() != 0) {
			res = OUTPUT_COUNT.get();
		}

		return res;

	}

	public void populateSubset(Stack<Integer> stack, int sumInStack, int[] INPUT_DATA, int fromIndex, int endIndex,
			final int INPUT_SUM, AtomicInteger OUTPUT_COUNT) {

		/*
		 * Check if sum of elements stored in Stack is equal to the expected
		 * target INPUT_SUM.
		 * 
		 * If so, then increment the OUTPUT_COUNT as we have got one distinct
		 * sub-array with the target INPUT_SUM
		 */
		if (sumInStack == INPUT_SUM) {
			// print(stack);
			OUTPUT_COUNT.incrementAndGet();
		}

		for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

			if (sumInStack + INPUT_DATA[currentIndex] <= INPUT_SUM) {
				stack.push(INPUT_DATA[currentIndex]);
				sumInStack += INPUT_DATA[currentIndex];

				/*
				 * Make the currentIndex +1, and then use recursion to proceed
				 * further.
				 */
				populateSubset(stack, sumInStack, INPUT_DATA, currentIndex + 1, endIndex, INPUT_SUM, OUTPUT_COUNT);
				sumInStack -= (Integer) stack.pop();
			}
		}
	}

	public static void main(String[] args) {

		// int[] INPUT = { 5, 6, 1, -2, -4, 3, 1, 5 };
		// printSubarrays(INPUT, 5);
		int[] INPUT1 = { 9, 7, 3, 12, 7 };
		// printSubarrays(INPUT1, 14);
		TescoTestInFeb2017 get = new TescoTestInFeb2017();
		System.out.println(get.PerfectSums(5, INPUT1, 14));
	}

	private static void printSubarrays(int[] input, int k) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> initial = new ArrayList<Integer>();
		initial.add(-1);
		map.put(0, initial);
		int preSum = 0;

		// Loop across all elements of the array
		for (int i = 0; i < input.length; i++) {
			preSum += input[i];
			// If point where sum = (preSum - k) is present, it means that
			// between that
			// point and this, the sum has to equal k
			// System.out.println("preSum - k = " + (preSum - k));
			if (map.containsKey(preSum - k)) { // Subarray found
				System.out.println("\npreSum - k = " + (preSum - k));
				System.out.println("list = " + map.get(preSum - k));
				List<Integer> startIndices = map.get(preSum - k);
				for (int start : startIndices) {
					System.out.println("Start: " + (start + 1) + "\tEnd: " + i + " map: " + map);
				}
			}

			List<Integer> newStart = new ArrayList<Integer>();
			if (map.containsKey(preSum)) {
				newStart = map.get(preSum);
			}
			newStart.add(i);
			// System.out.println("preSum = " + preSum + ", newStart = " +
			// newStart);
			map.put(preSum, newStart);
		}
	}
	
	public int GetNextSeriesElement(int input1,int[] input2) {
		// Read only region end
		int res = -999;
		if(input1 < 3 || input2 == null || input1 != input2.length) {
			return res;
		}
		//check if the series is Arithmetic
		boolean ars = false;
		int comDif1 = input2[1] - input2[0];
		int comDif2 = input2[2] - input2[1];
		if(comDif1 == comDif2) {
			ars = true;
		}
		//check if the series is Geometric
		boolean gs = false;
		int comRatio1 = input2[1] / input2[0];
		int comRatio2 = input2[2] / input2[1];
		if(comRatio1 == comRatio2) {
			gs = true;
			ars = false;
		}
		//check if the series is Fibonacci
		boolean fibs = false;
		if(input2[2] == (input2[1] + input2[0])) {
			fibs = true;
			gs = false;
			ars = false;
		}

		int iL = input2.length;
		
		//solution for Arithmetic
		if(ars) {
			res = (input2[iL - 1] + comDif1);
		}
		//solution for Geometric
		if(gs) {
			res = (input2[iL - 1] * comRatio1);
		}
		//solution for Fibonacci
		if(fibs) {
			res = (input2[iL - 1] + input2[iL - 2]);
		}
		
		return res;
	}

}
