package practice.dev.problemsolving.whatfix.packageproblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dev
 *
 * 
 *         You want to send your friend a package with different things. Each
 *         thing you put inside the package has such parameters as index number,
 *         weight and cost. The package has a weight limit. Your goal is to
 *         determine which things to put into the package so that the total
 *         weight is less than or equal to the package limit and the total cost
 *         is as large as possible.
 * 
 *         You would prefer to send a package which weights less in case there
 *         is more than one package with the same price.
 * 
 *         INPUT SAMPLE:
 * 
 *         Your program should accept as its first argument a path to a
 *         filename. The input file contains several lines. Each line is one
 *         test case.
 * 
 *         Each line contains the weight that the package can take (before the
 *         colon) and the list of things you need to choose. Each thing is
 *         enclosed in parentheses where the 1st number is a thing's index
 *         number, the 2nd is its weight and the 3rd is its cost. E.g. INPUTS :
 *         81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76)
 *         (5,30.18,$9) (6,46.34,$48) 8 : (1,15.3,$34) 75 : (1,85.31,$29)
 *         (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75)
 *         (7,60.02,$74) (8,93.18,$35) (9,89.95,$78) 56 : (1,90.72,$13)
 *         (2,33.80,$40) (3,43.15,$10) (4,37.97,$16) (5,46.81,$36) (6,48.77,$79)
 *         (7,81.80,$45) (8,19.36,$79) (9,6.76,$64)
 * 
 * 
 *         OUTPUT SAMPLE:
 * 
 *         For each set of things that you put into the package provide a list
 *         (items’ index numbers are separated by comma). E.g. OUTPUTS : 4 - 2,7
 *         8,9
 * 
 * 
 *         CONSTRAINTS:
 * 
 *         Max weight that a package can take is ≤ 100 There might be up to 15
 *         items you need to choose from Max weight and cost of an item is ≤ 100
 * 
 *
 */
public class MinWeighMaxCostPackage {

	// private static final Double maxWeightPerPackage = new Double(100);
	private static List<ItemAssembly> itemAssembly = new ArrayList<>();

	/**
	 * 1. First we will read from File 2. We will extract and map each line into
	 * ItemAssembly object 3. Each ItemAssembly object will have all Line Items
	 * provided in file per line 4.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String line = "";
		String[] lineS = null;
		List<Item> items;
		String filePath = "/Users/dev/development/testing/MinWeighMaxCostPackage-Input-File.txt";
		if (args != null && args.length >= 1) {
			filePath = args[0];
		}
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				filePath)))) {

			line = br.readLine();
			while (line != null) {
				lineS = line.split(":");
				items = new ArrayList<>();
				items.addAll(extractItems(lineS));
				// System.out.println(items.toString());
				itemAssembly.add(new MinWeighMaxCostPackage().new ItemAssembly(
						items, Double.parseDouble(lineS[0].trim())));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		arrangeItems();

		print();

	}

	private static void arrangeItems() {

		for (ItemAssembly ia : itemAssembly) {
			for (Item i : ia.items) {
				if (i.weight > ia.weightLimit) {
					continue;
				}
				ia.sampledItems.add(i);
			}
		}

	}

	/**
	 * Print items available in item assembly's sampled items
	 */
	private static void print() {
		boolean areValidItemsAvailable;
		StringBuilder sb;
		for (ItemAssembly ia : itemAssembly) {
			sb = new StringBuilder();
			areValidItemsAvailable = false;
			for (Item i : ia.sampledItems) {
				sb.append(", ").append(i.index);
				areValidItemsAvailable = true;
			}
			if (areValidItemsAvailable) {
				sb = sb.delete(0, 2);
			} else {
				System.out.println("-");
				continue;
			}
			System.out.println(sb.toString());
		}
		System.out.println();
	}

	/**
	 * Parse all items and set it to the Item Assembly's input items collection
	 * 
	 * @param lineS
	 * @return
	 */
	private static List<Item> extractItems(String[] lineS) {
		List<Item> itemperline = new ArrayList<>();
		Item p;
		String[] line = lineS[1].trim().split(" ");
		String[] iline;
		for (int i = 0; i < line.length; ++i) {
			iline = line[i].trim().split(",");
			iline[0] = iline[0].trim();
			iline[1] = iline[1].trim();
			iline[2] = iline[2].trim();
			Integer index = Integer.parseInt(iline[0].subSequence(1,
					iline[0].length()).toString());
			Double weight = Double.parseDouble(iline[1]);
			Double cost = Double.parseDouble(iline[2].subSequence(1,
					(iline[2].length() - 1)).toString());
			p = new MinWeighMaxCostPackage().new Item(index, weight, cost);
			itemperline.add(p);
		}
		// Collections.sort(itemperline);
		return itemperline;
	}

	/**
	 * Item class to capture item tuple
	 * 
	 * @author dev
	 *
	 */
	class Item {// implements Comparable<Item> {

		Integer index;
		Double weight;
		Double cost;

		public Item(Integer index, Double weight, Double cost) {
			this.index = index;
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Item [index=" + index + ", weight=" + weight + ", cost="
					+ cost + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof Item)) {
				return false;
			}
			if (this.weight != null && ((Item) obj).weight != null
					&& this.weight.equals(((Item) obj).weight)) {
				return true;
			}
			return false;
		}

		/*
		 * @Override public int compareTo(Item o) { int res =
		 * this.weight.compareTo(o.weight); if(res == 0) { res =
		 * o.cost.compareTo(this.cost); if(res == 0) { res =
		 * this.index.compareTo(o.index); } } return res; }
		 */

	}

	/**
	 * Item Assembly class to hold all input item tuples and ones to be packaged
	 * after processing in sample items collection
	 * 
	 * @author dev
	 *
	 */
	class ItemAssembly {

		Double weightLimit;// For weight constraint
		List<Item> items;// For keeping item inputs
		List<Item> sampledItems = new ArrayList<>();// For keeping item outputs

		public ItemAssembly(List<Item> items, Double weightLimit) {
			this.weightLimit = weightLimit;
			this.items = items;
		}

		@Override
		public String toString() {
			return "ItemAssembly [weightLimit=" + weightLimit + ", items="
					+ items + ", sampledItems=" + sampledItems + "]";
		}

	}

}
