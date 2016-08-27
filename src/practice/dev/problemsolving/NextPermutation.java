package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author dev
 *
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples(Inputs are in the left-hand column and its corresponding outputs are in the right-hand column):
1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50

 *
 */
public class NextPermutation {
	public void nextPermutation(ArrayList<Integer> A) {
	    boolean status;
	    status = nextPerm(A);
	    if (!status)
	        Collections.sort(A);
	    return;
	}
	
	
	public boolean nextPerm(ArrayList<Integer> A) {
	    
	    int i = 0;
	    int n = A.size();
	    
	    for (i = n - 2; i >= 0; i--) {
	        if (A.get(i) < A.get(i + 1))
	            break;
	    }
	    
	    if (i == -1)
	        return false;
	   
	    int j = n - 1;
	    
	    for (; j >= i; j--) {
	        if (A.get(j) > A.get(i))
	            break;
	    }
	    
	    swap(A, i, j);
	    
	    i++;
	    int steps = (n - i + 1) / 2;
	    
	    for (int k = 0; k < steps; k++) {
	        swap(A, i + k, n - k - 1);
	    }
	    
	    return true;
	}
	
	public void swap(ArrayList<Integer> A, int i, int j) {
	    int temp = A.get(i);
	    A.set(i, A.get(j));
	    A.set(j, temp);
	}
	
}
