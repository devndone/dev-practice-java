package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.Collections;

public class PrintWavePattern {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    Collections.sort(a);
		ArrayList<Integer> res = new ArrayList<Integer>(a.size());
		for(int i = 0; i < (a.size() - 1); i = (i + 2)) {
	        res.add(a.get(i + 1));
	        res.add(a.get(i));
	    }
	    if((a.size() % 2) == 1) {
            res.add(a.get(a.size() - 1));
        }
	    return res;
	}
}
