package practice.dev.ds;

/**
 * Interface BTIteratorIF
 * @author tnguyen
 */
public interface BTIteratorIF <K extends Comparable, V> {
    public boolean item(K key, V value);
}
