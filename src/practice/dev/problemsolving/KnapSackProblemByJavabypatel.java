package practice.dev.problemsolving;

/**
 * refer great detail description here:
 * http://javabypatel.blogspot.in/2016/09/knapsack-problem-solution-recursive-iterative.html
 * 
 * @author dev
 *
 */
public class KnapSackProblemByJavabypatel {

	public static void main(String[] args) {
		int knapsackMaxWeight = 5;
		int profit[] = { 200, 240, 140, 150 };
		int weight[] = { 1, 3, 2, 5 };

		// int maxProfit = maximizeProfitRecursive(weight, profit,
		// weight.length, knapsackMaxWeight);
		int maxProfit = maximizeProfit(weight, profit, knapsackMaxWeight);

		System.out.println(maxProfit);
	}

	//Recursive solution for Knapsack in Java
	private static int maximizeProfitRecursive(int[] weightArr, int[] profitArr, int currentItem, int knapsackWeight) {

		// If either knapsack weight capacity reached 0 or we don't have more
		// items to pick,
		// return 0 in either case.
		if (knapsackWeight == 0 || currentItem == 0) {
			return 0;
		}

		// if weight of current item on which we are working is greater than
		// knapsack remaining capacity,
		if (weightArr[currentItem - 1] > knapsackWeight) {

			// then we can't pick current item, keep knapsack remaining
			// capacity as it is and try checking next item
			return maximizeProfitRecursive(weightArr, profitArr, currentItem - 1, knapsackWeight);
		} else {

			// Here we have 2 choice, we can either pick the item or not to
			// pick.
			// So we have to check profit by picking the item and profit by not
			// picking the item
			// (obviously keeping weight constraint in mind otherwise picking
			// item will always be beneficial)

			// we can pick current item, reduce knapsack remaining capacity by
			// subtracting
			// current item weight from knapsack capacity, and check for next
			// item.
			int including = profitArr[currentItem - 1] + maximizeProfitRecursive(weightArr, profitArr, currentItem - 1,
					knapsackWeight - weightArr[currentItem - 1]);

			// Check Profit by not picking item, keep knapsack remaining
			// capacity as it is and try
			// checking next item
			int excluding = maximizeProfitRecursive(weightArr, profitArr, currentItem - 1, knapsackWeight);

			// Whichever gives us maximium profit, return that.
			return Math.max(including, excluding);
		}
	}

	//Dynamic programming / Iterative solution for Knapsack Problem in Java
	private static int maximizeProfit(int[] weight, int[] profit, int max) {
		int[][] temp = new int[weight.length + 1][max + 1];

		for (int row = 0; row <= weight.length; row++) {
			for (int col = 0; col <= max; col++) {

				// Represent 0 item OR Sack with capacity 0
				if (row == 0 || col == 0) {
					continue;
				}

				// If col represent Sack weight and if it is >= item weight,
				// it means item is eligible to be picked.
				if (col >= weight[row - 1]) {

					// Checking picking the item will give Max profit
					// or not picking the item will give Max profit.
					temp[row][col] = Math.max(profit[row - 1] + temp[row - 1][col - weight[row - 1]],
							temp[row - 1][col]);
				} else {

					// Sack weight is less than item weight, So can't pick item
					// and Max profit we
					// can get at this point is profit we got in previous step
					// by not picking current item
					temp[row][col] = temp[row - 1][col];
				}
			}
		}
		return temp[weight.length][max];
	}

}
