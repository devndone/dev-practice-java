package practice.dev.problemsolving;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInputExamples {
	public static void main(String[] args) {
		usingConsoleReader();
		usingBufferedReader();
		usingScanner();
	}

	private static void usingConsoleReader() {
		Console console = null;
		String inputString = null;
		try {
			// creates a console object
			console = System.console();
			// if console is not null
			if (console != null) {
				// read line from the user input
				inputString = console.readLine("Name: ");
				// prints
				System.out.println("Name entered : " + inputString);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void usingBufferedReader() {
		System.out.println("Name: ");
		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String inputString = bufferRead.readLine();

			System.out.println("Name entered : " + inputString);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void usingScanner() {
		System.out.println("Name: ");

		Scanner scanIn = new Scanner(System.in);
		String inputString = scanIn.nextLine();

		scanIn.close();
		System.out.println("Name entered : " + inputString);
	}

}
