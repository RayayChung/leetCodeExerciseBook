import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created on 2020/3/22.
 *
 * @author ray
 */
public class LRUCache {

    private LinkedList<Integer> keyList;

    private Map<Integer, Integer> valMap;

    private int cap;

    public LRUCache(int capacity) {
        keyList = new LinkedList<>();
        valMap = new HashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if (valMap.containsKey(key)) {
            keyList.remove(Integer.valueOf(key));
            keyList.addFirst(key);
            return valMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (valMap.containsKey(key)) {
            keyList.remove(Integer.valueOf(key));
            keyList.addFirst(key);
        } else {
            if (keyList.size() < cap) {
                keyList.addFirst(key);
                valMap.put(key, value);
            } else {
                Integer k = keyList.removeLast();
                valMap.remove(k);
                keyList.addFirst(key);
                valMap.put(key, value);
            }
        }
    }
}
