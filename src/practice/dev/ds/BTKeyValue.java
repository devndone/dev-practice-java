package practice.dev.ds;

/**
 * Class BTKeyValue
 * @author tnguyen
 */
public class BTKeyValue<K extends Comparable, V>
{
    protected K mKey;
    protected V mValue;

    public BTKeyValue(K key, V value) {
        mKey = key;
        mValue = value;
    }
}
