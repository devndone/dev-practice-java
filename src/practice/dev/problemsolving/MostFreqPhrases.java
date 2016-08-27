package practice.dev.problemsolving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * We are using External Sorting Here, Priority is based on frequency of the phrases.
 * We will sort in a file till we get top 1Lakh Phrases.
 * We can adopt the Priority Queue too but even that would required visiting all the records.
 * Hence for our purpose both are same.
 */
public class MostFreqPhrases {

	public static void main(String[] args) throws Exception {

		long t1 = new Date().getTime();
		int i = 0;
		
		/*
		 * Phrases will be ordered automatically in TreeMap below.
		 * Order will be descending as Phrase compareTo method is implemented in a reverse order of comparison.
		 * Here Key and Value kept same so that we can change one ref i.e. value and it'll be reflected in key.
		 * Hashcode and Equals will return the usual values as they are determined on the phrase string value only,
		 * Which is kept final in phrase class
		 */
		Map<Phrase, Phrase> map = new TreeMap<Phrase, Phrase>();
		
		/*
		 * assuming that the source file is above 10GB and heap space provided is around 10GB
		 */
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"/Users/dev/development/testing/dbloader/phrases.txt")));
		String s = br.readLine();
		String[] phrasesPerLine = null;
		Phrase phrase = null;
		while (s != null && !s.trim().isEmpty()) {
			System.out.println("s = " + s);
			phrasesPerLine = s.split("\\|");
			System.out.println(phrasesPerLine.length);
			for(String tempPhrase : phrasesPerLine) {
				
				/*
				 * With below check we will never have null or empty string in our any temp files.
				 * Hence no need to check for the null while reading the temp files later on
				 */
				if(tempPhrase != null && !tempPhrase.trim().isEmpty()) {
					System.out.println("tempPhrase = " + tempPhrase);
					phrase = new Phrase(tempPhrase);
					if(map.containsKey(phrase)) {
						
						/*
						 * We have not taken the count as part of the hashcode or equals
						 * so it'll not affect the key integrity. 
						 * Also, phrase is final var in class Phrase 
						 * and hence it's a good class for the key in collection
						 */
						map.get(phrase).incrementCount();
					} else {
						phrase = new Phrase(tempPhrase);
						map.put(phrase, phrase);
					}
				}
			}
			
			/*
			 * breaking the source files to multiples of 2GB temp files 
			 * and sorting them in descending order i.e from most frequent phrases to least.
			 * the order is only maintained at the individual file level
			 * and will have to merge them all to get the final new file 
			 * that contains all the phrases sorted from most frequent to least. 
			 * 
			 * Map size is in int and hence can max assume the size of 2147483647.
			 * Hence, max data contained in the temp files = 2147483647*(sizeof phrase string and a "|" symbol with count, which can vary from phrase to phrase, assume it to 1kb max) = 2GB 
			 */
			//if (map.size() == ((2*1024*1024*1024) - 1)) {
			if (map.size() == 2) {
				FileWriter fw = new FileWriter(new File("/Users/dev/development/testing/tmp/temp-"
						+ i + ".txt"));
				
				for (Entry<Phrase, Phrase> x : map.entrySet()) {
					fw.write(x.getKey().getPhrase().trim() + "|" + x.getKey().getCount());
					fw.write("\n");
				}
				fw.close();
				i++;
				map = new TreeMap<Phrase, Phrase>();
			}
			s = br.readLine();
		}

		br.close();
		br = null;

		FileWriter fw = new FileWriter(new File("/Users/dev/development/testing/tmp/temp-" + i
				+ ".txt"));
		System.out.println("Map Size while writting the final temp file is -> " + map.size());
		for (Entry<Phrase, Phrase> x : map.entrySet()) {
			fw.write(x.getKey().getPhrase().trim() + "|" + x.getKey().getCount());
			fw.write("\n");
		}
		fw.close();

		/*
		 * Phrases will be ordered automatically in TreeMap below.
		 * Order will be descending as Phrase compareTo method is implemented in a reverse order of comparison.
		 * Here Key is Phrase object and Value is Integer. Value keep track of the file number, so that we select from taht file only.
		 * Hashcode and Equals will return the usual values as they are determined on the phrase string value only,
		 * Which is kept final in phrase class
		 */
		Map<Phrase, Integer> mapo = new TreeMap<Phrase, Integer>();
		String tmpstr = null;
		String[] phraseWithCount = null;
		
		BufferedReader[] brArr = new BufferedReader[i + 1];
		/*
		 * Here we are reading the first line of each file into the map
		 */
		for (int j = 0; j <= i; j++) {
			brArr[j] = new BufferedReader(new FileReader(new File(
					"/Users/dev/development/testing/tmp/temp-" + j + ".txt")));
			tmpstr = brArr[j].readLine();
			if(tmpstr != null && !tmpstr.isEmpty()) {
				phraseWithCount = tmpstr.split("\\|");
				phrase = new Phrase(phraseWithCount[0]);
				phrase.setCount(Integer.parseInt(phraseWithCount[1]));
				mapo.put(phrase, j);
			}
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				"/Users/dev/development/testing/res/output.txt")));

		String endofline = "\n";
		Integer countOfMaxPhraseToWriteInFile = 100000;//1Lakh
		
		/*
		 * Here we will write final output file that will contain all the 1Lakh Most Frequent Phrases
		 * along with there count separated by symbol "|".
		 * In case the result is not in the descending order, 
		 * Please change the compareTo implementation of the Phrase class to reverse to existing
		 */
		while (!mapo.isEmpty()) {
			if(countOfMaxPhraseToWriteInFile <= 0) {
				break;
			}
			phrase = mapo.keySet().iterator().next();
			i = mapo.get(phrase);
			mapo.remove(phrase);
			System.out.println(countOfMaxPhraseToWriteInFile + "." + phrase.getPhrase() + "|" + phrase.getCount());
			bw.write(phrase.getPhrase() + "|" + phrase.getCount());
			bw.write(endofline);
			tmpstr = brArr[i].readLine();
			if(tmpstr != null && !tmpstr.trim().isEmpty()) {
				phraseWithCount = tmpstr.trim().split("\\|");
				phrase = new Phrase(phraseWithCount[0]);
				phrase.setCount(Integer.parseInt(phraseWithCount[1]));
				mapo.put(phrase, i);
				countOfMaxPhraseToWriteInFile--;
			}
		}
		bw.close();

		for (int j = 0; j < brArr.length; j++) {
			brArr[j].close();
			new File("/Users/dev/development/testing/tmp/temp-" + j + ".txt").delete();
		}

		long t2 = new Date().getTime();
		System.out.println("Time taken to processing and to generate the output file = " + (t2 - t1) / 1000 + " sec");
	}

}

