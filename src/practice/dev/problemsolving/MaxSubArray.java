package practice.dev.problemsolving;

import java.util.Collections;
import java.util.List;

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
	 * Best Solution for all cases
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
