import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;


/**
 * Created on 2020/3/15.
 *
 * @author ray
 */
public class MinimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> last = triangle.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                last.set(j, Math.min(last.get(j), last.get(j + 1)) + list.get(j));
            }
        }
        return last.get(0);
    }

    public static void main(String[] args) {
        int[][] arr = {{1},{-2,-5},{3,6,9},{-1,2,4,-3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] anArr : arr) {
            List<Integer> l = new ArrayList<>();
            Arrays.stream(anArr).forEach(l::add);
            triangle.add(l);
        }
        System.out.println(minimumTotal(triangle));
    }
}
