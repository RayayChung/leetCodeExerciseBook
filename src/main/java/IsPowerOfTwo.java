/**
 * Created on 2020/3/14.
 *
 * @author ray
 */
public class IsPowerOfTwo {

    /**
     * 2的n次方总能表示成2进制中只有一个1的形式
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(64));
    }
}
