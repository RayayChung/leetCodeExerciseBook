import java.util.Arrays;

/**
 * Created on 2020/2/9.
 *
 * @author ray
 */
//统计所有小于非负整数 n 的质数的数量。
//
// 示例:
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
// Related Topics 哈希表 数学


//leetcode submit region begin(Prohibit modification and deletion)
public class CountPrime {

    /**
     * 利用一个大小为n的布尔数组, 将不为素数的先置为false,剩下的就是素数了
     * @param n
     * @return
     */
    public int countPrimesSolve1(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;

    }

    /**
     * 利用6x法先找出所有潜在的素数，再利用开根号法逐一筛选，相对慢些
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n < 4) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        int count = 2;
        int idx = 1;
        while (true) {
            if ((6 * idx - 1) < n) {
                if (isPrime(6 * idx - 1)) {
                    count++;
                }
            } else {
                return count;
            }
            if ((6 * idx + 1 < n)) {
                if (isPrime(6 * idx + 1)) {
                    count++;
                }
                idx++;
            } else {
                return count;
            }
        }
    }

    private boolean isPrime(int k) {
        if (k % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i < k; i += 2) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
