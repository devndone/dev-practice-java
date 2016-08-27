package practice.dev.problemsolving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Sort a 400 MB file on a 40MB RAM
 * 
 * @author raju rama krishna
 * @see http://javatroops.blogspot.co.nz
 *
 */
public class SorterUtil {

	public static void main(String[] args) throws Exception {

		long t1 = new Date().getTime();
		int i = 0;
		Set<String> set = new TreeSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Project\\tpc-h\\dbloader\\LINEITEM.xml")));
		String s = br.readLine();
		while (s != null) {
			set.add(s);

			if (set.size() == 60000) {
				FileWriter fw = new FileWriter(new File("C:\\Apps\\tmp\\temp-"
						+ i + ".txt"));
				for (String x : set) {
					fw.write(x);
					fw.write("\n");
				}
				fw.close();
				i++;
				set = new TreeSet<String>();
			}
			s = br.readLine();
		}

		br.close();
		br = null;

		FileWriter fw = new FileWriter(new File("C:\\Apps\\tmp\\temp-" + i
				+ ".txt"));
		for (String x : set) {
			fw.write(x);
			fw.write('\n');
		}
		fw.close();

		Map<String, Integer> map = new TreeMap<String, Integer>();

		BufferedReader[] brArr = new BufferedReader[i + 1];
		for (int j = 0; j <= i; j++) {
			brArr[j] = new BufferedReader(new FileReader(new File(
					"C:\\Apps\\tmp\\temp-" + j + ".txt")));
			map.put(brArr[j].readLine(), j);
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				"C:\\Apps\\output.txt")));

		String endofline = "\n";
		while (!map.isEmpty()) {
			s = map.keySet().iterator().next();
			i = map.get(s);
			map.remove(s);
			bw.write(s);
			bw.write(endofline);
			s = brArr[i].readLine();
			if (s != null) {
				map.put(s, i);
			}
		}
		bw.close();

		for (int j = 0; j < brArr.length; j++) {
			brArr[j].close();
			new File("C:\\Apps\\tmp\\temp-" + j + ".txt").delete();
		}

		long t2 = new Date().getTime();
		System.out.println("Time taken = " + (t2 - t1) / 1000 + " sec");
	}

}
