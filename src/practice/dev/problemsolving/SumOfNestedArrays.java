package practice.dev.problemsolving;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SumOfNestedArrays {

    public static void main(String[] args) {
        ArrayList<Object> ina = new ArrayList<>();
        Integer[] inarr = {7, 9, 8};
        ina.add(inarr);
        ina.add(56);
        inarr = new Integer[]{73, 99, 48};
        ina.add(inarr);
        ina.add(65);
        ina.add(0);
        SumOfNestedArrays sona = new SumOfNestedArrays();
        int result = sona.sum(ina.toArray(), (ina.size()-1));
        System.out.println("Result is " + result);
    }

    public int sum(Object ina, int index) {
        Integer result = 0;
        if(index < 0) {
            return result;
        }
        System.out.println("Index is " + index);
        Object obj = ((Integer[]) ina)[index];
        if(obj.getClass().isArray()) {
            result = sum(obj, 0);
        } else {
            result = ((Integer[]) ina)[index];
        }
        result += sum(ina, index-1);
        return result;
    }
}
