package practice.dev.algo;

public class AlexanderBogomolynsUnorderedPermutation {

	public static void main(String [] args) {
		final int N = 4;
		final int[] values = new int[N];
		for(int i = 0; i < N; i++) {
			values[i] = 0;
		}
		visit(values, N, 0);
	}
	
	public static void visit(final int[] values, final int N, int k) {
		int level = -1;
		level = level + 1;
		values[k] = level;
		
		if(level == N) {
			print(values, N);
		} else {
			for(int i = 0; i < N; i++) {
				if(values[i] == 0) {
					visit(values, N, i);
				}
			}
		}
		level = level - 1;
		values[k] = 0;
	}
	
	public static void print(final int[] values, final int size) {
		if(values != null && values.length > 0) {
			for(int i = 0; i < size; i++) {
				if(values[i] != 0) {
					System.out.printf("%d", values[i]);
				}
			}
			System.out.println();
		}
	}
}
