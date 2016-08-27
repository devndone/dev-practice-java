package practice.dev.java8.lang.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamExamples {
	
	public static void main(String[] args) {
		
		List<String> collections = new ArrayList<String>();
		collections.add("Bangalore");
		collections.add("Mumbai");
		collections.add("New York");
		collections.add("California");
		collections.add("san diego");
		collections.add("san francisco");
		
		List<String> newList = collections.stream().filter(s -> s.startsWith("s")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(newList.toString());
		
		String maxCityByLength = collections.stream()
				.map(s->s.toUpperCase())
				.max((s1,s2)->s1.length()-s2.length())
				.get();
		System.out.println("CityNameWithMaxLenght is -> " + maxCityByLength);

		String minCityByLength = collections.stream()
		.map(s->s.toUpperCase())
		.min((s1,s2)->s1.length()-s2.length())
		.get();
		System.out.println("CityNameWithMinLenght is -> " + minCityByLength);
		
		long count = collections.stream().filter(s -> s.startsWith("s")).count();
		System.out.println("Count of cities that starts with 's' is -> " + count);
		
		String result = collections.stream().reduce((s, k) -> s + " - " + k ).get();
		System.out.println("Reduce Result is -> " + result);

		long sum = collections.stream().mapToInt(i -> i.length()).sum();
		System.out.println("Sum is -> " + sum);
		
	}
}
