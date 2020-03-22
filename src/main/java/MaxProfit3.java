import java.util.Arrays;

/**
 * Created on 2020/3/21.
 *
 * @author ray
 */
public class MaxProfit3 {

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i <= prices.length; i++) {
            int p;
            if (i != prices.length) {
                p = subProfit(Arrays.copyOfRange(prices, 0, i)) + subProfit(Arrays.copyOfRange(prices, i, prices.length));
            } else {
                p = subProfit(Arrays.copyOfRange(prices, 0, prices.length));
            }
            if (profit == 0 || profit < p) {
                profit = p;
            }
        }
        return profit;
    }

    public static int subProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int proift = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int p = price - min;
            if (p > 0 && p > proift) {
                proift = p;
            }
            if (price < min) {
                min = price;
            }
        }
        return proift;
    }

    public static void main(String[] args) {
        int[] p = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(p));
    }
}
