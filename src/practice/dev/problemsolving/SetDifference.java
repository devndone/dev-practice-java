package practice.dev.problemsolving;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SetDifference {
	public static void main(String... args) {
		String[] arrA = { "1", "2", "3", "4", "5", "25", "10" };
		String[] arrB = { "1", "2", "10", "4", "30" };

		System.out.println(Arrays.toString(differences(arrA, arrB)));
	}

	public static String[] differences(String[] first, String[] second) {
		String[] sortedFirst = Arrays.copyOf(first, first.length); // O(n)
		String[] sortedSecond = Arrays.copyOf(second, second.length); // O(m)
		Arrays.sort(sortedFirst); // O(n log n)
		Arrays.sort(sortedSecond); // O(m log m)

		int firstIndex = 0;
		int secondIndex = 0;

		LinkedList<String> diffs = new LinkedList<String>();

		while (firstIndex < sortedFirst.length
				&& secondIndex < sortedSecond.length) { // O(n + m)
			int compare = (int) Math.signum(sortedFirst[firstIndex]
					.compareTo(sortedSecond[secondIndex]));

			switch (compare) {
			case -1:
				diffs.add(sortedFirst[firstIndex]);
				firstIndex++;
				break;
			case 1:
				diffs.add(sortedSecond[secondIndex]);
				secondIndex++;
				break;
			default:
				firstIndex++;
				secondIndex++;
			}
		}

		if (firstIndex < sortedFirst.length) {
			append(diffs, sortedFirst, firstIndex);
		} else if (secondIndex < sortedSecond.length) {
			append(diffs, sortedSecond, secondIndex);
			Map<Character, Character> n = new LinkedHashMap<Character, Character>();
			n.putIfAbsent('A', 'A');

			for (Character c : n.keySet()) {

			}
		}

		String[] strDups = new String[diffs.size()];

		return diffs.toArray(strDups);
	}

	private static void append(LinkedList<String> diffs, String[] sortedArray,
			int index) {
		while (index < sortedArray.length) {
			diffs.add(sortedArray[index]);
			index++;
		}
	}
}
