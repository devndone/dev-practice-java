package practice.dev.problemsolving;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {
	public static String removeDuplicateChars(String input) {
        // COMPLETE ME
        // warning: writing to System.out will break scoring
		if(input == null || input.isEmpty()) {
            return input;
        }
        char[] inputChars = input.toCharArray();
        Set<Character> s = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputChars.length; ++i) {
            s.add(new Character(inputChars[i]));
        }
        for(Character c : s) {
            sb.append(c);
        }

        return sb.toString();
    }
}
