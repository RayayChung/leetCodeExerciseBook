/**
 * Created on 2020/3/21.
 *
 * @author ray
 */
public class MaxProfit1 {

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
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
}
