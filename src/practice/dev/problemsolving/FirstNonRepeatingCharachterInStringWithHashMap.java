package practice.dev.problemsolving;

import java.util.HashMap;

public class FirstNonRepeatingCharachterInStringWithHashMap {

    static final int NO_OF_CHARS = 256;
    static HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(NO_OF_CHARS);

    /* calculate count of characters
    in the passed string */
    static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++) {
            // If character already occurred,
            if (hm.containsKey(str.charAt(i))) {
                // updating count
                hm.get(str.charAt(i)).incCount();
            }

            // If it's first occurrence, then store the index and count = 1
            else {
                hm.put(str.charAt(i), new CountIndex(i));
            }

        }
    }

    /* The method returns index of first non-repeating
    character in a string. If all characters are repeating
    then returns -1 */
    static int firstNonRepeating(String str) {
        getCharCountArray(str);
        int result = Integer.MAX_VALUE, i;
        int countStrLenghtTraversed = 0;
        for (i = 0; i < NO_OF_CHARS; i++) {
            countStrLenghtTraversed++;
            // If this character occurs only once and appears
            // before the current result, then update the result
            CountIndex ci = hm.get((char)i);
            if (ci != null && ci.count == 1 && result > ci.index) {
                result = ci.index;
                //System.out.println(countStrLenghtTraversed);
                return result;
            }

        }
        //System.out.println(countStrLenghtTraversed);
        return result;
    }

    // Driver method
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = firstNonRepeating(str);

        System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating " +
                " or string is empty" : "First non-repeating character is " + str.charAt(index));
    }
}

class CountIndex
{
    int count,index;

    // constructor for first occurrence
    public CountIndex(int index) {
        this.count = 1;
        this.index = index;
    }

    // method for updating count
    public void incCount() {
        this.count++;
    }
}
