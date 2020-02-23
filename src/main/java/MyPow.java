import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/2/23.
 *
 * @author ray
 */
public class MyPow {

    private Map<Integer, Double> cacheMap = new HashMap<>();

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0 || n == 1 || x == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n % 2 == 0) {
            int newN = n / 2;
            if (cacheMap.containsKey(newN)) {
                return cacheMap.get(newN) * cacheMap.get(newN);
            } else {
                double v = myPow(x, newN);
                cacheMap.put(newN, v);
                return v * v;
            }
        } else {
            int newN = (n -1) / 2;
            if (cacheMap.containsKey(newN)) {
                return x * cacheMap.get(newN) * cacheMap.get(newN);
            } else {
                double v = myPow(x, newN);
                cacheMap.put(newN, v);
                return x * v * v;
            }
        }
    }
}
