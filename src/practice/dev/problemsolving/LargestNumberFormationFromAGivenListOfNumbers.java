package practice.dev.problemsolving;

import java.util.List;

public class LargestNumberFormationFromAGivenListOfNumbers {
	
	public String largestNumber(final List<Integer> a) {
	    java.util.Collections.sort(a, new CombiComparator());
	    StringBuilder sb = new StringBuilder();
	    for(Integer temp : a) {
	    	if(temp != null) {
	    		sb.append(temp.toString());
	    	}
	    }
	    return filterPrefix(sb.toString(), '0');
	}
	
	private String filterPrefix(String str, char prefix) {
		char[] temp = str.toCharArray();
		int startIndex = 1;
		for(int i = 0; i < temp.length; ++i) {
			if(temp[i] == '0') {
				startIndex++;
			} else {
				break;
			}
		}
		if(startIndex > 1) {
			--startIndex;
		}
		return str.subSequence((startIndex - 1), temp.length).toString();
	}
	
	class CombiComparator implements java.util.Comparator<Integer> {
	    
	    public int compare(Integer i, Integer j) {
	    	int res = 0;
	    	if(i == null && j == null) {
	    		res = 0;
	    	} else if(i == null) {
	    		res = 1;
	    	} else if(j == null) { 
	    		res = -1;
	    	} else {
		        String fn = i.toString() + j.toString();
		        String sn = j.toString() + i.toString();
		        //return Integer.compare(Integer.valueOf(sn), Integer.valueOf(fn));
		        res = sn.compareTo(fn);
	    	}
	    	return res;
	    }
	}
}
