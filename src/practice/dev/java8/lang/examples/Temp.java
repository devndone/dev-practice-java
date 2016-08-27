package practice.dev.java8.lang.examples;

import java.util.HashSet;
import java.util.Set;

public class Temp {

	public static void main(String[] args) {
		int i = 0; short j = 0;
		for(i = 0, j = 0; ;++j, ++i) {
			System.out.println(i + "-" + j);
			//Set<> s = new HashSet<? super Integer>();
		}
	}
	
}
