package practice.dev.problemsolving;

// HackerEarth Sample Test and code to retrieve inputs
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.HashMap;

class A {
	public void m1(Y y) {
	}
}

class B extends A {
	public void m1(X y) {
	}// base class param

	public void m1(Y y) {
	}// same class param : hence shadow

	public void m1(Z z) {
	}// derived class param

	public static void main(String args[]) {
		Z o = null;
		new A().m1(o);
	}
}

class X {
}

class Y extends X {
}

class Z extends Y {
}

public class TestClass {
	public static void main(String args[]) throws Exception {

		HashMap<String, Integer> hm = new HashMap<>();
		Integer i = 1;
		hm.put("one", i);
		System.out.println(hm.toString());
		i = hm.get("one");
		i++;
		System.out.println(i);
		System.out.println(hm.toString());

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int
		 * numOfTestCases = Integer.parseInt(line);
		 * //System.out.println("Reading Input : hello world : numOfTestCases = "
		 * + numOfTestCases); line = br.readLine(); String[] ins =
		 * line.split(" "); int[] inArr = new int[ins.length]; boolean con3 =
		 * false; boolean con5 = false; for(int i = 0; i < ins.length; i++) {
		 * inArr[i] = Integer.parseInt(ins[i]);
		 * //System.out.println("Reading Input : hello world : ins are " // +
		 * inArr[i]); if(inArr[i] > 10) { continue; } else { if(inArr[i]%3 == 0)
		 * { con3 = true; } if(inArr[i]%5 == 0) { con5 = true; } } if(con3 &&
		 * con5) { System.out.println("FizzBuzz"); } else if(con5) {
		 * System.out.println("Buzz"); } else if(con3) {
		 * System.out.println("Fizz"); } con3 = false; con5 = false; }
		 */
		// Thread th = Thread.currentThread();
		// System.out.println(th);

		/*
		 * String xml =
		 * "<?xml version=\"1.0\"?><company><staff> <firstname>Shweta</firstname><lastname>Kakkar</lastname><nickname>shweta</nickname><salary>100000</salary></staff></company>"
		 * ; if(args != null && args.length >= 1) { xml = args[0]; }
		 * SAXParserFactory factory = SAXParserFactory.newInstance(); SAXParser
		 * saxParser = factory.newSAXParser();
		 * 
		 * InputSource is = new InputSource(new StringReader(xml));
		 * saxParser.parse(is, new HandlerBase(){});
		 * 
		 * char[] cbuf = new char[xml.length()];
		 * System.out.println(is.getCharacterStream().read(cbuf) != -1 ?
		 * Arrays.toString(cbuf) : "");
		 */

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String speedNumbers = br.readLine();
		 * String speeds = br.readLine(); String consumptions = br.readLine();
		 * String fuel = br.readLine(); Integer sns = null; String[] speedsArr =
		 * null; Integer[] speedsIntArr = null; String[] consumptionsArr = null;
		 * Integer[] consumptionsIntArr = null; Integer fuelInt = null;
		 * if(speedNumbers != null && speedNumbers.isEmpty()) { sns =
		 * Integer.parseInt(speedNumbers); } else { throw new Exception(); }
		 * if(speeds != null && speeds.isEmpty()) { speedsArr =
		 * speeds.split(" "); } else { throw new Exception(); } if(consumptions
		 * != null && consumptions.isEmpty()) { consumptionsArr =
		 * consumptions.split(" "); } else { throw new Exception(); }
		 * speedsIntArr = new Integer[speedsArr.length]; for(int i = 0 ; i <
		 * speedsArr.length; ++i) { speedsIntArr[i] =
		 * Integer.valueOf(speedsArr[i]); } consumptionsArr =
		 * consumptions.split(" "); consumptionsIntArr = new
		 * Integer[consumptionsArr.length]; for(int i = 0 ; i <
		 * consumptionsArr.length; ++i) { consumptionsIntArr[i] =
		 * Integer.valueOf(consumptionsArr[i]); } fuelInt =
		 * Integer.valueOf(fuel);
		 * 
		 * Map<Integer, Integer> = new HashMap<>();
		 */

	}
}
