package practice.dev.algo;

import java.util.ArrayList;

public class IncrementArray {

        public static void main(String[] args) {
            ArrayList<Integer> input = new ArrayList<>();
            input.add(9);
            input.add(9);
            input.add(9);
            input.add(9);
            input.add(9);
            input.add(9);
            input.add(9);
            input.add(9);
            input.add(9);
            System.out.println("Input size is -> " + input.size());
            System.out.println("Input is -> " + input);
            ArrayList<Integer> o = new IncrementArray().plusOne(input);
            System.out.println("Output size is -> " + o.size());
            System.out.println("Output is -> " + o);
        }

        public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
            ArrayList<Integer> output = null;
            int s = 0;
            if(A == null || A.isEmpty()) {
                return new ArrayList<Integer>();
            } else {
                //System.out.println("s value is = " + s);
                s = A.size();
                //System.out.println("s value is = " + s);
                if(A.get(A.size()-1) == 9 && A.get(0) == 9) {
                    ++s;
                    System.out.println("increased 's' value is = " + s);
                }
                output = new ArrayList<>(s);
                int fill = s-1;
                while(fill >= 0) {
                    output.add(0);
                    --fill;
                }
                //System.out.println("'output' size value is = " + output.size());
            }
            int borrow = 0;
            for(int i = A.size() - 1; i >= 0; --i ) {

                int ele = A.get(i);

                //System.out.println("'ele' value is = " + ele);

                if(ele == 9) {
                    ele = 0;
                    if(borrow == 0) {
                        borrow = 1;
                    }
                } else if(i == A.size()-1) {
                    ++ele;
                } else {
                    ele += borrow;
                    if(borrow == 1) {
                        borrow = 0;
                    }
                }
                --s;
                //System.out.println("post processing 'ele' value is = " + ele);
                //System.out.println("inserting at index = " + s);
                output.set(s, ele);
                //System.out.println("Output is -> " + output);
            }
            if(borrow == 1 && s == 1) {
                --s;
                //System.out.println("inserting at index = " + s);
                //System.out.println("Output is -> " + output);
                output.set(s, borrow);
                //System.out.println("Output is -> " + output);
            }
            //System.out.println("Final Output is -> " + output);
            return output;
        }
    }
