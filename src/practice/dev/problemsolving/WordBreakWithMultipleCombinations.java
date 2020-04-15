package practice.dev.problemsolving;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Link -> http://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 * 
 * Run Example:
2
12
i like sam sung samsung mobile ice cream icecream man go mango
ilike
11
i like sam sung samsung mobile ice cream icecream man mango
imangolike
 * 
 * @author dev
 *
 */
public class WordBreakWithMultipleCombinations {

	public static void main(String[] args) throws java.lang.Exception {
		
		Scanner in = new Scanner(System.in);
		//int t = in.nextInt();
		//while (t-- > 0) {
		    int n = in.nextInt();
		    Set<String> dict = new HashSet<String>();
		    for (int i = 0; i < n; i++) {
		        dict.add(in.next());
		    }
		    if(wordBreak(in.next().toString(), dict)) {
		    	System.out.println("Broke the Word!");
		    } else {
		    	System.out.println("Unbreakable Word!");
		    }
		//}
		in.close();
	}

	public static boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.trim().length() == 0)
			return false;
		return wb(0, s, wordDict, new StringBuilder(), new Integer(0));
	}

	/**
	 * It just prints the one breakable combination
	 * @param start
	 * @param str
	 * @param wordDict
	 * @param sb
	 * @param spaceCount
	 * @return
	 */
	private static boolean wb(int start, String str, Set<String> wordDict, StringBuilder sb, Integer spaceCount) {
		for (int i = start; i < str.length(); i++) {
			String sub = str.substring(start, i + 1);
			//System.out.println(sub);
			if (wordDict.contains(sub)) {
				++spaceCount;
				sb.append(sub + " ");
				//System.out.println("sb = " + sb.toString());
				//System.out.println("sb = " + sb.length());
				//System.out.println("spaceCount = " + spaceCount);
				//System.out.println(str.length());
				if (sb.length() - spaceCount == str.length()) {
					System.out.println(sb.toString());
					return true;
				}
				boolean r = wb(i + 1, str, wordDict, sb, spaceCount);
				if (r)
					return r;
				--spaceCount;
				sb.setLength(sb.length() - 1 - sub.length());
			}
		}
		return false;
	}

}