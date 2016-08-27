package practice.dev.problemsolving;

import java.util.Arrays;

/**
 * 
 * @author dev
 * 
 *  Given two arrays of length m and n with digits 0-9 representing two numbers. 
 *  Create the maximum number of length k <= m + n from digits of the two. 
 *  The relative order of the digits from the same array must be preserved. 
 *  Return an array of the k digits. 
 *  You should try to optimize your time and space complexity.

	Example 1:
	
	nums1 = [3, 4, 6, 5]
	nums2 = [9, 1, 2, 5, 8, 3]
	k = 5
	return [9, 8, 6, 5, 3]
	
	Example 2:
	
	nums1 = [6, 7]
	nums2 = [6, 0, 4]
	k = 5
	return [6, 7, 6, 0, 4]
	
	Example 3:
	
	nums1 = [3, 9]
	nums2 = [8, 9]
	k = 3
	return [9, 8, 9]
	
	Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test cases.
 *
 */
public class CreateMaxNumber1 {
	
	public static void main(String[] args) {	
		int[] nums1 = {3, 4, 6, 5};
		int[] nums2 = {9, 1, 2, 5, 8, 3};
		int k = 5;
		System.out.println(Arrays.toString(CreateMaxNumber1.maxNumber(nums1, nums2, k)));
	}
	
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
	    int resSize = nums1.length + nums2.length;
	    int[] result = new int[resSize];
	    int i = 0, j = 0, s = 0;
	    while(s < resSize && i < nums1.length && j < nums2.length) {
	        if(nums1[i] < nums2[j]) {
	            result[s] = nums2[j];
	            j++;
	        } else {
	            result[s] = nums1[i];
	            i++;
	        }
	        s++;
	    }
	    return result;
	    //return Arrays.copyOf(result, k);
	    //return [9, 8, 6, 5, 3]
	}
}
