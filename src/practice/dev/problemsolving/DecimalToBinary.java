package practice.dev.problemsolving;

import java.util.Scanner;

/**
 * 
 * @author dev
 *

Java program to convert decimal number to binary number
The program for conversion of decimal to binary depends on the problem specification. 
It may be given that the decimal number is always positive or it can be both positive and negative. 
Another thing to consider is the number of bits we are allotted for the binary representation. 
Finite number of bits in binary cannot represent any arbitrary large decimal number. 
The program given here assumes that the decimal number that we are given as input is positive. 
We first explain the procedure for converting a positive decimal number to a binary number and then give the program.

Procedure
First, let us see how humans perform the computation. We start with the given decimal number, 
and repeatedly divide it by 2 (whole number division where the result will be only the quotient, a whole number) 
and note down the remainder at every step till we obtain the quotient as 0. 
The remainders obtained in each step when concatenated together (the last remainder taken as the first digit of the binary number) 
give the binary form of the decimal number.

 *
 */
public class DecimalToBinary {

   public String toBinary(int n) {
       if (n == 0) {
           return "0";
       }
       String binary = "";
       while (n > 0) {
           int rem = n % 2;
           binary = rem + binary;
           n = n / 2;
       }
       return binary;
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter a number: ");
       int decimal = scanner.nextInt();
       DecimalToBinary decimalToBinary = new DecimalToBinary();
       String binary = decimalToBinary.toBinary(decimal);
       System.out.println("The binary representation is " + binary);
       scanner.close();
   }
}
