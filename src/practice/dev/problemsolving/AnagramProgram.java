package practice.dev.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AnagramProgram {
	
	/*
	 * 
	 *  Anagram Program In Java Using sort() and equals() Methods ->>>

		First we clean the input by removing all white spaces from the given two strings 
		and change the case of all characters of both the strings to lower case 
		so that case of both input strings will be ignored. After cleaning the input strings, 
		we convert them to character array and sort them using sort() method of java.util.Arrays class. 
		After sorting, we compare both the arrays using equals() method of same Arrays class.
		This method will return true if both arrays have same set of characters. 
		Below is the complete anagram program using sort() and equals() methods.
	 */
	static void isAnagramUsingSorting(String s1, String s2)
    {
        //Removing all white spaces from s1 and s2
 
        String copyOfs1 = s1.replaceAll("\\s", "");
 
        String copyOfs2 = s2.replaceAll("\\s", "");
 
        //Initially setting status as true
 
        boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status = false;
        }
        else
        {
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
 
            char[] s1Array = copyOfs1.toLowerCase().toCharArray();
 
            char[] s2Array = copyOfs2.toLowerCase().toCharArray();
 
            //Sorting both s1Array and s2Array
 
            Arrays.sort(s1Array);
 
            Arrays.sort(s2Array);
 
            //Checking whether s1Array and s2Array are equal
 
            status = Arrays.equals(s1Array, s2Array);
        }
 
        //Output
 
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
	
	//Using HashMap
	static void isAnagram(String s1, String s2) {
		// Removing white spaces from s1 and s2 and converting case to lower
		// case

		String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();

		String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

		// Initially setting status as true

		boolean status = true;

		if (copyOfs1.length() != copyOfs2.length()) {
			// Setting status as false if copyOfs1 and copyOfs2 doesn't have
			// same length

			status = false;
		} else {
			// Constructing a map containing character as a key and character
			// occurrences as a value

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();

			for (int i = 0; i < copyOfs1.length(); i++) {
				// Getting char from copyOfs1

				char charAsKey = copyOfs1.charAt(i);

				// Initializing char count to 0

				int charCountAsValue = 0;

				// Checking whether map contains this char

				if (map.containsKey(charAsKey)) {
					// If contains, retrieving it's count

					charCountAsValue = map.get(charAsKey);
				}

				// Putting char and it's count to map with pre-incrementing char
				// count

				map.put(charAsKey, ++charCountAsValue);

				// Getting char from copyOfs2

				charAsKey = copyOfs2.charAt(i);

				// Initializing char count to 0

				charCountAsValue = 0;

				// Checking whether map contains this char

				if (map.containsKey(charAsKey)) {
					// If contains, retrieving it's count

					charCountAsValue = map.get(charAsKey);
				}

				// Putting char and it's count to map with pre-decrementing char
				// count

				map.put(charAsKey, --charCountAsValue);
			}

			// Checking each character and it's count

			for (int value : map.values()) {
				if (value != 0) {
					// If character count is not equal to 0, then setting status
					// as false

					status = false;
				}
			}

		}

		// Output

		if (status) {
			System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are anagrams");
		} else {
			System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are not anagrams");
		}
	}

	public static HashSet<String> getAnagram(String [] given){
		
		HashSet<String> result = new HashSet<String>();
		if(given == null){
			return result;
		}
		HashMap<String, String> hm = new HashMap<String, String>();
		for (String str : given){
			char[] tempstr = str.toCharArray();
			Arrays.sort(tempstr);
			String sortedkey = new String(tempstr);
			System.out.println("sorted :" + sortedkey);
			if (hm.containsKey(sortedkey)== false){
				hm.put(sortedkey, str);
			}
			else {
				String tempvalue = hm.get(sortedkey);
				tempvalue = tempvalue + "," + str;
				hm.put(sortedkey, tempvalue);
  			} 
		}
		
		for (String str : hm.values()){
			String[] temp = str.split(",");
			if (temp.length > 1){
				for (int i = 0; i < temp.length; i ++){
				result.add(temp[i]);
				}
			}
		}
		System.out.println("result : ");
		for (String ena : result)
		System.out.print(ena +",");
		return result;
	}

	public static void main(String[] args) {
		isAnagram("Mother In Law", "Hitler Woman");

		isAnagram("keEp", "peeK");

		isAnagram("SiLeNt CAT", "LisTen AcT");

		isAnagram("Debit Card", "Bad Credit");

		isAnagram("School MASTER", "The ClassROOM");

		isAnagram("DORMITORY", "Dirty Room");

		isAnagram("ASTRONOMERS", "NO MORE STARS");

		isAnagram("Toss", "Shot");

		isAnagram("joy", "enjoy");
		
		/*
		 Output :
			Mother In Law and Hitler Woman are anagrams
			keEp and peeK are anagrams
			SiLeNt CAT and LisTen AcT are anagrams
			Debit Card and Bad Credit are anagrams
			School MASTER and The ClassROOM are anagrams
			DORMITORY and Dirty Room are anagrams
			ASTRONOMERS and NO MORE STARS are anagrams
			Toss and Shot are not anagrams
			joy and enjoy are not anagrams
		 */
	}
}
