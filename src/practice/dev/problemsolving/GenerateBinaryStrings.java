package practice.dev.problemsolving;

import java.util.List;
import java.util.Scanner;

public class GenerateBinaryStrings {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        System.out.println("Input the number of Bits: ");
        int noOfBits = sin.nextInt();
        GenerateBinaryStrings gbs = new GenerateBinaryStrings();
        String result = gbs.getCombi("", "");

        sin.close();
    }

    public String getCombi(String bit1, String bit2) {
        return "";
    }
}
