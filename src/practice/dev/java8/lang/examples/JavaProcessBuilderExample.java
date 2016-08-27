/*
 * Java ProcessBuilder example to run batch file with arguments :
 * Most of the test automation framework needs to run batch file or external programs. 
 * As they have to perform system related tasks such as date-time changes, copy files/folders etc. 
 * Here is an example code snippet to demonstrate batch file execution using Java ProcessBuilder. 
 * The below Java code can directly be integrated into any test framework built in Java. 
 * Or you can create a Java project and add this code. 
 * Then you can build and export the project as Jar file. 
 * Project Jar file can also be easily run from the command line.
 */
package practice.dev.java8.lang.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * Java ProcessBuilder example
 */
public class JavaProcessBuilderExample {

	public static void main(String[] args) throws IOException {
		
		// This code demonstrate using a Java ProcessBuilder class to run a batch file 
		// Java ProcessBuilder and BufferedReader classes are used to implement this.
		
		final StringBuffer sb = new StringBuffer();
		int processComplete = -1;
		
		ProcessBuilder pb = new ProcessBuilder(args);
		pb.redirectErrorStream(true);
		
		try {
			final Process process = pb.start();
			final InputStream is = process.getInputStream();
			
			// the background thread watches the output from the process
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(is));
						String line;
						while((line = reader.readLine()) != null) {
							sb.append(line).append('\n');
						}
						
					} catch (IOException e) {
						System.out.println("Java ProcessBuilder : IO Exception Occured");
						e.printStackTrace();
					} finally {
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			// wait to get exit value
			// the outer thread waits for the process to finish
			processComplete = process.waitFor();
			
			System.out.println("Java ProcessBuilder result: " + processComplete);
			//System.out.println("Java ProcessBuilder sb: " + sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
