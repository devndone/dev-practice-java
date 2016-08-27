package practice.dev.problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 * 

Logic here is that each element in the hashtable keeps track of the sequence. 
So boundary elements of the sequence are important as the end element 
of the sequence points to beginning element of the sequence 
and beginning element of the sequence points to the end element. 
So whenever a new element is to be added to the sequence 
it picks up the boundary value and becomes the new boundary. 
Check how 8 is added to the table below:


Array a:      [1, 6, 10, 4, 7, 8]

i: 1 	 Table: {1=1}
i: 6 	 Table: {1=1, 6=6}
i: 10 	 Table: {1=1, 6=6, 10=10}
i: 4 	 Table: {1=1, 4=4, 6=6, 10=10}
i: 7 	 Table: {1=1, 4=4, 6=7, 7=6, 10=10}
i: 8 	 Table: {1=1, 4=4, 6=8, 7=6, 8=6, 10=10}

 * 
 * @author dev
 *
 */
public class LongestConsecutiveSequence {

	public int[] longestConsecutiveSequence(int[] a) {
		int first = Integer.MAX_VALUE; // the first number of the maximum
										// consecutive sequence
		int length = 0; // the length of the maximum consecutive sequence
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		for (int i : a) {
			if (!table.containsKey(i)) {
				int start = i;
				int end = i;
				if (table.containsKey(i + 1) && table.get(i + 1) >= i + 1) {
					end = table.get(i + 1);
					table.remove(i + 1);
					table.remove(end);
				}
				if (table.containsKey(i - 1) && table.get(i - 1) <= i - 1) {
					start = table.get(i - 1);
					table.remove(i - 1);
					table.remove(start);
				}
				table.put(start, end);
				table.put(end, start);
				if (end - start + 1 > length) {
					first = start;
					length = end - start + 1;
				}
			}
		}
		System.out.println(table);
		System.out.println(length);
		int[] s = new int[length];
		for (int i = 0; i < length; i++)
			s[i] = first + i;
		return s;
	}

}
