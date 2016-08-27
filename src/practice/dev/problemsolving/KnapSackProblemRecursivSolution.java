package practice.dev.problemsolving;

public class KnapSackProblemRecursivSolution {

	int[] v = {7,2,1,6,12};//vertices
	int[] w = {3,1,2,4,6};//weight set
	int capacity = 10;
	int n = v.length;//Global Variable as v[1..n] or w[1..n]
	
	public static void main(String [] args) {
		
	}
	
	/*
	 * c : Capacity for containing solution
	 * i : Index of the first undecided object
	 */
	int ks(int c, int i) {
		
		if(i > n) {
			return 0;
		}
		
		if(c < w[i]) {//if true then ignore the present index and recursive get solution from next index
			return ks(c, (i+1));
		}
		
		return Math.max(ks(c,  (i+1)), (v[i]+ks((c-w[i]), (i+1))));
		
	}
	
}
