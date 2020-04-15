package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringCombinationsIterative {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String input = "?????";
        list.add(0);
        print(input,0);
        System.out.println(list.get(list.size()-1));
    }

    public static void  print(String s, int index) {
        if(index == s.length()) {
            System.out.println(s);
            return;
        }
        for (int i = index; i < s.length(); i++){
            list.add(list.get(list.size()-1)+1);
            if(s.charAt(i) == '?') {
                print(s.substring(0,i)+"0"+s.substring(i+1,s.length()), i+1);
                print(s.substring(0,i)+"1"+s.substring(i+1,s.length()), i+1);
                break;
            }
        }
    }
}
