package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author dev
 *
 * 
 *         Given a number N, find all prime numbers upto N ( N included ).
 * 
 *         Example:
 * 
 *         if N = 7,
 * 
 *         all primes till 7 = {2, 3, 5, 7}
 * 
 *         Make sure the returned array is sorted.
 * 
 *
 */
public class SieveOfEratosthenesOrFindAllPrimeNumbersTill {

	public static void main(String[] args) {
		List res = findAllPrimes(36);
		Collections.sort(res);
		System.out.println(res);
		res = findAllPrimes(177);
		Collections.sort(res);
		System.out.println(res);
	}

	public static List<Integer> findAllPrimes(int a) {
		ArrayList<Integer> allp = new ArrayList<>();

		// Integer[] primes = new Integer[a];
		allp.add(0);
		for (int i = 1; i < a; i++) {
			allp.add(1);
		}
		allp.set(0, 1);
		allp.set(1, 1);
		for (int i = 2; i <= (int) Math.sqrt(a); ++i) {
			if (allp.get(i) == 1) {
				for (int j = 2; (i * j) < a; ++j) {
					allp.set((i * j), 0);
				}
			}
		}
		ArrayList<Integer> allpres = new ArrayList<>();
		for (int i = 2; i < a; ++i) {
			if (allp.get(i) == 1) {
				allpres.add(i);
			}
		}

		return allpres;

	}
}
