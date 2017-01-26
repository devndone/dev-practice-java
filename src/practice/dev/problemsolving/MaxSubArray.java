package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

public class MaxSubArray {

	// By Vishnu
	public static int maxSumForContinous(int a[]) {
        int element = 0;
        int max = Integer.MIN_VALUE;
        if (a[0] > 0) {
            element = a[0];
        }
        for (int i = 1; i < a.length; i++) {
            element = element + a[i];
            if (element < 0) {
                element = 0;
            }
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
	
	/*
	 * Good only for collection that has at least one element with value equal to or greater than 0 
	 * i.e. contains at least one non-negative element
	 */
	// DO NOT MODFIY THE LIST. 
	public int maxSubArrayByKadaneAlgorithm(final List<Integer> a) {
		int ans = 0, sum = 0;
		for(int i = 0; i < a.size(); ++i) {
			if(sum + a.get(i) > 0) {
				sum += a.get(i);
			} else {
				sum = 0;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	
	/*
	 * Best Solution for all cases for finding max value, and start & end index too.
	 */
	// DO NOT MODFIY THE LIST. 
	public int maxSubArrayByKadaneAlgorithmModified(final List<Integer> a) {
	    int ans = 0, sum = 0, max = Collections.max(a);
	    boolean isNegativeValuesOnly = false, reInitialize = false;
	    if(max < 0) {
	       isNegativeValuesOnly = true;
	       reInitialize = true;
	       ans = max;
	    }
		for(int i = 0; i < a.size(); ++i) {
			if(reInitialize) {
				sum = a.get(i);
				reInitialize = false;
			} else if((isNegativeValuesOnly && sum + a.get(i) > sum)
			            || (sum + a.get(i) > 0)) {
				sum += a.get(i);
			} else {
				if(isNegativeValuesOnly) {
					reInitialize = true;
				} else {
					sum = 0;
				}
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	
	/*
	 * Best Solution for all cases but only for finding max value, and not for finding start & end index
	 */
	// DO NOT MODFIY THE LIST. 
	public static int maxSubArraySum(final List<Integer> arr) {
		int max_so_far = arr.get(0);
		int curr_max = arr.get(0);
		for(int i = 0; i < arr.size(); i++) {
			curr_max = Math.max(arr.get(i), (curr_max + arr.get(i)));
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(-2);
		arr.add(-3);
		arr.add(4);
		arr.add(-1);
		arr.add(-2);
		arr.add(1);
		arr.add(5);
		arr.add(-3);
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(arr));
	}
	
	// DO NOT MODFIY THE LIST. 
	public int maxSubArrayByDivideAndConquer(final List<Integer> a, int n) {
		if(n == 1) {
			return a.get(0);
		}
		int m = n/2;
		int left_MSS = maxSubArrayByDivideAndConquer(a.subList(0, m), m);
		int right_MSS = maxSubArrayByDivideAndConquer(a.subList(m, n), (n - m));
		int leftsum = Integer.MIN_VALUE, rightsum = Integer.MIN_VALUE, sum = 0;
		for(int i = m; i < n; i++) {
			sum += a.get(i);
			rightsum = Math.max(rightsum, sum);
		}
		sum = 0;
		for(int i = (m - 1); i >= 0; --i) {
			sum += a.get(i);
			leftsum = Math.max(leftsum, sum);
		}
		int ans = Math.max(left_MSS, right_MSS);
		return ans;
	}
	
}
