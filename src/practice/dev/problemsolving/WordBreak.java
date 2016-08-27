package practice.dev.problemsolving;

import java.util.HashSet;

public class WordBreak {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("sumit");
		hs.add("jain");
		hs.add("the");
		hs.add("problem");
		String s = "thisissumitjain";
		
		WordBreak ws = new WordBreak();
		
		// create another HashSet so store the sub problems result
		HashSet<String> memoization = new HashSet<String>();
		ws.findUsingDP(s, hs, memoization, "");
	}
	public boolean findUsingDP(String s, HashSet<String> dict,
			HashSet<String> memory, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {
		
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word already being solved
				if (dict.contains(word)) {
					if (findUsingDP(s.substring(index + 1), dict, memory,
							answer + word + " ")) {
						return true;
					} else {
						System.out.println("backtrack");
						index++;
					}
				} else {					
					index++;
				}
			}
			memory.add(s);// memoization for future;
			return false;
		}
	}
}
