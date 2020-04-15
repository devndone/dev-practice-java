package practice.dev.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultiComparator {

    class MultiComparators<T> implements Comparator<T> {
        private final List<Comparator<T>> comparators;

        public MultiComparators(List<Comparator<T>> comparators) {
            this.comparators = comparators;
        }

        public MultiComparators(Comparator<T>... comparators) {
            this(Arrays.asList(comparators));
        }

        public int compare(T o1, T o2) {
            for (Comparator<T> c : comparators) {
                int result = c.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }

        public <T> void sort(List<T> list, Comparator<T>... comparators) {
            Collections.sort(list, new MultiComparator().new MultiComparators<T>(comparators));
        }
    }

    /*class Element<Integer> implements Comparable<Element<Integer>> {

        Integer frequencyOfOccurrence;
        Integer data;

        Element(Integer data) {
            this.data = data;
            this.frequencyOfOccurrence = new Integer(0);
        }

        public void incrementFrequencyOfOccurrence() {
             this.frequencyOfOccurrence += this.frequencyOfOccurrence;
        }

        @Override
        public int compareTo(Element<Integer> o) {
            int result = -1;
            if(o == null) {
                return result;
            }
            result = this.frequencyOfOccurence.compareTo(o.frequencyOfOccurence);
            if(result == 0) {
                result = this.data.compareTo(o.data);
            }
        }
    }

    class FrequencyComparator<T> implements Comparator<T> {
        public int compare(T o1, T o2) {
            for (Comparator<T> c : comparators) {
                int result = c.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }
    }*/
}
