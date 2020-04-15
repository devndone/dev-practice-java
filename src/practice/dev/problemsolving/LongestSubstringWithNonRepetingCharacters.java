package practice.dev.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNonRepetingCharacters {

    public static void main(String[] args) {
        String[] input = {"abcabcbb", "pwwkew", "bbbbb", "dvdf", "aab", "abba", "tmmzuxt", "tmmzuxtab"};
        for (String s : input) {
            System.out.println("=======>");
            System.out.println("Input string is " + s);
            LongestSubstringWithNonRepetingCharacters ls = new LongestSubstringWithNonRepetingCharacters();
            int length = ls.lengthOfLongestSubstring(s);
            System.out.println("Length of longest string is " + length);
            System.out.println("=======>");
        }
    }

    /**
     * Solution from Leetcode
     */
    /*public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }*/

    /**
     * My Solution to Leetcode
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        if(s == null || toString().isEmpty()) {
            return length;
        }
        char[] in = s.toCharArray();
        int start = 0, end = 0, prevStart = -1, prevEnd = -1;
        Map<Character, Integer> setOfCharacters = new HashMap<>();
        boolean isDuplicate = false;
        for(int i = 0; i < in.length; i++) {
            Integer idx = setOfCharacters.get(in[i]);
            if(idx != null) {
                isDuplicate = true;
                if ((end - start) > (prevEnd - prevStart)) {
                    prevStart = start;
                    prevEnd = end;
                }
                if(start <= idx) {
                    start = idx + 1;
                }
//              else {
//                  start = i;
//              }
                end = i;
                setOfCharacters.put(in[i], i);
//                if(idx != prevStart) {
//                    start = idx + 1;
//                } else {
//                    start = i;
//                    end = i;
//                    setOfCharacters = new HashMap<>();
//                }
            }
            setOfCharacters.put(in[i], i);
            end++;
        }
//        if(!isDuplicate) {
//            length = (end - start);
//            System.out.println("Start index is " + start);
//            System.out.println("End index is " + (end - 1));
//        } else {
            if((end - start) > (prevEnd - prevStart)) {
                prevStart = start;
                prevEnd = end;
            }
            length = (prevEnd - prevStart);
            System.out.println("Previous Start index is " + prevStart);
            System.out.println("Previous End index is " + (prevEnd - 1));
//        }
        return length;
    }
}
