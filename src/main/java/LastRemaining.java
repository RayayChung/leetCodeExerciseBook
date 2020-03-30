/**
 * Created on 2020/3/30.
 *
 * @author ray
 */
public class LastRemaining {

    public static int lastRemaining(int n, int m) {
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            idx = (idx + m) % i;
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 17));
    }
}
