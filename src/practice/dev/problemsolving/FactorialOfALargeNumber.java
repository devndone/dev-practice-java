package practice.dev.problemsolving;

public class FactorialOfALargeNumber {

	static int digix = 1000;
	static int[] digits = new int[digix+1];
	
	public static void main(String[] args) {
		int factTill = 100;
		for(int i = 0; i < digix; ++i) {
			digits[i] = 1;
		}
		factorial(factTill);
		for(int i = 0; i < digix; ++i) {
			//digits[i] = 1;
			System.out.print(digits[i]);
		}
	}
	
	public static void factorial(int factTill) {
		if(factTill == 1) {
			return;
		}
		System.out.println(factTill);
		--digix;
		--factTill;
		factorial(factTill);
		
		int rem = 0, mul = 0;
		// One by one multiply n with individual digits of res[]
	    for (int i=0; i<digix; i++)
	    {
	        mul = ((digits[i] * factTill) + rem);
	        digits[i] = mul % 10;  // Store last digit of 'prod' in res[]
	        rem  = mul/10;    // Put rest in carry
	    }/*
	 
	    // Put carry in res and increase result size
	    while (rem > 0)
	    {
	    	digits[digix] = rem%10;
	        rem = rem/10;
	        digix++;
	    }*/
	}
}