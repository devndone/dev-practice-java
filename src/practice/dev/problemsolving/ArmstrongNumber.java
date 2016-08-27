package practice.dev.problemsolving;

import java.util.Scanner;

/**
 * 
 * @author dev
 *

Armstrong Numbers - Java Program
An Armstrong number is the one that equals the sum of its digits raised to the power of the number of digits in that number 
which is to be checked. To be more clear, let the number be n and the number of digits be x. 
We represent the number as nxnx-1nx-2...n3n2n1 where n1, n2, n3...nx are single digits 0-9. n is an Armstrong number if

n1x + n2x + n3x + nx-1x + nxx = n

153, 371, 9474 and 54748 are few Armstrong numbers.

153 = 13 + 53 + 33
371 = 33 +73 +13
9474 = 94 + 44 +74 + 44
54748 = 55 + 45 + 75 + 45 + 85

 *
 */
public class ArmstrongNumber {
	
	public static boolean isArmstrong(int input) {
       String inputAsString = input + "";
       int numberOfDigits = inputAsString.length();
       int copyOfInput = input;
       int sum = 0;
       while (copyOfInput != 0) {
           int lastDigit = copyOfInput % 10;
           sum = sum + (int) Math.pow(lastDigit, numberOfDigits);
           copyOfInput = copyOfInput / 10;
       }
       if (sum == input) {
           return true;
       } else {
           return false;
       }
   }

   public static void printAll(int start, int end) {
       System.out.println("List of Armstrong Numbers between " + start + " and " + end + " :");
       for (int i = start; i <= end; i++) {
           if (isArmstrong(i)) {
               System.out.println(i);
           }
       }
   }
   
   /*public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter a number: ");
       int inputNumber = scanner.nextInt();
       boolean result = isArmstrong(inputNumber);
       if (result) {
           System.out.println(inputNumber + " is an armstrong number");
       } else {
           System.out.println(inputNumber + " is not an armstrong number");
       }
       scanner.close();
   }*/

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter start number: ");
       int start = scanner.nextInt();
       System.out.print("Enter end number: ");
       int end = scanner.nextInt();
       printAll(start, end);
       scanner.close();
   }
}

