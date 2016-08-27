package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AVerySpecialMultipl {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner sc = new Scanner(System.in);
		Integer numOfIns = Integer.valueOf(sc.nextLine());
		// System.out.println(numOfIns);
		List<Integer> ins = new ArrayList<>();
		while (numOfIns > 0) {
			--numOfIns;
			ins.add(Integer.valueOf(sc.nextLine()));
		}
		// System.out.println(ins);
		ArrayList<Integer> res = getZ(ins);
		// System.out.println(res);
		// for(Integer te : res) {
		// System.out.println(te);
		// }
	}

	private static ArrayList<Integer> getZ(List<Integer> ins) {
		Integer y = 1, mulres = 0, mrsl = 0, a = 0, b = 0, z = ((2 * a) + b);
		char[] mrs;
		boolean is4Breached = false, isInvalidRes = false;
		ArrayList<Integer> res = new ArrayList<>();

		for (Integer x : ins) {
			y = 1;
			while (true) {
				mulres = x * y;
				// System.out.println("mulres = " + mulres);
				mrs = mulres.toString().toCharArray();
				mrsl = (mrs.length - 1);
				// System.out.println("mrsl = " + mrsl);
				for (int i = 0; i <= mrsl; ++i) {
					if (mrs[i] == '4' && !is4Breached) {
						++a;
						// System.out.println("a = " + a);
					} else if (mrs[i] == '0') {
						is4Breached = true;
						++b;
						// System.out.println("b = " + b);
					} else {
						isInvalidRes = true;
						is4Breached = false;
						break;
					}
				}
				if (!isInvalidRes) {
					z = ((2 * a) + b);
					res.add(z);
					System.out.println(z);
					// System.out.println("z = " + z);
					// System.out.println("y = " + y);
					break;
				} else {
					a = 0;
					b = 0;
					z = 0;
					isInvalidRes = false;
					++y;
				}
			}
		}
		return res;
	}
}
