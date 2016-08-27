package practice.dev.problemsolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Merge2Array {
	
	public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = br.readLine();
        String[] in1ArrStr = line.split(" ");
        int[] in1Arr = new int[in1ArrStr.length];
        for (int i = 0; i < in1ArrStr.length; i++) {
            in1Arr[i] = Integer.parseInt(in1ArrStr[i]);
        }
        line = br.readLine();
        String[] in2ArrStr = line.split(" ");
        int[] in2Arr = new int[in2ArrStr.length];
        for (int i = 0; i < in2ArrStr.length; i++) {
            in2Arr[i] = Integer.parseInt(in2ArrStr[i]);
        }
		
		int[] resArr = new int[in1Arr.length + in2Arr.length];
		if(in2Arr.length > in1Arr.length) {
			resArr = merge(in2Arr, in1Arr, resArr);
		} else {
			resArr = merge(in1Arr, in2Arr, resArr);
		}
		print(resArr);
    }
    
    private static void print(int[] resArr) {
    	for(int i = 0; i < resArr.length; ++i) {
    		System.out.print(resArr[i]);
    		System.out.print(" ");
    	}
    }
    
    private static int[] merge(int[] bigerArray, int[] smallerArray, int[] resArr) {
    	int i = 0, j = 0, k = 0;
    	while(i < bigerArray.length && j < smallerArray.length) {
    		if(bigerArray[i] > smallerArray[j]) {
    			resArr[k] = smallerArray[j];
    			j++;
    		} else {
    			resArr[k] = bigerArray[i];
    			i++;
    		}
    		k++;
    	}
    	while(i < bigerArray.length) {
    		resArr[k] = bigerArray[i];
    		i++;
    		k++;
    	}
    	while(j < smallerArray.length) {
    		resArr[k] = smallerArray[j];
    		j++;
    		k++;
    	}
    	return resArr;
    }
}

