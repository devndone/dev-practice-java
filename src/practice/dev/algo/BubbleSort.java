package practice.dev.algo;

public class BubbleSort {
	
	// logic to sort the elements
    public static void bubble_srt(int array[]) {
        int n = array.length;
        int k;
        boolean prevWasSwap = true;
        for (int m = n; m >= 2 && prevWasSwap; m--) {
            for (int i = 0; i < m - 1; i++) {
            	prevWasSwap = false;
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                    prevWasSwap = true;
                }
            }
            printNumbers(array);
        }
    }
  
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
    private static void printNumbers(int[] input) {
          
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
  
    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        printNumbers(input);
        bubble_srt(input);
  
    }
}