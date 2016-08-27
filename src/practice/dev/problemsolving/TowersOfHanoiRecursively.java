package practice.dev.problemsolving;

import java.util.Scanner;

/**
 * 
 * @author dev

Towers of Hanoi: The 'Towers of Hanoi' is a classical problem used to illustrate the power of recursion. The puzzle goes as follows.

There are three poles and 64 discs of different sizes. Initially, all the discs are placed on the first pole 
with the largest disc at the bottom and the smallest one at the top. We need to move all the discs from the 
first pole to the third pole, with the smallest disc at the top and the largest at the bottom. 
We can move only one disc at a time (which should be the topmost disc) and at any point of time, 
a larger disc cannot be placed over a smaller one i.e. all the discs on a pole must be placed in such a way 
that the smallest is at the top and the largest at the bottom. The second pole can be used as an intermediate pole 
to help us in transferring the discs.

This puzzle can be solved using recursion. For a moment, assume that there are just two discs (disc 1 and 2; disc 2 being the larger one) on the first pole. The solution consists of three steps.

Step 1: Move disc 1 from pole 1 to pole 2.
Step 2: Move disc 2 from pole 1 to pole 3.
Step 3: Move disc 1 from pole 2 to pole 3.


Now, assume that disc 1 is not a single disc but a collection of discs. The procedure would be similar to the above three steps, but steps 1 and 3 would be a collection of steps. Step 1 would be to move the n-1 discs (assuming that there were a total of n discs) from pole 1 to pole 2. For moving these (n -1) discs, we again follow the same strategy of considering them as 1 disc plus a set of n-2 discs. Step 3 would also be similar. This gives us the recursive solution.

Recursive Algorithm
The recursive solution to move n discs from the start pole to the end pole using an auxiliary pole is given below.

Base Case - When n = 1
Move the disc from start pole to end pole

Recursive Case - When n > 1
Step 1: Move (n-1) discs from start pole to auxiliary pole.
Step 2: Move the last disc from start pole to end pole.
Step 3: Move the (n-1) discs from auxiliary pole to end pole.
Steps 1 and 3 are recursive invocations of the same procedure. 

 *
 */
public class TowersOfHanoiRecursively {
	
	private static int iterationNum = 0;
	
	public void solve(int n, String start, String auxiliary, String end) {
	       if (n == 1) {
	           System.out.println(++iterationNum + ". " + n + ". " + start + " -> " + end);
	       } else {
	           solve(n - 1, start, end, auxiliary);
	           System.out.println(++iterationNum + ". " + n + ". " + start + " -> " + end);
	           solve(n - 1, auxiliary, start, end);
	       }
	   }

	   public static void main(String[] args) {
		   TowersOfHanoiRecursively towersOfHanoi = new TowersOfHanoiRecursively();
	       System.out.print("Enter number of discs: ");
	       Scanner scanner = new Scanner(System.in);
	       int discs = scanner.nextInt();
	       towersOfHanoi.solve(discs, "start", "auxiliary", "end");
	       towersOfHanoi.solve(discs, "A", "B", "C");
	       scanner.close();
	   }
}
