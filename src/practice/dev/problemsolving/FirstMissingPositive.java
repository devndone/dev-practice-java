package practice.dev.problemsolving;

import java.util.ArrayList;

/**
 * 
 * @author dev
 *
 
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.

 */
public class FirstMissingPositive {
	
public int firstMissingPositive(ArrayList<Integer> A) {
	    
	    int n = A.size() + 1;
	    int count;
	    int idx = 0;
	    int size = A.size();
	    count = size - 1;
	    
	    for (idx = size - 1; idx >= 0; idx--) {
	        
	        int num = A.get(idx);
	        
	        if (num < 0) {
	            int val = A.get(count);
	            A.set(idx, val);
	            A.set(count, num);
	            count--;
	        }
	        
	    }
	    
	    for (idx = 0; idx <= count; idx++) {
	        
	        int num = A.get(idx);
	        
            num = Math.abs(num);
	        
	        if (num > 0 && num < n) {
	            
	            int index = num - 1;
	            int val = A.get(index);
	            A.set(index, -val);
	            
	        }
	        
	    }
	    
	    for (idx = 0; idx <= count; idx++) {
	        
	        int num = A.get(idx);
	        
	        if (num > 0) {
	            return idx + 1;
	        }
	        
	    }
	    
	    return idx + 1;
	    
	}
	
}
