package practice.dev.problemsolving;

import java.util.Set;
import java.util.TreeSet;

public class AnagramFinder {

	public static void main(String[] args) {
		String[] input = new String[] { "tea", "ate", "eat", "apple", "java",
				"vaja", "cut", "utc" };

		Set<String> output = new TreeSet<>();

		for (String s : input) {
			if (output.contains(s)) {
				System.out.println(s);
				output.remove(s);
			} else {
				Set<String> set = getAllPossibleAnagram("", s);
				set.remove(s);
				out: for (String st : set) {

					for (String inp : input) {
						if (set.contains(inp)) {
							System.out.println(s);
							output.addAll(set);
							break out;
						}
					}

				}
			}
		}

	}

	public static Set<String> getAllPossibleAnagram(String prefix, String s) {

		Set<String> set = new TreeSet<>();

		// System.out.println(prefix);
		if (s.length() == 0) {
			set.add(prefix);
			return set;
		}

		for (int i = 0; i < s.length(); i++) {

			set.addAll(getAllPossibleAnagram(prefix + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1)));
		}

		return set;
	}

}
