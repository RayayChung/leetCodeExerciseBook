/**
 * Created on 2020/3/15.
 *
 * @author ray
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] stairs = new int[n];
        stairs[n - 1] = 1;
        stairs[n - 2] = 2;
        for (int i = n - 3; i >= 0; i ++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[0];
    }
}
