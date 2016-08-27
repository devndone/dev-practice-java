package practice.dev.problemsolving;

import java.util.Scanner;

/**
 * 
 * @author dev
 *

Prime Numbers : A prime number has only two factors, namely one and itself. 

To determine whether a given number is prime, 
we need to check if it has factors others than one and itself. If we are able to find at least one other factor, 
then we can conclude that the number is not prime. To check if a number is a factor of the given number ( hereafter referred to as n ), 
we obtain the remainder on dividing n by the number. If the remainder is zero, then the number is a factor.

The next question is what is the range of numbers we need to consider while checking if they are factors? Since, 
a number is definitely not divisible by any number greater than itself, we can place n as the upper limit. 
We can further reduce this upper limit by noting that a number has no other factors ( except itself ) greater than sqrt(n). 
To sum up, within a loop, we find the remainder on dividing the number n with the loop counter which ranges from 2 to sqrt(n). 
If at any time, we get the remainder as zero, we conclude that the number is not prime. Special checks should be used for the number one, 
which is neither prime nor composite. If necessary, additional checks can be done for negative numbers.

 *
 */
public class PrimeNumbers {

	/*
	 * Here is a complete Java programs which accepts a number from the user, 
	 * checks if the number is prime and displays the result on the screen. 
	 */
   /*public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       System.out.print("Enter a number : ");
       int n = s.nextInt();
       if (isPrime(n)) {
           System.out.println(n + " is a prime number");
       } else {
           System.out.println(n + " is not a prime number");
       }
       s.close();
   }*/
   
	/*
	 * Here is a program which takes two numbers as input from the user and prints all the prime numbers 
	 * that lie between these two numbers. 
	 */
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       System.out.print("Enter the first number number : ");
       int start = s.nextInt();
       System.out.print("Enter the second number number : ");
       int end = s.nextInt();
       System.out.println("List of prime numbers between " + start + " and " + end);
       for (int i = start; i <= end; i++) {
           if (isPrime(i)) {
               System.out.println(i);
           }
       }
       s.close();
   }

   public static boolean isPrime(int n) {
       if (n <= 1) {
           return false;
       }
       for (int i = 2; i < Math.sqrt(n); i++) {
           if (n % i == 0) {
               return false;
           }
       }
       return true;
   }
}