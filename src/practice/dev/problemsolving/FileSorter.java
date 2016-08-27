package practice.dev.problemsolving;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sort a 400 MB file
 * 
 * @author raju rama krishna
 * @see http://javatroops.blogspot.co.nz
 *
 */
public class FileSorter {

	public static void main(String[] args) throws Exception {

		long t1 = new Date().getTime();
		Set<String> set = new TreeSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Project\\tpc-h\\dbloader\\LINEITEM.xml")));
		String s = br.readLine();
		while (s != null) {
			set.add(s);
			s = br.readLine();
		}
		br.close();

		FileWriter fw = new FileWriter(new File("C:\\Apps\\output.txt"));
		for (String x : set) {
			fw.write(x);
			fw.write('\n');
		}
		fw.close();
		long t2 = new Date().getTime();
		System.out.println("Time taken = " + (t2 - t1) / 1000 + " sec");

	}
}
