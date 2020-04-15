package practice.dev.problemsolving;

import java.util.*;

public class ArrangeNumbersToFormSmallestNumber {
	
	private static class Sort implements Comparable<Object> {
		String number;

		public Sort(String aa) {
			number = aa;
		}

		@Override
		public int compareTo(Object b) {
			String firstNumber = number + ((Sort) b).number;
			String secondNumber = ((Sort) b).number + number;
			return firstNumber.compareTo(secondNumber);
		}

		@Override
		public String toString() {
			return number.toString();
		}
	}

	private static void sort(String arr[]) {
		if (arr == null || arr.length == 0)
			return;
		int length = arr.length;
		List<Sort> list = new ArrayList<Sort>();
		for (int i = 0; i < length; ++i) {
			list.add(new Sort(arr[i]));
		}
		Collections.sort(list);
		System.out.print(Arrays.toString(list.toArray()) + " ==> ");
		Iterator<Sort> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().number);
		}
	}

	public static void main(String[] args) {
		String arr[] = { "54", "1", "546", "548", "60" };

		sort(arr);//Output is -> 15454654860
		System.out.println();
		String arr1[] = { "34", "3", "98", "9", "76", "45", "4" };
		sort(arr1);//Output is -> 33444576989
		System.out.println();
		String arr2[] = { "10","8","2","3"};
		sort(arr2);//Output is -> 10238
	}
	
}
