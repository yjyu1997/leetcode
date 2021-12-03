package ms.medium.lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.30,2021</pre>
 */
public class Solution1 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public Solution1(int capacity) {

        //accessOrder true
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    public int get(int key) {
        return super.getOrDefault(key, -1);
    }


    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
