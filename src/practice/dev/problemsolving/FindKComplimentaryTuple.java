package practice.dev.problemsolving;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class FindKComplimentaryTuple {
	
	private final Scanner userInput;
	
	public FindKComplimentaryTuple() {
		this(System.in);
	}

	public FindKComplimentaryTuple(InputStream is) {
		userInput = new Scanner(is);
	}
	
	public static void main(String [] args) {
		
		FindKComplimentaryTuple tool = new FindKComplimentaryTuple();
		tool.execute();
	}
	
	public void execute() {
		
		Integer [] inIntArr = getSource();
		Integer k = getIntegerValueToDeriveComplimentaryTupleBasedOn();
		
		/*
		 * Assuming that we need only Unique Tuples 
		 * so we are removing duplicates from the List 
		 * by getting them into a Set which will have all Unique Integers only
		 */
		printUniqueComplimentaryTuples(inIntArr, k);
	}

	private Integer getIntegerValueToDeriveComplimentaryTupleBasedOn() {

		System.out.println("Enter Integer To Derive Complimentary Tuples Based On : ");
		return userInput.nextInt();
	}

	private Integer[] getSource() {

		System.out.println("Enter Integers Separated by Comma (,) : ");
		String sourceString = userInput.nextLine();
		String [] sourceStringArr = sourceString.split(",");
		Integer [] inIntArr = new Integer[sourceStringArr.length];
		try {
			for(int i = 0; i < sourceStringArr.length; i++) {
				inIntArr[i] = Integer.valueOf(sourceStringArr[i]);
			}
		} catch(NumberFormatException nfe) {
			System.out.println("Please enter the valid Integers!");
		}
		return inIntArr;
	}
	
	private void printUniqueComplimentaryTuples(Set<Integer> inIntSet, Integer integerValueToDeriveComplimentaryTupleBased) {
		Integer diff = 0;
		for(Integer in : inIntSet) {
			diff = integerValueToDeriveComplimentaryTupleBased - in;
			if(inIntSet.contains(diff)) {
				System.out.println(integerValueToDeriveComplimentaryTupleBased + " Complimentary Tuple (" + in + ", " + diff + ")");
				inIntSet.remove(diff);
			}
		}
	}
	
	private void printUniqueComplimentaryTuples(List<Integer> inIntList, Integer integerValueToDeriveComplimentaryTupleBased) {
		
		/*
		 * We are removing duplicates from the List 
		 * by getting them into a Set which will have all Unique Integers only
		 */
		printUniqueComplimentaryTuples(new ConcurrentSkipListSet<Integer>(inIntList), integerValueToDeriveComplimentaryTupleBased);
	}
	
	private void printUniqueComplimentaryTuples(Integer [] inIntArr, Integer integerValueToDeriveComplimentaryTupleBased) {
		printUniqueComplimentaryTuples(Arrays.asList(inIntArr), integerValueToDeriveComplimentaryTupleBased);
	}
}
