package practice.dev.problemsolving;

import java.io.InputStream;
import java.util.Scanner;

public class IsAStringPalindrome {

	private final Scanner userInput;

	public IsAStringPalindrome() {
		this(System.in);
	}

	public IsAStringPalindrome(InputStream is) {
		userInput = new Scanner(is);
	}

	public static void main(String[] args) {

		IsAStringPalindrome tool = new IsAStringPalindrome();
		tool.execute();
	}
	
	private void execute() {
		
		printIsPalindrome(getSource());
	}

	private String getSource() {

		System.out.println("Enter A String Value To Check for a Palindrome : ");
		return userInput.nextLine();
	}

	private void printIsPalindrome(String inputString) {

		int length = inputString.length();
		int currIndex, beginIndex, endIndex, middleIndex;

		beginIndex = 0;
		endIndex = length - 1;
		middleIndex = (beginIndex + endIndex) / 2;

		for (currIndex = beginIndex; currIndex <= middleIndex; currIndex++) {
			if (inputString.charAt(beginIndex) == inputString.charAt(endIndex)) {
				beginIndex++;
				endIndex--;
			} else {
				break;
			}
		}
		if (currIndex == middleIndex + 1) {
			System.out.println(inputString + " is a Palindrome");
		} else {
			System.out.println(inputString + " is not a Palindrome");
		}
	}
}
