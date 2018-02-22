package practice.dev.problemsolving;

import java.util.Scanner;

public class PascalTriangleUsingBinomialCoefficients {

	public static void print(int row) {
		for (int n = 0; n < row; n++) {
			for (int k = 0; k <= n; k++) {
				System.out.print(nCk(n, k) + " ");
			}
			System.out.println();
		}
	}

	public static int nCk(int n, int k) {
		int numerator = fact(n);
		int denominator = fact(k) * fact(n - k);
		int result = (int) (numerator / denominator);
		return result;
	}

	public static int fact(int num) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the row number upto which Pascal's triangle has to be printed: ");
		int row = scanner.nextInt();
		print(row);
		scanner.close();
	}
}
