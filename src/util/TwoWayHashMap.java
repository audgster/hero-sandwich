package util;

import java.util.HashMap;
import java.util.Set;

public class TwoWayHashMap<K, V>
{
    private HashMap<V, K> valueFirst;
    private HashMap<K, V> keyFirst;

    public TwoWayHashMap()
    {
        valueFirst = new HashMap<>();
        keyFirst = new HashMap<>();
    }

    public int size()
    {
        return keyFirst.size();
    }

    public V getByKey(K key)
    {
        return keyFirst.get(key);
    }

    public K getByValue(V value)
    {
        return valueFirst.get(value);
    }

    public void put(K key, V value)
    {
        keyFirst.put(key, value);
        valueFirst.put(value, key);
    }

    public void removeByValue(V value)
    {
        K key = valueFirst.get(value);
        valueFirst.remove(value);

        keyFirst.remove(key);
    }

    public void removeByKey(K key)
    {
        V value = keyFirst.get(key);
        keyFirst.remove(key);

        valueFirst.remove(value);
    }

    public boolean containsValue(V value)
    {
        return valueFirst.containsKey(value);
    }

    public boolean containsKey(K key)
    {
        return keyFirst.containsKey(key);
    }

    public Set<K> getKeySet()
    {
        return keyFirst.keySet();
    }

    public Set<V> getValueSet()
    {
        return valueFirst.keySet();
    }
}
