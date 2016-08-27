package practice.dev.problemsolving;

/*******************************************************************************
Let's take a look at how to generate numbers in this sequence called Pernix sequence.
 
500055 ==> 510352
 
Number 510352 is derived from 500055 in the following manner
 
step1:  500055
step2:  count how many times each digit is repeated consecutively.
step3: 5 occured 1 time, 0 occured 3 times, 5 occured 2 times
step4: 51, 03, 52
step5: 510352
 
Similarly 510352 ==> 51 11 01 31 51 21 ( See if you understand how this number is derived. Otherwise ask questions).
 
Pernix Sequence is  500055 ==> 510352 ==> 511101315121 and so on
            1st     ⇒      2nd     ⇒    3rd


Write a function that takes two arguments ( starting number, n-th-number-in-the-sequence where n>=1) and prints one number as output. For example calling this function with
("500055", 1) will return "500055"( 1st number in the sequence)
("500055", 2) will return "510352"( 2nd number in the sequence)
("500055", 3) will return "511101315121"( 3rd number in the sequence)

*
*/

public class PernixSequence {

	public void printPernixNextSeq(String number, int nthNum) {
	    if(number == null || number.isEmpty()) {
	        return;
	    }
	    if(nthNum == 1) {
	        System.out.println(number);
	        return;
	    }
	    System.out.println(getPernixNextSeq(number, nthNum));
	}
	
	public String getPernixNextSeq(String number, int nthnum) {
	
	    StringBuilder sb = new StringBuilder();
	    
	    char[] ins = number.toCharArray();
	    char prev = ins[0];
	    int count = 1;
	    while(nthnum > 1) {
	        for(int i = 1; i < ins.length; ++i) {
	            if(prev == ins[i]) {//335->prev=3&ins=3;prev=3&ins=5;
	                ++count;
	                continue;
	            }
	            sb.append(prev);//3
	            sb.append(count);//2
	            prev = ins[i];//prev=5
	            count = 1;
	        }
	        sb.append(prev);//5
	        sb.append(count);//1
	        ins = sb.toString().toCharArray();
	        prev = ins[0];
	        count = 1;
	        --nthnum;
	    }
	    return sb.toString();
	}
}
