/**
 * Created on 2020/3/14.
 *
 * @author ray
 */
public class CountingBits {

    /**
     * count[i] = count[i & (i - 1)] + 1
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            counts[i] = counts[i & (i - 1)] + 1;
        }
        return counts;
    }

}
