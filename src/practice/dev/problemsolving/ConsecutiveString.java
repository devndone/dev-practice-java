package practice.dev.problemsolving;

import java.util.HashMap;

public class ConsecutiveString {
	
	class Node {

		Integer first;
		Integer last;

		Node(Integer first_int, Integer last_int) {

			this.first = first_int;
			this.last = last_int;
		}
	}

	public static void main(String[] args) {
		Integer max_length = 0;
		Node max_chain = null;

		HashMap<Integer, Node> table = new HashMap<Integer, Node>();

		//Integer[] numbers = { 101, 2, 3, 104, 5, 103, 9, 102 };
		Integer[] numbers = { 1, 3, 5, 7, 9, 4, 6, 2, 8 };
		for (Integer number : numbers) {

			if (table.containsKey(number)) {
				continue;
			} else {
				Node here;
				if (table.containsKey(number - 1)) {
					Node left = table.get(number - 1);
					left = table.get(left.first);
					if (table.containsKey(number + 1)) {
						Node right = table.get(number + 1);
						right = table.get(right.last);
						// We have both left and right. Link them and
						// store in both sides
						left.last = right.last;
						right.first = left.first;
						here = left; // Or right, it's the same
					} else {
						// there is a node at our left, but not at the right.
						left.last = number;
						table.put(number, left);
						here = left;
					}
				} else if (table.containsKey(number + 1)) {
						// We have only a node at our right
						Node right = table.get(number + 1);
						right = table.get(right.last);
						right.first = number;
						here = right;
				} else {
						// No other node around
						here = new ConsecutiveString().new Node(number, number);
					}
				table.put(number, here);
				int length = here.last - here.first + 1;
				if (length > max_length) {
					max_length = length;
					max_chain = here;
				}

			}

		}

		System.out.println(max_chain.first.toString() + " - " +
		                   max_chain.last.toString());

	}
}
