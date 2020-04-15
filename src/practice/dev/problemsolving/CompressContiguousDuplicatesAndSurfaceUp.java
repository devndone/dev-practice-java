package practice.dev.problemsolving;

import java.util.Scanner;

public class CompressContiguousDuplicatesAndSurfaceUp {
    private static void process(int[] input) {
        int size = input.length;
        int temp = 0;
        for(int i = 0; i < size; i++) {
            if((size > i+1) && (input[i] == input[i + 1])) {
                input[temp] = 2*input[i];
                input[i+1] = 0;
                if(temp != i) {
                    input[i] = 0;
                }
                ++temp;
                ++i;
            } else if(input[i] != 0) {
                input[temp] = input[i];
                if(temp != i) {
                    input[i] = 0;
                }
                ++temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in input array: ");
        int ins = sc.nextInt();
        System.out.println("\nPlease enter " + ins + " elements of the input array: ");
        int[] input = new int[ins];
        for(int i = 0; i < ins; i++) {
            input[i] = sc.nextInt();
        }
        process(input);
        for(int i = 0; i < ins; ++i) {
            System.out.println(input[i]);
        }
    }
}
