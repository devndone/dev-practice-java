package practice.dev.problemsolving;

import java.math.BigInteger;

class FacorialOfBigNuumber {

	<T extends Number> void FacorialOfBigNuumber(T i) {

	}

	public static void main(String[] args) throws java.lang.Exception {
		Thread n = new Thread();
		BigInteger start = BigInteger.ONE;
		long findTill = 5000L;
		for (int i = 2; i <= findTill; i++) {
			start = start.multiply(new BigInteger(String.valueOf(i)));
		}

		System.out.println("The Factorial of Number " + findTill + " is -> "
				+ start);
		String h = "Hello" + " " + " ";
		h = h.concat("world");
		System.out.println(h);
	}
}
