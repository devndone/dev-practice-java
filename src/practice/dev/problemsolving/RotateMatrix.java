package practice.dev.problemsolving;

import java.util.ArrayList;

public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int S = a.size() - 1;

        for(int i = 0 ; i < a.size() / 2 ; i++) {

            for(int j = i; j < S - i; ++j){

                int temp1 = a.get(S-j).get(i);
                int temp2 = a.get(S-i).get(S-j);
                int temp3 = a.get(j).get(S-i);
                int temp4 = a.get(i).get(j);

                // swap
                a.get(i).set(j,temp1);
                a.get(S-j).set(i,temp2);
                a.get(S-i).set(S-j,temp3);
                a.get(j).set(S-i,temp4);
            }
        }
    }
}
