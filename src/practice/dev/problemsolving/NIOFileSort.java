package practice.dev.problemsolving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Sort a 400MB file using FileChannel
 */
public class NIOFileSort {
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 8;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		long t1 = new Date().getTime();
		int i = 0;
		FileChannel source = new FileInputStream(new File(
				"C:\\Project\\tpc-h\\dbloader\\LINEITEM.xml")).getChannel();
		ByteBuffer buf = ByteBuffer.allocateDirect(DEFAULT_BUFFER_SIZE);

		int j = 0;
		FileChannel destination = new FileOutputStream(new File(
				"C:\\Apps\\tmp\\temp-" + i + ".txt")).getChannel();
		while ((source.read(buf)) != -1) {
			buf.flip();
			destination.write(buf);
			if (j == 5000) {
				i++;
				destination.close();
				destination = new FileOutputStream(new File(
						"C:\\Apps\\tmp\\temp-" + i + ".txt")).getChannel();
				j = 0;
			} else {
				j++;
			}
			buf.clear();
		}

		source.close();

		Map<String, Integer> map = new TreeMap<String, Integer>();

		BufferedReader[] brArr = new BufferedReader[i + 1];
		for (j = 0; j <= i; j++) {
			brArr[j] = new BufferedReader(new FileReader(new File(
					"C:\\Apps\\tmp\\temp-" + j + ".txt")));
			map.put(brArr[j].readLine(), j);
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				"C:\\Apps\\output.txt")));

		String s = null;
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

		for (j = 0; j < brArr.length; j++) {
			brArr[j].close();
			new File("C:\\Apps\\tmp\\temp-" + j + ".txt").delete();
		}

		long t2 = new Date().getTime();
		System.out.println("Time taken = " + (t2 - t1) / 1000 + " sec");

	}

}
