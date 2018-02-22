package practice.dev.problemsolving;

import java.util.Arrays;

/**
 * You are given an array of 0s, 1s, and 2s in random order. 
 * Sort the array so the 0, 1, and 2 are segregated. 
 * This problem is similar to Dutch national Flag problem.
 * 
 * @author dev
 *
 */
public class SortRgbColours_InMemory {
	
	public static void main(String[] args) {
		
		String[] arg = {"R", "G", "G", "B", "R", "B", "B", "R", "G"};
		System.out.println("Input: \n" + Arrays.toString(arg) + "\n\n");
		sort(arg);
		System.out.println("Output: \n" + Arrays.toString(arg));
		
	}
	
	private static void sort(final String[] args) {
		if(args == null || args.length < 1) {
			throw new RuntimeException("Invalid Input");
		}
		int start = -1, end = args.length, mid = 0;
		while(mid < end) {
			if(args[mid] == "R") {
				start++;
				swap(args, start, mid);
				mid++;
			} else if(args[mid] == "G") {
				mid++;
			} else if(args[mid] == "B") {
				end--;
				swap(args, mid, end);
			}
			else {
				throw new RuntimeException("Invalid Input");
			}
		}
	}

	private static void swap(final String[] args, final int start, final int mid) {
		if(args == null || args.length < 1 || start < 0 || start > mid) {
			throw new RuntimeException("Invalid Input");
		}
		if(start == mid) {
			return;
		}
		String temp = args[start];
		args[start] = args[mid];
		args[mid] = temp;
		return;
	}
}
