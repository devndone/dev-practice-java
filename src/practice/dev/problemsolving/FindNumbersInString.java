package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindNumbersInString {
	
	public static void main(String args[] ) throws Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
	    //String line = br.readLine();
		System.out.println("Please enter a statement containing number to fine : ");
		String line = scanner.nextLine();
	    List<Integer> resArr = extractNumbers(line);
	    print(resArr);
	    scanner.close();
	}
    
    private static void print(List<Integer> resArr) {
    	for(Integer i : resArr) {
    		System.out.print(i);
    		System.out.print(" ");
    	}
    }

	private static List<Integer> extractNumbers(String line) {
		List<Integer> resArr = new ArrayList<Integer>();
		Character temp = 0;
		for(int i = 0; i < line.length(); ++i) {
			temp = line.charAt(i);
			if(Character.isDigit(temp)) {
				resArr.add(Integer.valueOf(temp.toString()));
			}
		}
		return resArr;
	}

}
