package practice.dev.problemsolving;

public class FibonacciRecursive {

	static int n1=0,n2=1,sum=0;    
	static void printFibonacci(int count) {    
	    if(count>0){    
	    	sum = n1 + n2;    
	         n1 = n2;    
	         n2 = sum;    
	         System.out.print(" "+sum);   
	         printFibonacci(count-1);    
	     }    
	}
	

	static int fibonacci(int count) {
		if(count == 0) {
			return 0;
		} else if(count == 1) {
			return 1;
		}
		return fibonacci(count - 1) + fibonacci(count - 2);
	}
	 
	public static void main(String args[]) {    
		  int count=10;    
		  System.out.print(n1+" "+n2);//printing 0 and 1    
		  printFibonacci(count-2);//n-2 because 2 numbers are already printed
		  System.out.print("\nfibonacci number at " + count + " is -> ");
		  System.out.println(fibonacci(count));
	}  
}  
