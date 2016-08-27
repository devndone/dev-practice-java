package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorsOfANumber {

	public static void main(String[] args) {
		List res = factorsOfANumber(36);
		Collections.sort(res);
		System.out.println(res);
		res = factorsOfANumber(177);
		Collections.sort(res);
		System.out.println(res);
	}

	public static List<Integer> factorsOfANumber(int number) {
		List<Integer> factors = new ArrayList<>();
		int sqrtOfNum = (int) Math.sqrt(number), i = 1;
		while (i <= sqrtOfNum) {
			if (number % i == 0) {
				factors.add(i);
				if (i != sqrtOfNum) {
					factors.add(number / i);
				}
			}
			i++;
		}
		return factors;
	}

	// Best Solution
	public List<Integer> allFactors(double a) {
		List<Integer> factors = new ArrayList<>();
		double sqrtOfNum = Math.sqrt(a), i = 1;
		while (i <= sqrtOfNum) {
			if (a % i == 0) {
				factors.add(((int) i));
				if (i != sqrtOfNum) {
					factors.add((int) (a / i));
				}
			}
			i++;
		}
		Collections.sort(factors);
		return factors;
	}
}
