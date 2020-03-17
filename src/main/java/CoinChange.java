import java.util.*;

/**
 * Created on 2020/3/17.
 *
 * @author ray
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        if (amount == 0) {
            return 0;
        }
        int[] result = new int[amount];
        for (int i = 0; i < amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (coin > (i + 1)) {
                    break;
                }
                if (coin == i + 1) {
                    min = 1;
                    break;
                }
                if (i - coin >= 0 && result[i - coin] != -1) {
                    int value = result[i - coin] + 1;
                    if (min == -1) {
                        min = value;
                    } else {
                        min = Math.min(min, value);
                    }
                }
            }
            result[i] = min;
        }
        return result[amount - 1];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int i = coinChange(coins, 11);
        System.out.println(i);
    }
}
