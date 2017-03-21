package practice.dev.problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.

Before we go further, let us understand with few examples:
    ab: Number of insertions required is 1. bab
    aa: Number of insertions required is 0. aa
    abcd: Number of insertions required is 3. dcbabcd
    abcda: Number of insertions required is 2. adcbcda which is same as number of insertions in the substring bcd(Why?).
    abcde: Number of insertions required is 4. edcbabcde

 * @author dev
 *
 */
public class PalindromeCompletion {

	/**
	 * In a palindome at max only one element could appear odd times. 
	 * so the problem now is to just find how many elements appeared odd times (Let say n) 
	 * and the answer is (n - 1).
	 * Limitation:
	 * In case when there is only 1 character that appeared odd number of times (say,1 time) , 
	 * and the string is not a palindrome, the answer this algo will give is zero, 
	 * which would be wrong. Ex. str ="ARRAY". 
	 * @param str
	 * @return
	 */
	public int solution2(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);

			if (map.get(character) == null) {
				map.put(character, 1);
			} else {
				map.put(character, map.get(character) + 1);
			}
		}

		int n = 0;
		// find how many elements appeared odd no of times.
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				n++;
			}
		}

		// returning n - 1 because one element could appear odd no of time.
		return n == 0 ? n : n - 1;
	}
	
	/**
	 * (1) space complexity O(n2) time complexity code
	 * @param input
	 * @return
	 */
	public int findMinInsertions(String input) {
		int n = input.length();
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < n; k++) {
			int c = 0;
			for (int i = k, j = k; i >= 0 || j < n; i--, j++) {
				if (i < 0) {
					c += n - j;
					break;
				}
				if (j >= n) {
					c += i + 1;
					break;
				}
				if (input.charAt(i) != input.charAt(j)) {
					c += 2;
				}
			}
			if (min > c) {
				min = c;
			}
		}

		for (int k = 0; k < n; k++) {
			int c = 0;
			for (int i = k, j = k + 1; i >= 0 || j < n; i--, j++) {
				if (i < 0) {
					c += n - j;
					break;
				}
				if (j >= n) {
					c += i + 1;
					break;
				}
				if (input.charAt(i) != input.charAt(j)) {
					c += 2;
				}
			}
			if (min > c) {
				min = c;
			}
		}
		return min;
	}
}
